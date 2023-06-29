package com.kawal.malang.officer.presentation.giat.detail

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.PopupWindow
import androidx.recyclerview.widget.LinearLayoutManager
import com.faltenreich.skeletonlayout.Skeleton
import com.kawal.malang.officer.R
import com.kawal.malang.officer.core.util.AppPreference
import com.kawal.malang.officer.core.util.Util
import com.kawal.malang.officer.core.util.Util.arise
import com.kawal.malang.officer.core.util.Util.begone
import com.kawal.malang.officer.core.util.Util.bindImage
import com.kawal.malang.officer.core.util.Util.hideSkeleton
import com.kawal.malang.officer.data.model.PostResponse
import com.kawal.malang.officer.data.model.pengaduan.giat.GiatItem
import com.kawal.malang.officer.data.model.pengaduan.giat.KomentarItem
import com.kawal.malang.officer.databinding.ActivityDetailGiatBinding
import com.kawal.malang.officer.databinding.PopupGiatBinding
import com.kawal.malang.officer.presentation.giat.detail.komentar.KomentarAdapter
import com.kawal.malang.officer.presentation.giat.detail.komentar.KomentarContract
import com.kawal.malang.officer.presentation.giat.detail.komentar.KomentarPresenter
import com.kawal.malang.officer.presentation.giat.form.FormGiatActivity
import com.labters.lottiealertdialoglibrary.LottieAlertDialog

class DetailGiatActivity : AppCompatActivity(), DetailGiatContract, KomentarContract {
    private lateinit var binding: ActivityDetailGiatBinding
    lateinit var preference: AppPreference
    lateinit var skeleton: Skeleton
    lateinit var presenter: DetailGiatPresenter

    lateinit var komentarPresenter: KomentarPresenter

    lateinit var adapter: KomentarAdapter


    lateinit var menuBind : PopupGiatBinding
    lateinit var popupWindow : PopupWindow
    lateinit var loading: LottieAlertDialog

    var data= GiatItem();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailGiatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Util.setNotifBarColor(this, R.color.white,true)
        preference = AppPreference(this)
        presenter = DetailGiatPresenter(this, preference.getAuth());
        komentarPresenter = KomentarPresenter(this, preference.getAuth(), preference.getStoredGiat().id!!);

        skeleton = Util.skeletonButton(binding.ll)

        binding.apply {
            toolbar.tbBack.setOnClickListener { finish() }
            toolbar.tbTitle.text="Detail Giat"
        }
    }
    override fun onResume() {
        super.onResume()
        load()
    }

    fun load(){
        skeleton.showSkeleton();
        data=preference.getStoredGiat()
        preference.getStoredGiat().id?.let { presenter.loadGiat(it) }
    }

    @SuppressLint("SetTextI18n", "SuspiciousIndentation")
    override fun onLoad(data: GiatItem) {
        skeleton.hideSkeleton();
        this.data=data
        applyMenu()
        binding.apply {
            txTitle.text = data.judul
            imFoto.bindImage(this@DetailGiatActivity,data.foto)
            txKeterangan.text = data.deskripsi
            txTanggal.text =data.user?.name +"  •  "+ Util.showFullDate(data.createdAt)


            rv.layoutManager = LinearLayoutManager(this@DetailGiatActivity)
            adapter =  KomentarAdapter(this@DetailGiatActivity,data.komentar, komentarPresenter)
            rv.adapter = adapter

            txComment.text = adapter.items.size.toString()

            btSend.setOnClickListener {
                if(etComment.editText?.text.toString()!=""){
                    enableComment(false)
                    komentarPresenter.postKomentar(etComment.editText?.text.toString())

                }
            }
        }
    }

    override fun onDelete(message: String) {
        loading.dismiss()
        Util.setToast(this,message)
        finish()
    }

    fun enableComment(state:Boolean){
        with(binding){
            btSend.isEnabled = state
            etComment.isEnabled = state
        }
    }
    override fun onSubmit(data: KomentarItem) {
        enableComment(true)
        binding.etComment.editText?.setText("")

        adapter.items.add(data)
        adapter.notifyItemInserted(adapter.items.indexOf(data))

        binding.txComment.text = adapter.items.size.toString()

        binding.scrollView.post {
            binding.scrollView.fullScroll(View.FOCUS_DOWN)
        }
    }

    override fun onDelete(deleted: PostResponse<KomentarItem>) {
        enableComment(true)
        binding.etComment.editText?.setText("")
        val idx = adapter.items.map { it?.id }.indexOf(deleted.data?.id)
        adapter.items.removeAt(idx)
        binding.txComment.text = adapter.items.size.toString()
        adapter.notifyItemRemoved(idx)


    }

    override fun onFailedMessage(msg: String) {
        skeleton.hideSkeleton();
        Util.setAlert(this, msg)
    }

    fun applyMenu(){
//        if(preference.getStoredPengaduan().status?.lowercase()!="baru"){
//            binding.toolbar.tbMore.visibility= View.GONE
//            return
//        }
        binding.toolbar.tbMore.visibility= View.VISIBLE
        val(a,b) = Util.setupPopupView(this,binding.toolbar.tbMore, R.layout.popup_giat)
        menuBind = PopupGiatBinding.bind(a)
        popupWindow=b

        binding.toolbar.tbMore.setOnClickListener {
            popupWindow.showAsDropDown(it)
        }


//        if(preference.getStoredPengaduan().status?.lowercase()=="baru"){

            menuBind.btEdit.arise()
            menuBind.btDelete.arise()

            menuBind.btEdit.setOnClickListener {

                popupWindow.dismiss()
                val i = Intent(this, FormGiatActivity::class.java)
                i.putExtra("EDIT_ID", preference.getStoredGiat().id)
                startActivity(i)
            }
            menuBind.btDelete.setOnClickListener {
                Util.setAskDialog(this,"Hapus Giat","Yakin menghapus giat ini?","Hapus","Batal"){
                    loading.show()
                    preference.getStoredGiat().id?.let { it1 -> presenter.deleteGiat(it1) }
                }
            }

//        }else{
//            menuBind.btEdit.begone()
//            menuBind.btDelete.begone()
//
//        }
    }
}
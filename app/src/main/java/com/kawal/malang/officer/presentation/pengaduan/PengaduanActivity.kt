package com.kawal.malang.officer.presentation.pengaduan

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.faltenreich.skeletonlayout.Skeleton
import com.faltenreich.skeletonlayout.applySkeleton
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.kawal.malang.citizen.model.response.pengaduan.KategoriPengaduanItem
import com.kawal.malang.officer.R
import com.kawal.malang.officer.core.util.AppPreference
import com.kawal.malang.officer.core.util.AppUtil
import com.kawal.malang.officer.core.util.Util
import com.kawal.malang.officer.databinding.ActivityPengaduanBinding
import com.kawal.malang.officer.databinding.BsFilterPengaduanBinding
import java.util.*
import kotlin.collections.ArrayList
import com.kawal.malang.officer.core.util.PaginationListenerX
import com.kawal.malang.officer.core.util.Util.begone
import com.kawal.malang.officer.core.util.Util.hideSkeleton
import com.kawal.malang.officer.data.model.pengaduan.PengaduanItem

class PengaduanActivity : AppCompatActivity(), PengaduanContract {
    private lateinit var binding: ActivityPengaduanBinding

    lateinit var preference: AppPreference
    lateinit var adapter: PengaduanAdapter
    lateinit var skeleton: Skeleton
    lateinit var presenter: PengaduanPresenter

    var kategoriList:ArrayList<KategoriPengaduanItem> = ArrayList()
    var subkategoriList:ArrayList<KategoriPengaduanItem> = ArrayList()

    var lastPage=false
    var loading=false
    var lastId:Int? =null

    lateinit var bsd: BottomSheetDialog
    lateinit var bsBind: BsFilterPengaduanBinding
    private var c = Calendar.getInstance()

    var tempStatus:String? =null
    var tempTanggal:String? =null
    var tempkategoriId:Int? =null
    var tempsubkategoriId:Int? =null

    var status:String?=null
    var kategoriId:Int?=null
    var subkategoriId:Int?=null
    var tanggal:String? =null

    var nama:String?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPengaduanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Util.setNotifBarColor(this, R.color.primary_main,false)
        binding.tbBack.setOnClickListener { finish() }
        preference = AppPreference(this)
        presenter = PengaduanPresenter(this,preference.getAuth())

        skeleton = binding.rvPengaduan.applySkeleton(R.layout.item_pengaduan)
        skeleton = Util.skeletonSetup(skeleton)

        val manager = LinearLayoutManager(this)
        binding.rvPengaduan.layoutManager=manager
        binding.rvPengaduan.addOnScrollListener(object : PaginationListenerX(manager){
            override fun loadMoreItems() {
                if(!lastPage && !loading){
                    loading=true
                    loadList()
                }
            }

            override val isLastPage: Boolean
                get() = lastPage
            override val isLoading: Boolean
                get() = loading
        })

        binding.svSurat.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
            override fun onQueryTextSubmit(query: String): Boolean {
                nama = query
                initLoad()
                return false
            }
        })

        binding.swSurat.setOnRefreshListener {
            binding.swSurat.isRefreshing=false
            initLoad()
        }

        initBs()
        binding.cbProject.setOnClickListener {
            showBs()
        }
        binding.fbAdd.begone()
    }

    override fun onResume() {
        super.onResume()
        initLoad()
    }

    fun initLoad(){
        binding.llEmpty.visibility= View.GONE
        binding.rvPengaduan.visibility= View.VISIBLE
        skeleton.showSkeleton()
        lastId=null
        lastPage=false
        loadList()
        presenter.loadKategori()
    }
    fun loadList(){
        presenter.loadPengaduan(lastId,nama,kategoriId,subkategoriId,status,tanggal)
    }

    override fun onLoad(data: ArrayList<PengaduanItem>) {
        skeleton.hideSkeleton()
        loading=false
        if(data.isNotEmpty()){
            binding.rvPengaduan.visibility = View.VISIBLE
            binding.llEmpty.visibility = View.GONE

            if(lastId!=null){
                val temp = adapter.items.size
                adapter.items.addAll(data)
                adapter.items= adapter.items.distinct() as ArrayList<PengaduanItem>
                adapter.notifyItemRangeInserted(temp, data.size)
            }else{
                adapter= PengaduanAdapter(this, data)
                binding.rvPengaduan.adapter=adapter
            }
            lastId=data[data.lastIndex].id
        }else{
            lastPage=true
            if(lastId==null){
                binding.rvPengaduan.visibility= View.GONE
                binding.llEmpty.visibility= View.VISIBLE
            }

        }
    }

    override fun onLoadKategori(data: ArrayList<KategoriPengaduanItem>, isParent:Boolean) {
        if(isParent){
            kategoriList=data
            bsBind.spKategori.setItems(kategoriList.map{it.nama})
        }else{
            subkategoriList=data
            bsBind.spSubkategori.setItems(subkategoriList.map{it.nama})
        }


    }

    override fun onFailedMessage(msg: String) {
        skeleton.hideSkeleton()
        Util.setAlert(this,msg)
    }

    fun ifFilter(){
        binding.cbProject.isChecked=false
        if(status!=null){
            binding.cbProject.isChecked=true
        }
        if(tanggal!=null){
            binding.cbProject.isChecked=true
        }
        if(kategoriId!=null){
            binding.cbProject.isChecked=true
        }
        if(subkategoriId!=null){
            binding.cbProject.isChecked=true
        }
    }


    fun initBs(){
        val layoutInflater: LayoutInflater = this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val v = layoutInflater.inflate(R.layout.bs_filter_pengaduan, null)

        bsd = BottomSheetDialog(this, R.style.BottomSheetDialog)
        bsBind = BsFilterPengaduanBinding.bind(v)

        bsBind.btClose.setOnClickListener {
            bsd.dismiss()
        }
        bsd.setContentView(bsBind.root)
        bsd.setCanceledOnTouchOutside(true)
        bsd.setOnDismissListener {
            ifFilter()
        }
    }


    fun showBs(){
        bsd.show()

        bsBind.btDelDate.setOnClickListener {
            bsBind.txTanggal.setText("Pilih tanggal")
            tempTanggal = null
            bsBind.txTanggal.setBackgroundResource(R.drawable.radio_border);
            bsBind.txTanggal.setTextColor(resources.getColor(R.color.radio_textcolor))
        }

        bsBind.spKategori.setItems(kategoriList.map{it.nama})
        bsBind.spSubkategori.setItems(subkategoriList.map{it.nama})
        bsBind.spStatus.setItems(AppUtil.STATUS)
        bsBind.btDelStatus.setOnClickListener {
            bsBind.spStatus.selectItemByIndex(-1)
            bsBind.spStatus.clearSelectedItem()
            tempStatus=null
        }
        bsBind.btDelKategori.setOnClickListener {
            bsBind.spKategori.selectItemByIndex(-1)
            bsBind.spKategori.clearSelectedItem()
            tempkategoriId=null
        }
        bsBind.btDelSubkategori.setOnClickListener {
            bsBind.spSubkategori.selectItemByIndex(-1)
            bsBind.spSubkategori.clearSelectedItem()
            tempsubkategoriId=null
        }
        bsBind.btDelKategori.setOnClickListener {
            bsBind.spKategori.selectItemByIndex(-1)
            bsBind.spKategori.clearSelectedItem()
            tempkategoriId=null
        }


        bsBind.txTanggal.setOnClickListener  {
            val dpd = DatePickerDialog(this, { _, year, monthOfYear, dayOfMonth ->
                tempTanggal = Util.toYmd(year,(monthOfYear),dayOfMonth)
                bsBind.txTanggal.setText(Util.showDate(tempTanggal))

                bsBind.txTanggal.setBackgroundResource(R.drawable.border_primary);
                bsBind.txTanggal.setTextColor(resources.getColor(R.color.black));

                this.c.set(Calendar.YEAR,year)
                this.c.set(Calendar.MONTH,monthOfYear)
                this.c.set(Calendar.DAY_OF_MONTH,dayOfMonth)
            }, c.get(Calendar.YEAR), c.get(Calendar.MONTH),  c.get(Calendar.DAY_OF_MONTH))
            dpd.show()

            dpd.setOnCancelListener {
                bsBind.txTanggal.setText("Pilih tanggal")
                tempTanggal = null
                bsBind.txTanggal.setBackgroundResource(R.drawable.radio_border);
                bsBind.txTanggal.setTextColor(resources.getColor(R.color.radio_textcolor))
            }
        }
        bsBind.spStatus.setOnSpinnerItemSelectedListener<String> { oldIndex, oldItem, newIndex, newItem ->
            tempStatus = newItem
        }
        bsBind.spKategori.setOnSpinnerItemSelectedListener<String> { oldIndex, oldItem, newIndex, newItem ->

            tempkategoriId = kategoriList[newIndex].id
            presenter.loadKategori(tempkategoriId);
        }
        bsBind.spSubkategori.setOnSpinnerItemSelectedListener<String> { oldIndex, oldItem, newIndex, newItem ->
            tempsubkategoriId = subkategoriList[newIndex].id
        }


        bsBind.btApply.setOnClickListener {
            this.kategoriId = tempkategoriId
            this.subkategoriId = tempsubkategoriId
            this.tanggal = tempTanggal
            this.status = tempStatus
            bsd.dismiss()
            initLoad()
        }
    }
}
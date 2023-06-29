package com.kawal.malang.officer.presentation.pengaduan.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.PopupWindow
import com.faltenreich.skeletonlayout.Skeleton
import com.kawal.malang.officer.R
import com.kawal.malang.officer.core.util.AppPreference
import com.kawal.malang.officer.core.util.Util
import com.kawal.malang.officer.core.util.Util.begone
import com.kawal.malang.officer.core.util.Util.bindImage
import com.kawal.malang.officer.core.util.Util.hideSkeleton
import com.kawal.malang.officer.data.model.pengaduan.PengaduanItem
import com.kawal.malang.officer.databinding.ActivityDetailPengaduanBinding
import com.labters.lottiealertdialoglibrary.LottieAlertDialog

class DetailPengaduanActivity : AppCompatActivity(), DetailPengaduanContract {
    private lateinit var binding: ActivityDetailPengaduanBinding
    lateinit var preference: AppPreference
    lateinit var skeleton: Skeleton
    lateinit var presenter: DetailPengaduanPresenter




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPengaduanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Util.setNotifBarColor(this, R.color.white,false)
        preference = AppPreference(this)
        presenter = DetailPengaduanPresenter(this, preference.getAuth());

        skeleton = Util.skeletonButton(binding.ll)

        binding.apply {
            toolbar.tbBack.setOnClickListener { finish() }
            toolbar.tbTitle.text="Detail Pengaduan"

            sw.setOnRefreshListener {
                sw.isRefreshing=false
                load()
            }
        }
    }
    override fun onResume() {
        super.onResume()
        load()
    }

    fun load(){
        skeleton.showSkeleton();
        preference.getStoredPengaduan().id?.let { presenter.loadPengaduan(it) }
    }

    override fun onLoad(data: PengaduanItem) {
        skeleton.hideSkeleton();
        binding.apply {
            txTitle.text = data.judul
            txAlamat.text = data.tempatKejadian
            txKeterangan.text = data.keterangan
            txDate.text = Util.showFullDate(data.tanggal)
            imFoto.bindImage(this@DetailPengaduanActivity, data.foto)
        }
        applyMenu()
    }

    override fun onFailedMessage(msg: String) {
        skeleton.hideSkeleton();
        Util.setAlert(this, msg)
    }

    override fun onDelete(data: String) {

        Util.setToast(this,data)
        finish()
    }

    fun applyMenu(){


        binding.toolbar.tbMore.begone()

    }
}
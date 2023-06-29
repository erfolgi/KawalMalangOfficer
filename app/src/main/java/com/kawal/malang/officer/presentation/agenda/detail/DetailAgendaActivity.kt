package com.kawal.malang.officer.presentation.agenda.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.faltenreich.skeletonlayout.Skeleton
import com.kawal.malang.citizen.model.response.pengaduan.agenda.AgendaItem
import com.kawal.malang.officer.R
import com.kawal.malang.officer.core.util.AppPreference
import com.kawal.malang.officer.core.util.Util
import com.kawal.malang.officer.core.util.Util.bindImage
import com.kawal.malang.officer.core.util.Util.hideSkeleton
import com.kawal.malang.officer.databinding.ActivityDetailAgendaBinding

class DetailAgendaActivity : AppCompatActivity(), DetailAgendaContract {
    private lateinit var binding: ActivityDetailAgendaBinding
    lateinit var preference: AppPreference
    lateinit var skeleton: Skeleton
    lateinit var presenter: DetailAgendaPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailAgendaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Util.setNotifBarColor(this, R.color.white,false)
        preference = AppPreference(this)
        presenter = DetailAgendaPresenter(this, preference.getAuth());

        skeleton = Util.skeletonButton(binding.ll)

        binding.apply {
            toolbar.tbBack.setOnClickListener { finish() }
            toolbar.tbTitle.text="Detail Agenda"
        }
    }

    override fun onResume() {
        super.onResume()
        load()
    }

    fun load(){
        skeleton.showSkeleton();
        preference.getStoredAgenda().id?.let { presenter.loadAgenda(it) }
    }

    override fun onLoad(data: AgendaItem) {
        skeleton.hideSkeleton();
        binding.apply {
            txTitle.text = data.judul
            imFoto.bindImage(this@DetailAgendaActivity,data.foto)
            txKeterangan.text = data.deskripsi
            txTanggal.visibility = View.GONE

        }
    }

    override fun onFailedMessage(msg: String) {
        skeleton.hideSkeleton();
        Util.setAlert(this, msg)
    }
}
package com.kawal.malang.officer.presentation.bantuan

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kawal.malang.citizen.ui.bantuan.BantuanConst
import com.kawal.malang.citizen.ui.bantuan.PresisiAdapter
import com.kawal.malang.officer.R
import com.kawal.malang.officer.core.util.AppPreference
import com.kawal.malang.officer.databinding.ActivityBantuanBinding
import com.kawal.malang.officer.presentation.lokasi.LokasiActivity

class BantuanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBantuanBinding

    lateinit var preference: AppPreference
    lateinit var adapter: PresisiAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBantuanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            toolbar.tbBack.setOnClickListener { finish() }
            toolbar.tbTitle.text="Menu Bantuan"

            adapter= PresisiAdapter(this@BantuanActivity, BantuanConst.presisiList)
            rvPresisi.adapter=adapter
        }
//        binding.btPengaduan.setOnClickListener {
//            val i = Intent(this@BantuanActivity, PengaduanActivity::class.java)
//            startActivity(i)
//        }

        binding.btLokasi.setOnClickListener {
            val i = Intent(this@BantuanActivity, LokasiActivity::class.java)
            startActivity(i)
        }
        binding.btCall.setOnClickListener {
            val phone = "110"
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
            startActivity(intent)
        }
    }
}
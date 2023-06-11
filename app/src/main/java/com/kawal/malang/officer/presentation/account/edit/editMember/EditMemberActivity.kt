package com.kawal.malang.officer.presentation.account.edit.editMember

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.kawal.malang.officer.core.util.AppUtil
import com.kawal.malang.officer.core.util.Resource
import com.kawal.malang.officer.data.model.auth.LoginData
import com.kawal.malang.officer.databinding.ActivityEditMemberBinding
import com.kawal.malang.officer.presentation.viewmodels.account.AccountViewModel
import com.kawal.malang.officer.presentation.viewmodels.account.AccountViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class EditMemberActivity : AppCompatActivity() {

    companion object {
        const val DATA = "DATA"
    }

    private lateinit var binding: ActivityEditMemberBinding
    private lateinit var viewModel: AccountViewModel
    private lateinit var dialog: Dialog

    @Inject
    lateinit var factory: AccountViewModelFactory

    private var data: LoginData? = null
    private val body = hashMapOf<String, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditMemberBinding.inflate(layoutInflater)
        setContentView(binding.root)
        data = intent.getParcelableExtra(DATA)
        viewModel = ViewModelProvider(this, factory)[AccountViewModel::class.java]
        dialog = AppUtil.loading(this)

        initAppBar()
        loadData()

        binding.apply {
            btnSave.setOnClickListener {
                val name = "${etName.editText?.text}"
                val nip = "${etNip.editText?.text}"
                val rank = "${etRank.editText?.text}"
                val phone = "${etPhone.editText?.text}"
                if (name.isNotEmpty() || nip.isNotEmpty() || rank.isNotEmpty() || phone.isNotEmpty()) {
                    body["name"] = name
                    body["telepon"] = phone
                    body["nip"] = nip
                    body["pangkat"] = rank
                    doUpdateMember()
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initAppBar() {
        this.window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)
        binding.appbar.apply {
            tbBack.setOnClickListener { finish() }
            tbTitle.text = "Edit Profil"
        }
    }

    private fun loadData() {
        binding.apply {
            etName.editText?.setText(data?.name)
            etNip.editText?.setText(data?.member?.nip)
            etPhone.editText?.setText(data?.phone)
            etRank.editText?.setText(data?.member?.rank)
        }
    }

    private fun doUpdateMember() {
        viewModel.updateMember(body)
        viewModel.update.observe(this) { res ->
            when (res) {
                is Resource.Loading -> showLoading()
                is Resource.Error -> {
                    hideLoading()
                    res.message?.let { AppUtil.snackBar(this, it) }
                }
                is Resource.NetworkError -> {
                    hideLoading()
                    res.message?.let {
                        AppUtil.snackBarAction(this, it, "Try Again") {
                            doUpdateMember()
                        }
                    }
                }
                is Resource.Success -> {
                    hideLoading()
                    res.data?.let {
                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
            }
        }
    }

    private fun showLoading() = dialog.show()

    private fun hideLoading() = dialog.dismiss()
}
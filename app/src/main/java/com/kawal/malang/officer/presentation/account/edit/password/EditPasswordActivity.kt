package com.kawal.malang.officer.presentation.account.edit.password

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.kawal.malang.officer.core.util.AppUtil
import com.kawal.malang.officer.core.util.Resource
import com.kawal.malang.officer.databinding.ActivityEditPasswordBinding
import com.kawal.malang.officer.presentation.viewmodels.account.AccountViewModel
import com.kawal.malang.officer.presentation.viewmodels.account.AccountViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class EditPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditPasswordBinding
    private lateinit var viewModel: AccountViewModel
    private lateinit var dialog: Dialog

    @Inject
    lateinit var factory: AccountViewModelFactory

    private val body = hashMapOf<String, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, factory)[AccountViewModel::class.java]
        dialog = AppUtil.loading(this)

        initAppBar()

        binding.apply {
            btnSave.setOnClickListener {
                val oldPassword = "${etOldPassword.editText?.text}"
                val newPassword = "${etNewPassword.editText?.text}"
                val passwordConfirm = "${etPasswordConfirm.editText?.text}"
                if (oldPassword.isEmpty() && newPassword.isEmpty() && passwordConfirm.isEmpty()) {
                    etOldPassword.error = "Must be filled"
                    etNewPassword.error = "Must be filled"
                    etPasswordConfirm.error = "Must be filled"
                } else if (newPassword != passwordConfirm) {
                    etOldPassword.error = null
                    etNewPassword.error = "Password is not match"
                    etPasswordConfirm.error = "Password is not match"
                } else {
                    body["password_lama"] = oldPassword
                    body["password_baru"] = newPassword
                    body["password_konfirmasi"] = passwordConfirm
                    doUpdatePassword()
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initAppBar() {
        this.window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)
        binding.appbar.apply {
            tbTitle.text = "Edit Password"
            tbBack.setOnClickListener { finish() }
        }
    }

    private fun doUpdatePassword() {
        viewModel.updatePassword(body)
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
                            doUpdatePassword()
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
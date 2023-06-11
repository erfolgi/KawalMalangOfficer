package com.kawal.malang.officer.presentation.account.edit.editCar

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.kawal.malang.officer.core.util.AppUtil
import com.kawal.malang.officer.core.util.Resource
import com.kawal.malang.officer.databinding.ActivityEditCarBinding
import com.kawal.malang.officer.presentation.viewmodels.account.AccountViewModel
import com.kawal.malang.officer.presentation.viewmodels.account.AccountViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class EditCarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditCarBinding
    private lateinit var viewModel: AccountViewModel
    private lateinit var dialog: Dialog

    @Inject
    lateinit var factory: AccountViewModelFactory

    private val body = hashMapOf<String, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditCarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, factory)[AccountViewModel::class.java]
        dialog = AppUtil.loading(this)

        initAppBar()

        binding.apply {
            btnSave.setOnClickListener {
                val carNumber = etCarNumber.editText?.text?.toString() ?: ""
                val brand = etBrand.editText?.text?.toString() ?: ""
                val desc = etDescription.editText?.text?.toString() ?: ""
                btnSave.isEnabled = true
                body["nopol"] = carNumber
                body["merk"] = brand
                body["deskripsi"] = desc
                doUpdateCar()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        textFieldWatcher()
    }

    @SuppressLint("SetTextI18n")
    private fun initAppBar() {
        this.window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)
        binding.appbar.apply {
            tbBack.setOnClickListener { finish() }
            tbTitle.text = "Edit Profil"
        }
    }

    private fun doUpdateCar() {
        viewModel.updateCar(body)
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
                            doUpdateCar()
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

    private fun textFieldWatcher() {
        binding.apply {
            etCarNumber.editText?.addTextChangedListener(object: TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    btnSave.isEnabled = true
                }

                override fun afterTextChanged(p0: Editable?) {

                }
            })
            etBrand.editText?.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    btnSave.isEnabled = true
                }

                override fun afterTextChanged(p0: Editable?) {

                }
            })
            etDescription.editText?.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    btnSave.isEnabled = true
                }

                override fun afterTextChanged(p0: Editable?) {

                }
            })
        }
    }

    private fun showLoading() = dialog.show()

    private fun hideLoading() = dialog.dismiss()
}
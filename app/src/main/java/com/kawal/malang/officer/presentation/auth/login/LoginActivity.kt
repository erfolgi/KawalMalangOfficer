package com.kawal.malang.officer.presentation.auth.login

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.kawal.malang.officer.core.util.AppPreference
import com.kawal.malang.officer.core.util.AppUtil
import com.kawal.malang.officer.core.util.Resource
import com.kawal.malang.officer.data.model.auth.LoginData
import com.kawal.malang.officer.databinding.ActivityLoginBinding
import com.kawal.malang.officer.presentation.DashboardActivity
import com.kawal.malang.officer.presentation.viewmodels.auth.AuthViewModel
import com.kawal.malang.officer.presentation.viewmodels.auth.AuthViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: AuthViewModel
    private lateinit var pref: AppPreference
    private lateinit var dialog: Dialog
    @Inject
    lateinit var viewModelFactory: AuthViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)
        viewModel = ViewModelProvider(this, viewModelFactory)[AuthViewModel::class.java]
        pref = AppPreference(this)
        dialog = AppUtil.loading(this)
        binding.apply {
            btnLogin.setOnClickListener {
                val email = "${etUsername.editText?.text}"
                val password = "${etPassword.editText?.text}"
                if (email.isEmpty()) etUsername.error = "Please fill username"
                if (password.isEmpty()) etPassword.error = "Please fill password"
                if (email.isNotEmpty() && password.isNotEmpty()) {
                    etPassword.isErrorEnabled = false
                    val map = HashMap<String, String>()
                    map["username"] = email
                    map["password"] = password
                    doLogin(map)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        editTextListener()
    }

    private fun editTextListener() {
        binding.apply {
            etUsername.editText?.addTextChangedListener(object: TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    etUsername.isErrorEnabled = false
                }

                override fun afterTextChanged(p0: Editable?) {

                }

            })
            etPassword.editText?.addTextChangedListener(object: TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    etPassword.isErrorEnabled = false
                }

                override fun afterTextChanged(p0: Editable?) {

                }

            })
        }
    }

    private fun doLogin(map: Map<String, String>) {
        viewModel.doLogin(map)
        viewModel.loginData.observe(this) { res ->
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
                            viewModel.doLogin(map)
                        }
                    }
                }
                is Resource.Success -> {
                    hideLoading()
                    res.data?.let { response -> response.data?.let { successLogin(it) } }
                }
            }
        }
    }

    private fun successLogin(loginData: LoginData) {
        pref.setAuth(loginData.jwt ?: "")
        pref.setRole(loginData)

        if(pref.getRole()=="car"){
            val i = Intent(this, DashboardActivity::class.java)
            startActivity(i)
            finish()
        }else{
            val i = Intent(this, DashboardActivity::class.java)
            startActivity(i)
            finish()
        }

    }

    private fun showLoading() { dialog.show() }

    private fun hideLoading() { dialog.dismiss() }
}
package com.kawal.malang.officer.presentation.account.profile

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.kawal.malang.officer.R
import com.kawal.malang.officer.core.util.AppPreference
import com.kawal.malang.officer.core.util.AppUtil
import com.kawal.malang.officer.core.util.Resource
import com.kawal.malang.officer.data.model.auth.LoginData
import com.kawal.malang.officer.data.model.auth.MemberData
import com.kawal.malang.officer.databinding.FragmentProfileBinding
import com.kawal.malang.officer.databinding.OfficerListBinding
import com.kawal.malang.officer.databinding.OfficerSelectorItemBinding
import com.kawal.malang.officer.presentation.DashboardActivity
import com.kawal.malang.officer.presentation.account.edit.editCar.EditCarActivity
import com.kawal.malang.officer.presentation.account.edit.editMember.EditMemberActivity
import com.kawal.malang.officer.presentation.account.edit.password.EditPasswordActivity
import com.kawal.malang.officer.presentation.auth.login.LoginActivity
import com.kawal.malang.officer.presentation.patrol.history.PatrolHistoryActivity
import com.kawal.malang.officer.presentation.report.panicHistory.PanicHistoryActivity
import com.kawal.malang.officer.presentation.viewmodels.account.AccountViewModel
import com.kawal.malang.officer.presentation.viewmodels.account.AccountViewModelFactory
import com.kawal.malang.officer.presentation.viewmodels.auth.AuthViewModel
import com.kawal.malang.officer.presentation.viewmodels.auth.AuthViewModelFactory
import com.kawal.malang.officer.presentation.viewmodels.patrol.PatrolViewModel
import com.kawal.malang.officer.presentation.viewmodels.patrol.PatrolViewModelFactory
import com.github.dhaval2404.imagepicker.ImagePicker
import dagger.hilt.android.AndroidEntryPoint
import java.io.File
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var officerListBinding: OfficerListBinding
    private lateinit var patrolOfficerItemBinding: OfficerSelectorItemBinding
    private lateinit var viewModel: AuthViewModel
    private lateinit var accountViewModel: AccountViewModel
    private lateinit var patrolViewModel: PatrolViewModel
    private lateinit var dialog: Dialog
    private lateinit var officerDialog: Dialog
    private lateinit var pref: AppPreference
    private lateinit var data: LoginData

    @Inject
    lateinit var viewModelFactory: AuthViewModelFactory
    @Inject
    lateinit var accountFactory: AccountViewModelFactory
    @Inject
    lateinit var patrolFactory: PatrolViewModelFactory
    @Inject
    lateinit var patrolOfficerAdapter: PatrolOfficerAdapter

    private var officers: ArrayList<MemberData> = arrayListOf()
    private val body: ArrayList<String> = arrayListOf()
    private var file: File? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)
        dialog = AppUtil.loading((requireActivity()))
        pref = AppPreference(binding.root.context)
        /*(requireActivity()).window.statusBarColor = ContextCompat.getColor(
            binding.root.context, R.color.primary_main)*/
        initViewModels()
        initOfficerDialog()
        binding.apply {

            btnPanicHistory.setOnClickListener {
                val i = Intent(root.context, PanicHistoryActivity::class.java)
                root.context.startActivity(i)
            }
        }
        binding.btnLogout.setOnClickListener { doLogout() }
        binding.apply {

            btnProfileEdit.setOnClickListener {
                val intent = Intent(root.context, EditCarActivity::class.java)
                val intentOfficer = Intent(root.context, EditMemberActivity::class.java)
                if (pref.isOfficer()) {
                    intentOfficer.putExtra(EditMemberActivity.DATA, data)
                    root.context.startActivity(intentOfficer)
                }
                else root.context.startActivity(intent)
            }
            btnPasswordEdit.setOnClickListener {
                val intent = Intent(root.context, EditPasswordActivity::class.java)
                root.context.startActivity(intent)
            }
        }
        binding.btnEditPhoto.setOnClickListener { takeImage() }
        handleSwitch()
    }



    private fun initViewModels() {
        viewModel = ViewModelProvider((requireActivity()),
            viewModelFactory)[AuthViewModel::class.java]
        accountViewModel = ViewModelProvider((requireActivity()),
            accountFactory)[AccountViewModel::class.java]
        patrolViewModel = ViewModelProvider((requireActivity()),
            patrolFactory)[PatrolViewModel::class.java]
    }

    private fun initOfficerDialog() {
        officerDialog = Dialog((requireActivity()))
        officerDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val inflater = LayoutInflater.from((requireActivity()))
        patrolOfficerItemBinding = OfficerSelectorItemBinding.inflate(inflater)
        officerListBinding = OfficerListBinding.inflate(inflater)
        officerDialog.setContentView(officerListBinding.root)
        officerListBinding.apply {
            rvPatrolOfficer.adapter = patrolOfficerAdapter
            rvPatrolOfficer.layoutManager = LinearLayoutManager(root.context)
            etSearch.editText?.setOnEditorActionListener { textView, i, _ ->
                if (i == EditorInfo.IME_ACTION_DONE) {
                    getOfficerList("${textView.text}")
                    return@setOnEditorActionListener true
                }
                return@setOnEditorActionListener false
            }
        }
    }

    private fun checkIfOfficerIsLogin() {
        binding.apply {
            if (pref.isOfficer()) {

                panicHistory.visibility = GONE
                tvCarNumber.text = data.name
                tvUsername.text = data.member?.nip ?: "Undefined"
                patrolSection.visibility = GONE
            }
        }
    }


    @SuppressLint("SetTextI18n")
    private fun handleSwitch() {

    }

    private var launchResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val data = result.data
        when (result.resultCode) {
            Activity.RESULT_OK -> {
                file = File(data?.data?.path ?: "")
                doUpdatePhoto()
            }
            ImagePicker.RESULT_ERROR -> {
                Toast.makeText(binding.root.context, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
            }
            else -> Toast.makeText(binding.root.context, "Picture not taken", Toast.LENGTH_SHORT).show()
        }
    }

    private fun takeImage() {
        ImagePicker.with(this)
            .compress(300)
            .createIntent { launchResult.launch(it) }
    }

    private fun getProfile() {
        accountViewModel.getProfile()
        accountViewModel.profile.observe(viewLifecycleOwner) { res ->
            when (res) {
                is Resource.Loading -> showLoading()
                is Resource.Error -> {
                    hideLoading()
                    res.message?.let { AppUtil.snackBar((requireActivity()), it) }
                }
                is Resource.NetworkError -> {
                    hideLoading()
                    res.message?.let {
                        AppUtil.snackBarAction((requireActivity()), it, "Try Again") {
                            getProfile()
                        }
                    }
                }
                is Resource.Success -> {
                    hideLoading()
                    res.data?.let { loadContent(it) }
                }
            }
        }
    }



    private fun getOfficerList(search: String = "") {
        officerListBinding.apply {
            patrolViewModel.getMembers(search)
            patrolViewModel.members.observe(viewLifecycleOwner) { res ->
                when(res) {
                    is Resource.Loading -> {
                        rvPatrolOfficer.visibility = GONE
                        tvLoading.visibility = VISIBLE
                    }
                    is Resource.Error -> {
                        res.message?.let { AppUtil.snackBar((requireActivity()), it) }
                    }
                    is Resource.NetworkError -> {
                        res.message?.let {
                            AppUtil.snackBarAction((requireActivity()), it, "Try Again") {
                                getOfficerList()
                            }
                        }
                    }
                    is Resource.Success -> res.data?.let { loadOfficerList(this, it) }
                }
            }
        }
    }



    private fun doUpdatePhoto() {
        file?.let { accountViewModel.updatePhoto(it) }
        accountViewModel.update.observe(viewLifecycleOwner) { res ->
            when (res) {
                is Resource.Loading -> showLoading()
                is Resource.Error -> {
                    hideLoading()
                    res.message?.let { AppUtil.snackBar((activity as DashboardActivity), it) }
                }
                is Resource.NetworkError -> {
                    hideLoading()
                    res.message?.let {
                        AppUtil.snackBarAction((activity as DashboardActivity), it, "Try Again") {
                            doUpdatePhoto()
                        }
                    }
                }
                is Resource.Success -> {
                    hideLoading()
                    res.data?.let {
                        AppUtil.snackBar((activity as DashboardActivity), it.message ?: "Undefined", false)
                        getProfile()
                    }
                }
            }
        }
    }

    private fun doLogout() {
        //Proto Service


//        if (pref.getPatrolStatus())
        viewModel.doLogout()
        viewModel.logoutData.observe(viewLifecycleOwner) { res ->
            when (res) {
                is Resource.Loading -> showLoading()
                is Resource.Error -> {
                    hideLoading()
                    res.message?.let { AppUtil.snackBar((requireActivity()), it) }
                }
                is Resource.NetworkError -> {
                    hideLoading()
                    res.message?.let {
                        AppUtil.snackBarAction((requireActivity()), it, "Try Again") {
                            doLogout()
                        }
                    }
                }
                is Resource.Success -> {
                    hideLoading()
                    res.data?.message?.let { logoutSuccess(it) }
                }
            }
        }
    }

    private fun loadContent(data: LoginData) {
        this.data = data
        binding.apply {
            Glide.with(ivProfile.context)
                .load(data.photo)
                .into(ivProfile)
            tvCarNumber.text = data.car?.carNumber
            tvUsername.text = data.username ?: "Undefined"
            checkIfOfficerIsLogin()
        }
    }

    private fun loadOfficerList(binding: OfficerListBinding, list: ArrayList<MemberData>) {
        binding.apply {
            tvLoading.visibility = GONE
            patrolOfficerAdapter.differ.submitList(list)
            rvPatrolOfficer.visibility = VISIBLE
            val window = officerDialog.window
            window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT)
            officerAdapterListener()
            btnConfirm.setOnClickListener {
                if (officers.isNotEmpty()) {
                    //Proto Service

                    //(activity as DashboardActivity).startPatrol()
                }
                else Toast.makeText(root.context, "Petugas harus dipilih", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun officerAdapterListener() {
        patrolOfficerAdapter.setOnClickListener(object: PatrolOfficerAdapter.SelectorTapListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun tap(binding: OfficerSelectorItemBinding, member: MemberData) {
                binding.apply {
                    if (officers.contains(member)) {
                        cbOfficer.setImageDrawable(ContextCompat.getDrawable(root.context,
                            R.drawable.ic_checkbox_empty))
                        cvOfficer.setCardBackgroundColor(ContextCompat.getColor(root.context,
                            R.color.white))
                        officers.remove(member)
                    } else {
                        cbOfficer.setImageDrawable(ContextCompat.getDrawable(root.context,
                            R.drawable.ic_checkbox_fill))
                        cvOfficer.setCardBackgroundColor(ContextCompat.getColor(root.context,
                            R.color.primary_surface))
                        officers.add(member)
                    }
                }
            }
        })
    }

    private fun logoutSuccess(message: String) {
        pref.deleteAuth()
        pref.setPatrolStatus(false)
        Toast.makeText(binding.root.context, message, Toast.LENGTH_SHORT).show()
        val i = Intent(binding.root.context, LoginActivity::class.java)
        binding.root.context.startActivity(i)
        (requireActivity()).finish()
    }

    private fun showLoading() { dialog.show() }

    private fun hideLoading() { dialog.dismiss() }
}
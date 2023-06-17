package com.kawal.malang.officer.presentation.report.detail

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.Window
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.kawal.malang.officer.R
import com.kawal.malang.officer.core.util.AppUtil
import com.kawal.malang.officer.core.util.Resource
import com.kawal.malang.officer.data.model.panic.report.PanicReportData
import com.kawal.malang.officer.databinding.*
import com.kawal.malang.officer.presentation.panicevent.TimelineAdapter
import com.kawal.malang.officer.presentation.viewmodels.panic.PanicViewModel
import com.kawal.malang.officer.presentation.viewmodels.panic.PanicViewModelFactory
import com.github.dhaval2404.imagepicker.ImagePicker
import com.github.dhaval2404.imagepicker.ImagePicker.Companion.getError
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.kawal.malang.officer.core.service.prototype.LocationService
import com.kawal.malang.officer.core.util.AppPreference
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapController
import org.osmdroid.views.overlay.Marker
import java.io.File
import java.io.InputStream
import java.net.URL
import javax.inject.Inject


@AndroidEntryPoint
class DetailReportActivity : AppCompatActivity() {

    companion object {
        const val DETAIL_DATA = "DETAIL_DATA"
        const val ID = "ID"
    }

    private lateinit var binding: ActivityDetailReportBinding
    private lateinit var finishPanicBinding: FinishPanicDialogBinding
    private lateinit var timelineBsdBinding: PanicTimelineBsdBinding
    private lateinit var ratingBsdBinding: RatingBsdBinding
    private lateinit var viewModel: PanicViewModel
    private lateinit var dialog: Dialog
    private lateinit var finishDialog: Dialog
    private lateinit var mapController: MapController
    private lateinit var geoPoint: GeoPoint
    private lateinit var bsdTimeline: BottomSheetDialog
    private lateinit var preference: AppPreference
    @Inject
    lateinit var policeCarAdapter: PoliceCarAdapter
    @Inject
    lateinit var detailOfficerAdapter: DetailOfficerAdapter
    @Inject
    lateinit var viewModelFactory: PanicViewModelFactory
    @Inject
    lateinit var timelineAdapter: TimelineAdapter

    private var data: PanicReportData? = null
    private var file: File? = null
    private val body = hashMapOf<String, RequestBody>()
    private var id = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailReportBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, viewModelFactory)[PanicViewModel::class.java]
        dialog = AppUtil.loading(this)
        data = intent.getParcelableExtra(DETAIL_DATA)
        id = intent.getIntExtra(ID, 0)
        preference = AppPreference(this)
        initAppBar()
        initRecyclerView()
        initFinishPanicDialog()
        if (id != 0) refreshDetail(id)
        else refreshDetail(data?.id ?: 0)
        initTimelineDialog()

        binding.apply {
            btnGo.setOnClickListener { respondToPanic() }
            btnFinish.setOnClickListener { finishPanic() }
            btnTimeline.setOnClickListener {
                initTimelineDialog()
                bsdTimeline.show()
            }
        }
    }

    private var launchResult = registerForActivityResult(StartActivityForResult()) { result ->
        val data = result.data
        when (result.resultCode) {
            Activity.RESULT_OK -> {
                file = File(data?.data?.path ?: "")
                finishPanicBinding.apply {
                    Glide.with(ivReport.context)
                        .load(file)
                        .centerCrop()
                        .into(ivReport)
                    ivReport.visibility = VISIBLE
                    btnUpload.visibility = GONE
                }
            }
            ImagePicker.RESULT_ERROR -> {
                Toast.makeText(this, getError(data), Toast.LENGTH_SHORT).show()
            }
            else -> Toast.makeText(this, "Picture not taken", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initAppBar() {
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        binding.apply {
            appbar.tbTitle.text = "Detail Laporan Panik"
            appbar.tbBack.setOnClickListener { finish() }
        }
    }

    private fun initRecyclerView() {
        binding.apply {
            policeCarAdapter.differ.submitList(data?.panicCar)
            patrolCarReport.rvPoliceCar.adapter = policeCarAdapter
            patrolCarReport.rvPoliceCar.layoutManager = LinearLayoutManager(root.context)
            policeCarAdapter.setOnClickListener(object : PoliceCarAdapter.PatrolCarClickListener {
                override fun tap(binding: PatrolCarItemBinding, position: Int) {
                    val pBinding = binding
                    pBinding.apply {
                        detailOfficerAdapter.differ.submitList(
                            data?.panicCar?.get(position)?.patrol?.member)
                        rvOfficer.adapter = detailOfficerAdapter
                        rvOfficer.layoutManager = LinearLayoutManager(root.context)
                        if (rvOfficer.visibility == GONE) {
                            rvOfficer.visibility = VISIBLE
                            ivArrow.setImageDrawable(ContextCompat.getDrawable(root.context,
                                R.drawable.ic_chevron_up))
                        }
                        else {
                            rvOfficer.visibility = GONE
                            ivArrow.setImageDrawable(ContextCompat.getDrawable(root.context,
                                R.drawable.ic_chevron_down))
                        }
                    }
                }
            })
        }
    }

    private fun initFinishPanicDialog() {
        finishDialog = Dialog(this)
        finishDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val inflater = LayoutInflater.from(this)
        finishPanicBinding = FinishPanicDialogBinding.inflate(inflater)
        finishDialog.setContentView(finishPanicBinding.root)
        finishPanicBinding.apply {
            btnUpload.setOnClickListener { takeImage() }
            ivReport.setOnClickListener { takeImage() }
            btnFinish.setOnClickListener {
                val desc = "${etDescription.editText?.text}"
                when {
                    desc.isEmpty() -> etDescription.editText?.error = "Description must be filled"
                    file == null -> {
                        Toast.makeText(root.context, "Photo must not be empty", Toast.LENGTH_SHORT).show()
                    }
                    else -> {
                        body["laporan_petugas"] = RequestBody.create(MultipartBody.FORM, desc)
                        finishPanic()
                    }
                }
            }
        }
    }

    private fun initTimelineDialog() {
        val inflater = LayoutInflater.from(this)
        timelineBsdBinding = PanicTimelineBsdBinding.inflate(inflater)
        bsdTimeline = BottomSheetDialog(this, R.style.BottomSheetDialog)
        bsdTimeline.setContentView(timelineBsdBinding.root)

        timelineBsdBinding.apply {
            btnClose.setOnClickListener { bsdTimeline.dismiss() }
            rvTimeline.adapter = timelineAdapter
            rvTimeline.layoutManager = LinearLayoutManager(root.context)
        }
    }

    private fun initRatingDialog() {
        val inflater = LayoutInflater.from(this)
        ratingBsdBinding = RatingBsdBinding.inflate(inflater)
        bsdTimeline = BottomSheetDialog(this, R.style.BottomSheetDialog)
        bsdTimeline.setContentView(ratingBsdBinding.root)

        ratingBsdBinding.apply {
            btnClose.setOnClickListener { bsdTimeline.dismiss() }
            tvDesc.text = data?.ratingDesc
            ratingBar.rating = data?.rating?.toFloat() ?: 0F
        }
    }

    private fun initMap(marker: Marker) {
        mapController = binding.descReport.mapView.controller as MapController
        mapController.setZoom(20.0)
        mapController.setCenter(geoPoint)
        binding.descReport.mapView.setMultiTouchControls(false)
        binding.descReport.mapView.overlays.add(marker)
        marker.setOnMarkerClickListener { _, _ ->
            val url = "https://maps.google.com/maps?q=loc:${data?.latitude},${data?.longitude}"
//                    "&daddr=${data?.panicCar?.first()?.car?.latitude},${data?.panicCar?.first()?.car?.longitude}"
            val uri = Uri.parse(url)
            val mapIntent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(mapIntent)
            true
        }
    }

    private fun loadReporterMarker() {
        lifecycleScope.launch(Dispatchers.IO) {

//            if(data?.category?.markerIcon == null){
//
//            }else{
            val url = URL(data?.category?.markerIcon)
            Log.d("PostASDsdfsdf",data?.category?.markerIcon.toString())
            Log.d("PostASDsdfsdf",url.toString())
//            val drawable = Drawable.createFromStream(url.content as InputStream, "Db")
//            val bmp = (drawable as BitmapDrawable).bitmap

//            val dr = BitmapDrawable(resources, Bitmap.createScaledBitmap(bmp, 80, 120, true))
            val marker = Marker(binding.descReport.mapView)
            geoPoint = GeoPoint(data?.latitude ?: 0.0, data?.longitude ?: 0.0)
            marker.title = data?.category?.name
            marker.snippet = data?.eventDescription
            //marker.icon = ContextCompat.getDrawable(baseContext, R.drawable.ic_loc)
            marker.position = geoPoint


            Glide.with(baseContext)
                .asBitmap()
                .load(data?.category?.markerIcon)
                .into(object : CustomTarget<Bitmap>(80,108){
                    override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
//                    res = resource
                        marker.icon = BitmapDrawable(baseContext.resources, resource)

                    }
                    override fun onLoadCleared(placeholder: Drawable?) {
                        // this is called when imageView is cleared on lifecycle call or for
                        // some other reason.
                        // if you are referencing the bitmap somewhere else too other than this imageView
                        // clear it here as you can no longer have the bitmap
                    }
                })

            binding.descReport.mapView.overlays.add(marker)
            withContext(Dispatchers.Main) { initMap(marker) }
//            }


        }
    }

    private fun loadContent() {
        binding.apply {
            tvDate.text = AppUtil.convertDateTime(data?.createdAt)
            Glide.with(ivImage.context)
                .load(data?.photo)
                .into(ivImage)
            Glide.with(ivCategory.context)
                .load(data?.category?.icon)
                .into(ivCategory)
            tvCategory.text = data?.category?.name
            tvStatus.text = data?.status
            descReport.tvDescription.text = data?.eventDescription
            descReport.tvPlace.text = AppUtil.reverseGeocode(
                data?.latitude ?: 0.0,
                data?.longitude ?: 0.0,
                root.context
            )
        }
        handleTab()
    }

    private fun handleTab() {
        binding.apply {
            cvTab.setOnClickListener {
                cvTab.setCardBackgroundColor(ContextCompat.getColor(root.context, R.color.white))
                cvTab2.setCardBackgroundColor(ContextCompat.getColor(root.context, R.color.grey4))
                tvTab.setTextColor(ContextCompat.getColor(root.context, R.color.primary_base))
                tvTab2.setTextColor(ContextCompat.getColor(root.context, R.color.grey3))
                descReport.root.visibility = VISIBLE
                patrolCarReport.root.visibility = GONE
            }
            cvTab2.setOnClickListener {
                cvTab.setCardBackgroundColor(ContextCompat.getColor(root.context, R.color.grey4))
                cvTab2.setCardBackgroundColor(ContextCompat.getColor(root.context, R.color.white))
                tvTab.setTextColor(ContextCompat.getColor(root.context, R.color.grey3))
                tvTab2.setTextColor(ContextCompat.getColor(root.context, R.color.primary_base))
                descReport.root.visibility = GONE
                patrolCarReport.root.visibility = VISIBLE
            }
        }
    }

    private fun checkButtonCondition() {
        binding.apply {
            if (data?.status == "ditangani") {
                btnGo.visibility = GONE
                btnFinish.visibility = VISIBLE
            } else if (data?.status == "selesai") {
                btnGo.visibility = GONE
                btnFinish.visibility = GONE
                btnRating.visibility = VISIBLE
                btnRating.setOnClickListener {
                    initRatingDialog()
                    bsdTimeline.show()
                }
            }
        }
    }

    private fun checkIfPanicIsDone() {
        binding.apply {
            if (data?.status == "selesai") {
                descReport.tvActionDesc.text = data?.officerReport
                Glide.with(descReport.ivActionDesc.context)
                    .load(data?.officerPhoto)
                    .centerCrop()
                    .into(descReport.ivActionDesc)
            } else descReport.actionDesc.visibility = GONE
        }
    }

    private fun takeImage() {
        ImagePicker.with(this)
            .compress(250)
            .createIntent { launchResult.launch(it) }
    }

    private fun refreshDetail(id: Int) {
        viewModel.refreshPanicDetail("$id")
        viewModel.panicDetail.observe(this) { res ->
            when (res) {
                is Resource.Error -> {
                    res.message?.let { AppUtil.snackBar(this, it) }
                }
                is Resource.NetworkError -> {
                    res.message?.let {
                        AppUtil.snackBarAction(this, it, "Try Again") {
                            respondToPanic()
                        }
                    }
                }
                is Resource.Success -> {
                    res.data?.let {
                        data = it
                        checkIfPanicIsDone()
                        checkButtonCondition()
                        loadContent()
                        loadReporterMarker()
                        timelineAdapter.differ.submitList(data?.timeline)
                    }
                }
                else -> {}
            }
        }
    }

    private fun respondToPanic() {
        viewModel.respondToPanic("${data?.id}")
        viewModel.respond.observe(this) { res ->
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
                            respondToPanic()
                        }
                    }
                }
                is Resource.Success -> {
                    hideLoading()
                    res.data?.message?.let {
                        startPatrol()
                        AppUtil.snackBar(this, it, false)
                        binding.btnGo.visibility = GONE
                        refreshDetail(data?.id ?: 0)

                    }
                }
            }
        }
    }

    private fun finishPanic() {
        viewModel.finishPanic("${data?.id}")
        viewModel.finishPanic.observe(this) { res ->
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
                            finishPanic()
                        }
                    }
                }
                is Resource.Success -> {
                    hideLoading()
                    res.data?.message?.let {
                        finishDialog.dismiss()
                        stopPatrol();
                        AppUtil.snackBar(this, it, false)
                        refreshDetail(data?.id ?: 0)
                    }
                }
            }
        }
    }

    private fun showLoading() = dialog.show()

    private fun hideLoading() = dialog.hide()


    fun startPatrol(){
        val mServiceIntent = Intent(this, LocationService::class.java)
        mServiceIntent.putExtra("AUTH",preference.getAuth())
        mServiceIntent.action = LocationService.STARTFOREGROUND_ACTION;
        startService(mServiceIntent)
    }
    fun stopPatrol(){
        val mServiceIntent = Intent(this, LocationService::class.java)
        mServiceIntent.action = LocationService.STOPFOREGROUND_ACTION;
        startService(mServiceIntent)
    }

}
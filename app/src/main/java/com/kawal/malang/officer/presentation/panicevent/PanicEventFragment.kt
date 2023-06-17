package com.kawal.malang.officer.presentation.panicevent

import android.Manifest
import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kawal.malang.officer.R
import com.kawal.malang.officer.core.util.AppPreference
import com.kawal.malang.officer.core.util.AppUtil
import com.kawal.malang.officer.core.util.Resource
import com.kawal.malang.officer.data.model.panic.report.PanicReportData
import com.kawal.malang.officer.databinding.FragmentPanicEventBinding
import com.kawal.malang.officer.presentation.DashboardActivity
import com.kawal.malang.officer.presentation.viewmodels.panic.PanicViewModel
import com.kawal.malang.officer.presentation.viewmodels.panic.PanicViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapController
import org.osmdroid.views.overlay.Marker
import java.io.InputStream
import java.net.URL
import javax.inject.Inject

@AndroidEntryPoint
class PanicEventFragment : Fragment() {

    private lateinit var binding: FragmentPanicEventBinding
    private lateinit var mapController: MapController
    private lateinit var geoPoint: GeoPoint
    private lateinit var askPermission: ActivityResultLauncher<Array<String>>
    private lateinit var viewModel: PanicViewModel
    private lateinit var pref: AppPreference
    private lateinit var dialog: Dialog

    private var lat: Double =-7.9826145
    private var lng: Double = 112.6308113
    private var data: PanicReportData? = null

    @Inject
    lateinit var adapter: PanicOfficerAdapter
    @Inject
    lateinit var factory: PanicViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as DashboardActivity).window.statusBarColor = ContextCompat.getColor(
            requireActivity(), android.R.color.transparent)
        (activity as DashboardActivity).window.statusBarColor = ContextCompat.getColor(
            requireActivity(), android.R.color.transparent)
        return inflater.inflate(R.layout.fragment_panic_event, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Configuration.getInstance().load(requireContext(),
            PreferenceManager.getDefaultSharedPreferences(requireContext()))
        binding = FragmentPanicEventBinding.bind(view)
        (activity as DashboardActivity).window.statusBarColor = ContextCompat.getColor(
            requireActivity(), android.R.color.transparent)
        viewModel = ViewModelProvider(this, factory)[PanicViewModel::class.java]
        pref = AppPreference((activity as DashboardActivity))
        dialog = AppUtil.loading((activity as DashboardActivity))

        checkIfCarIsOnPatrol()
        setUpPermission()

        binding.fabGps.setOnClickListener {
            mapController.animateTo(geoPoint)
        }

        binding.apply {
            cvPatrolStatus.setOnClickListener {
                if (cvOfficer.visibility == GONE) {
                    cvOfficer.visibility = VISIBLE
                    ivArrow.setImageDrawable(ContextCompat.getDrawable(root.context,
                        R.drawable.ic_chevron_up))
                }
                else {
                    cvOfficer.visibility = GONE
                    ivArrow.setImageDrawable(ContextCompat.getDrawable(root.context,
                        R.drawable.ic_chevron_down))
                }
            }
            binding.mapView.controller.setCenter(GeoPoint(lat,lng))
            binding.mapView.controller.setZoom(13.5)

        }
    }

    override fun onResume() {
        super.onResume()
        checkIfCarIsOnPatrol()
        binding.mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.mapView.onPause()
        lifecycleScope.cancel()
    }

    private fun initRecyclerView() {
        binding.apply {
            rvOfficer.adapter = adapter
            rvOfficer.layoutManager = LinearLayoutManager(root.context)
        }
    }

    private fun initMap() {
        mapController = binding.mapView.controller as MapController
        mapController.setZoom(17.0)
        geoPoint = GeoPoint(lat, lng)
        mapController.setCenter(geoPoint)
        binding.mapView.setMultiTouchControls(true)
        val marker = Marker(binding.mapView)
        marker.title = "Your Location"
        marker.snippet = "Your location is here now"
        marker.icon = ContextCompat.getDrawable((activity as DashboardActivity), R.drawable.ic_officer_pin)
        marker.position = geoPoint
        binding.apply {
            if (data != null) adapter.differ.submitList(data?.panicCar?.get(0)?.patrol?.member)
            mapView.overlays.clear()
            mapView.overlays.add(marker)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun checkIfCarIsOnPatrol() {
        binding.apply {
            if (pref.getPatrolStatus()) tvPatrolStatus.text = "Aktif"
            else tvPatrolStatus.text = "Tidak Aktif"
        }
    }

    private fun loadReporterMarker() {
        val reporterGeoPoint = GeoPoint(data?.latitude ?: 0.0, data?.longitude ?: 0.0)
        lifecycleScope.launch(Dispatchers.IO) {
            val url = URL(data?.category?.markerIcon)
            val drawable = Drawable.createFromStream(url.content as InputStream, "Db")
            val bmp = (drawable as BitmapDrawable).bitmap
            val dr = BitmapDrawable(resources, Bitmap.createScaledBitmap(bmp, 80, 120, true))
            val marker = Marker(binding.mapView)
            marker.title = data?.category?.name
            marker.snippet = data?.eventDescription
            marker.icon = dr
            marker.position = reporterGeoPoint
            binding.mapView.overlays.clear()
            binding.mapView.overlays.add(marker)
            withContext(Dispatchers.Main) { initMap() }
        }
    }

    private fun getActivatedPanic() {
        viewModel.getActivatedPanic(lat, lng)
        viewModel.finishPanic.observe(viewLifecycleOwner) { res ->
            when (res) {
                is Resource.Loading -> showLoading()
                is Resource.Error -> {
                    hideLoading()
                    dialog.dismiss()
                    res.message?.let { AppUtil.snackBar((activity as DashboardActivity), it) }
                }
                is Resource.NetworkError -> {
                    hideLoading()
                    dialog.dismiss()
                    res.message?.let {
                        AppUtil.snackBarAction((activity as DashboardActivity), it, "Try Again") {
                            if (view != null) getActivatedPanic()
                        }
                    }
                }
                is Resource.Success -> {
                    res.data?.let {
                        data = it.data
                        initMap()
                        initRecyclerView()
                        if (data != null) {
                            loadReporterMarker()
                        }
                        hideLoading()
                        dialog.dismiss()
                    }
                }
            }
        }
    }

    private fun setUpPermission() {
        askPermission = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            var allGranted = true
            for (granted in it.values) {
                allGranted = allGranted && granted
            }

            if (allGranted) {
                requestLocation()
            }
        }
        askPermission.launch(arrayOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
        ))
    }

    private fun requestLocation() {
        AppUtil.getLastLocation(
            (activity as DashboardActivity), { latitude, longitude ->
                lat = latitude
                lng = longitude
                if (view != null) getActivatedPanic()
            }, { askPermission }
        )
    }

    private fun showLoading() = dialog.show()

    private fun hideLoading() = dialog.dismiss()
}
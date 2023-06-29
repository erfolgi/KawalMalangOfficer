package com.kawal.malang.officer.presentation.menus

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.faltenreich.skeletonlayout.Skeleton
import com.faltenreich.skeletonlayout.applySkeleton
import com.kawal.malang.citizen.model.response.pengaduan.agenda.AgendaItem

import com.kawal.malang.officer.R
import com.kawal.malang.officer.core.util.AppPreference
import com.kawal.malang.officer.core.util.Util
import com.kawal.malang.officer.core.util.Util.hideSkeleton
import com.kawal.malang.officer.core.util.Util.wrapGate
import com.kawal.malang.officer.data.model.pengaduan.giat.GiatItem
import com.kawal.malang.officer.databinding.FragmentMenusBinding
import com.kawal.malang.officer.presentation.agenda.AgendaActivity
import com.kawal.malang.officer.presentation.bantuan.BantuanActivity
import com.kawal.malang.officer.presentation.giat.GiatActivity
import com.kawal.malang.officer.presentation.lokasi.LokasiActivity
import com.kawal.malang.officer.presentation.pengaduan.PengaduanActivity
import com.kawal.malang.officer.ui.bottomnav.ui.pengaduan.GiatAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MenusFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenusFragment : Fragment(), MenusContract {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentMenusBinding? = null
    private val binding get() = _binding!!
    lateinit var preference: AppPreference
    lateinit var presenter: MenusPresenter

    lateinit var agendaAdapter: AgendaAdapter
    lateinit var skeletonAgenda: Skeleton

    lateinit var giatAdapter: GiatAdapter
    lateinit var skeletonGiat: Skeleton

    var lastPage=false
    var loading=false
    var page:Int? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenusBinding.inflate(inflater, container, false)
        val root: View = binding.root
        Util.setNotifBarColor(requireActivity(), R.color.primary_main,false)
        preference = AppPreference(requireContext())
        presenter = MenusPresenter(this,preference.getAuth())



        skeletonAgenda = binding.rvAgenda.applySkeleton(R.layout.item_agenda_sm)
        val managerAgenda = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL,false)
        binding.rvAgenda.layoutManager = managerAgenda
        skeletonAgenda = Util.skeletonSetup(skeletonAgenda)

        skeletonGiat = binding.rvGiat.applySkeleton(R.layout.item_giat_sm)
        val managerGiat = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)
        binding.rvGiat.layoutManager = managerGiat
        skeletonGiat = Util.skeletonSetup(skeletonGiat)

        binding.sw.setOnRefreshListener {
            binding.sw.isRefreshing=false
            initLoad()
        }

        binding.txAllMenu.setOnClickListener {
            val i = Intent(requireContext(), BantuanActivity::class.java)
            requireContext().startActivity(i)
        }

        binding.btPengaduan.setOnClickListener {
            val i = Intent(requireContext(), PengaduanActivity::class.java)
            requireContext().startActivity(i)
        }

        binding.btLokasi.setOnClickListener {
            val i = Intent(requireContext(), LokasiActivity::class.java)
            requireContext().startActivity(i)
        }
        binding.btCall.setOnClickListener {
            val phone = "110"
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
            startActivity(intent)
        }

        binding.btMoreGiat.setOnClickListener {
            val i = Intent(requireContext(), GiatActivity::class.java)
            requireContext().startActivity(i)
        }
        binding.btMoreAgenda.setOnClickListener {
            val i = Intent(requireContext(), AgendaActivity::class.java)
            requireContext().startActivity(i)
        }


        val managerPres = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)
        binding.rvPresisi.layoutManager = managerPres
      //  binding.rvPresisiresisi.adapter=PresisiSmAdapter(requireContext(), BantuanConst.presisiList)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        initLoad()

    }
    fun initLoad(){
        doLoadAgenda()
        doLoadGiat()
    }
    fun doLoadAgenda(){
        skeletonAgenda.showSkeleton()
        presenter.loadAgenda(1)
    }
    fun doLoadGiat(){
        skeletonGiat.showSkeleton()
        presenter.loadGiat(1)
    }



    override fun onLoadAgenda(data: ArrayList<AgendaItem>) {
        Util.wrapGate {
            skeletonAgenda.hideSkeleton()
            loading=false
            Log.d("DEBUG", data.size.toString())

            if(data.isNotEmpty()){
                agendaAdapter= AgendaAdapter(requireContext(), data)
                binding.rvAgenda.adapter = agendaAdapter

            }
        }

    }

    override fun onLoadGiat(data: ArrayList<GiatItem>) {
        skeletonGiat.hideSkeleton()
        loading=false

        if(data.isNotEmpty()){
            wrapGate {
                giatAdapter= GiatAdapter(requireContext(), data)
                binding.rvGiat.adapter = giatAdapter
            }


        }
    }

    override fun onFailedMessage(msg: String) {

        Util.setAlert(requireActivity(),msg)
    }
}
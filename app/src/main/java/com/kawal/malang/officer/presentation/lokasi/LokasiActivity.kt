package com.kawal.malang.officer.presentation.lokasi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.faltenreich.skeletonlayout.Skeleton
import com.faltenreich.skeletonlayout.applySkeleton
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.kawal.malang.citizen.model.response.pengaduan.KategoriPengaduanItem
import com.kawal.malang.citizen.model.response.pengaduan.lokasi.LokasiItem
import com.kawal.malang.officer.R
import com.kawal.malang.officer.core.util.AppPreference
import com.kawal.malang.officer.core.util.PaginationListenerX
import com.kawal.malang.officer.core.util.Util
import com.kawal.malang.officer.core.util.Util.hideSkeleton
import com.kawal.malang.officer.databinding.ActivityLokasiBinding
import com.kawal.malang.officer.databinding.BsFilterLokasiBinding

class LokasiActivity : AppCompatActivity() , LokasiContract {
    private lateinit var binding: ActivityLokasiBinding

    lateinit var preference: AppPreference
    lateinit var adapter: LokasiAdapter
    lateinit var skeleton: Skeleton
    lateinit var presenter: LokasiPresenter

    var kategoriList:ArrayList<KategoriPengaduanItem> = ArrayList<KategoriPengaduanItem>()

    var lastPage=false
    var loading=false
    var lastId:Int? =null

    lateinit var bsd: BottomSheetDialog
    lateinit var bsBind: BsFilterLokasiBinding

    var tempkategoriId:Int? =null
    var kategoriId:Int?=null
    var nama:String?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLokasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Util.setNotifBarColor(this, R.color.primary_main,false)
        binding.tbBack.setOnClickListener { finish() }
        preference = AppPreference(this)
        presenter = LokasiPresenter(this,preference.getAuth())

        skeleton = binding.rvLokasi.applySkeleton(R.layout.item_lokasi)
        skeleton = Util.skeletonSetup(skeleton)

        val manager = GridLayoutManager(this,2)
        binding.rvLokasi.layoutManager=manager
        binding.rvLokasi.addOnScrollListener(object : PaginationListenerX(manager){
            override fun loadMoreItems() {
                if(!lastPage && !loading){
                    loading=true
                    loadList()
                }
            }

            override val isLastPage: Boolean
                get() = lastPage
            override val isLoading: Boolean
                get() = loading
        })

        binding.svSurat.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
            override fun onQueryTextSubmit(query: String): Boolean {
                nama = query
                initLoad()
                return false
            }
        })

        binding.swSurat.setOnRefreshListener {
            binding.swSurat.isRefreshing=false
            initLoad()
        }

        initBs()
        binding.cbProject.setOnClickListener {
            showBs()
        }
    }

    override fun onResume() {
        super.onResume()
        initLoad()
    }

    fun initLoad(){
        binding.llEmpty.visibility= View.GONE
        binding.rvLokasi.visibility= View.VISIBLE
        skeleton.showSkeleton()
        lastId=null
        lastPage=false
        loadList()
        presenter.loadKategori()
    }
    fun loadList(){
        presenter.loadLokasi(lastId,kategoriId,nama,null,null)
    }

    override fun onLoad(data: ArrayList<LokasiItem>) {
        skeleton.hideSkeleton()
        loading=false
        if(data.isNotEmpty()){
            binding.rvLokasi.visibility = View.VISIBLE
            binding.llEmpty.visibility = View.GONE

            if(lastId!=null){
                val temp = adapter.items.size
                adapter.items.addAll(data)
                adapter.items= adapter.items.distinct() as ArrayList<LokasiItem>
                adapter.notifyItemRangeInserted(temp, data.size)
            }else{
                adapter= LokasiAdapter(this, data)
                binding.rvLokasi.adapter=adapter
            }
            lastId=data[data.lastIndex].id
        }else{
            lastPage=true
            if(lastId==null){
                binding.rvLokasi.visibility= View.GONE
                binding.llEmpty.visibility= View.VISIBLE
            }

        }
    }

    override fun onLoadKategori(data: ArrayList<KategoriPengaduanItem>) {
        kategoriList=data
    }

    override fun onFailedMessage(msg: String) {
        skeleton.hideSkeleton()
        Util.setAlert(this,msg)
    }

    fun ifFilter(){
        binding.cbProject.isChecked=false

        if(kategoriId!=null){
            binding.cbProject.isChecked=true
        }
    }


    fun initBs(){
        val layoutInflater: LayoutInflater = this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val v = layoutInflater.inflate(R.layout.bs_filter_lokasi, null)

        bsd = BottomSheetDialog(this, R.style.BottomSheetDialog)
        bsBind = BsFilterLokasiBinding.bind(v)

        bsBind.btClose.setOnClickListener {
            bsd.dismiss()
        }
        bsd.setContentView(bsBind.root)
        bsd.setCanceledOnTouchOutside(true)
        bsd.setOnDismissListener {
            ifFilter()
        }
    }


    fun showBs(){
        bsd.show()
        bsBind.spKategori.setItems(kategoriList.map{it.nama})
        bsBind.btDelKategori.setOnClickListener {
            bsBind.spKategori.selectItemByIndex(-1)
            bsBind.spKategori.clearSelectedItem()
            tempkategoriId=null
        }



        bsBind.spKategori.setOnSpinnerItemSelectedListener<String> { oldIndex, oldItem, newIndex, newItem ->
            tempkategoriId = kategoriList[newIndex].id
        }


        bsBind.btApply.setOnClickListener {
            this.kategoriId = tempkategoriId
            bsd.dismiss()
            initLoad()
        }
    }
}
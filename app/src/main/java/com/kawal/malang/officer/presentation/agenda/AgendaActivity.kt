package com.kawal.malang.officer.presentation.agenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.faltenreich.skeletonlayout.Skeleton
import com.faltenreich.skeletonlayout.applySkeleton
import com.kawal.malang.citizen.model.response.pengaduan.agenda.AgendaItem
import com.kawal.malang.officer.R
import com.kawal.malang.officer.core.util.AppPreference
import com.kawal.malang.officer.core.util.PaginationListenerX
import com.kawal.malang.officer.core.util.Util
import com.kawal.malang.officer.core.util.Util.hideSkeleton
import com.kawal.malang.officer.databinding.ActivityAgendaBinding

class AgendaActivity : AppCompatActivity(), AgendaContract {
    private lateinit var binding: ActivityAgendaBinding

    lateinit var preference: AppPreference
    lateinit var adapter: AgendaPageAdapter
    lateinit var skeleton: Skeleton
    lateinit var presenter: AgendaPresenter

    var lastPage=false
    var loading=false
    var page:Int =1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgendaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Util.setNotifBarColor(this, R.color.primary_main,false)
        binding.tbBack.setOnClickListener { finish() }
        preference = AppPreference(this)
        presenter = AgendaPresenter(this,preference.getAuth())

        skeleton = binding.rvLokasi.applySkeleton(R.layout.item_agenda)
        skeleton = Util.skeletonSetup(skeleton)

        val manager = LinearLayoutManager(this)
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

        binding.swSurat.setOnRefreshListener {
            binding.swSurat.isRefreshing=false
            initLoad()
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
        page=1
        lastPage=false
        loadList()
    }
    fun loadList(){
        presenter.load(page)
    }

    override fun onLoad(data: ArrayList<AgendaItem>) {
        skeleton.hideSkeleton()
        loading=false
        if(data.isNotEmpty()){
            binding.rvLokasi.visibility = View.VISIBLE
            binding.llEmpty.visibility = View.GONE

            if(page >1){
                val temp = adapter.items.size
                adapter.items.addAll(data)
                adapter.items= adapter.items.distinct() as java.util.ArrayList<AgendaItem>
                adapter.notifyItemRangeInserted(temp, data.size)
            }else{
                adapter= AgendaPageAdapter(this, data)
                binding.rvLokasi.adapter=adapter
            }
            page += 1;
        }else{
            lastPage=true
            if(page==1){
                binding.rvLokasi.visibility= View.GONE
                binding.llEmpty.visibility= View.VISIBLE
            }

        }
    }

    override fun onFailedMessage(msg: String) {
        skeleton.hideSkeleton()
        Util.setAlert(this,msg)
    }
}
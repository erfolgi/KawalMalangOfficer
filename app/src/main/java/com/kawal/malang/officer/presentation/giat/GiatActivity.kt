package com.kawal.malang.officer.presentation.giat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.faltenreich.skeletonlayout.Skeleton
import com.faltenreich.skeletonlayout.applySkeleton
import com.kawal.malang.officer.R
import com.kawal.malang.officer.core.util.AppPreference
import com.kawal.malang.officer.core.util.Util
import com.kawal.malang.officer.databinding.ActivityGiatBinding
import com.kawal.malang.officer.core.util.PaginationListenerX
import com.kawal.malang.officer.core.util.Util.hideSkeleton
import com.kawal.malang.officer.data.model.pengaduan.giat.GiatItem
import com.kawal.malang.officer.presentation.giat.form.FormGiatActivity

class GiatActivity : AppCompatActivity(), GiatContract {
    private lateinit var binding: ActivityGiatBinding

    lateinit var preference: AppPreference
    lateinit var adapter: GiatPageAdapter
    lateinit var skeleton: Skeleton
    lateinit var presenter: GiatPresenter

    var lastPage=false
    var loading=false
    var page:Int =1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGiatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Util.setNotifBarColor(this, R.color.primary_main,false)
        binding.tbBack.setOnClickListener { finish() }
        preference = AppPreference(this)
        presenter = GiatPresenter(this,preference.getAuth())

        skeleton = binding.rvLokasi.applySkeleton(R.layout.item_giat)
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

        binding.fbAdd.setOnClickListener {
            val i = Intent(this, FormGiatActivity::class.java)
            startActivity(i)
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

    override fun onLoad(data: ArrayList<GiatItem>) {
        skeleton.hideSkeleton()
        loading=false
        if(data.isNotEmpty()){
            binding.rvLokasi.visibility = View.VISIBLE
            binding.llEmpty.visibility = View.GONE

            if(page >1){
                val temp = adapter.items.size
                adapter.items.addAll(data)
                adapter.items= adapter.items.distinct() as java.util.ArrayList<GiatItem>
                adapter.notifyItemRangeInserted(temp, data.size)
            }else{
                adapter= GiatPageAdapter(this, data)
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
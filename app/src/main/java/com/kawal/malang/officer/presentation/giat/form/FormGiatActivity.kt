package com.kawal.malang.officer.presentation.giat.form

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import com.faltenreich.skeletonlayout.Skeleton
import com.kawal.malang.officer.R
import com.kawal.malang.officer.core.util.AppPreference
import com.kawal.malang.officer.core.util.Util
import com.kawal.malang.officer.core.util.Util.bindImage
import com.kawal.malang.officer.core.util.Util.getPathUri
import com.kawal.malang.officer.core.util.Util.hideSkeleton
import com.kawal.malang.officer.core.util.Util.validVisible
import com.kawal.malang.officer.core.util.Util.validation
import com.kawal.malang.officer.data.model.pengaduan.giat.GiatForm
import com.kawal.malang.officer.data.model.pengaduan.giat.GiatItem
import com.kawal.malang.officer.databinding.ActivityFormGiatBinding
import com.sangcomz.fishbun.FishBun
import com.sangcomz.fishbun.adapter.image.impl.GlideAdapter
import java.io.File
import java.util.*

class FormGiatActivity : AppCompatActivity(), FormGiatContract {
    lateinit var binding: ActivityFormGiatBinding
    lateinit var preference: AppPreference
    lateinit var presenter: FormGiatPresenter
    lateinit var skeleton: Skeleton
    var data: GiatForm = GiatForm()
    var kategoriId: Int? = null;
    var subkategoriId: Int? = null;
    var file: File? = null
    var tanggal: String? = null
    private var c = Calendar.getInstance()

    var editId: Int = -1;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormGiatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        skeleton = Util.skeletonButton(binding.btApply)

        editId = intent.getIntExtra("EDIT_ID", -1);

        preference = AppPreference(this)
        presenter = FormGiatPresenter(this, preference.getAuth())

        //askCameraPermission(this@FormGiatActivity)
        with(binding) {
            toolbar.tbTitle.text = "Form Giat"
            toolbar.tbBack.setOnClickListener { finish() }

            preference = AppPreference(this@FormGiatActivity)

            foto.add.setOnClickListener {
                //askCameraPermission(this@FormGiatActivity)

                FishBun.with(this@FormGiatActivity).setImageAdapter(GlideAdapter())
                    .setMaxCount(1)
                    .setMinCount(1)
                    .setIsUseDetailView(false)
                    .setReachLimitAutomaticClose(true)
                    .hasCameraInPickerPage(true)
                    .startAlbumWithOnActivityResult(101)

//                ImagePicker.with(this@FormGiatActivity)
//                    .compress(1000)            //Final image size will be less than 1 MB(Optional)
//                    .start(101)
            }

            btApply.setOnClickListener {
                var valid = true
                valid = valid &&
                        etTitle.validation() &&
                        etKeterangan.validation() &&
                        etUrl.validation() &&
                        foto.add.validVisible()

                if (valid) {
                    skeleton.showSkeleton()
                    if (etKeterangan.text.toString() != "") {
                        data.deskripsi = etKeterangan.text.toString()
                    }

                    if (etTitle.text.toString() != "") {
                        data.judul = etTitle.text.toString()
                    }



                    Util.wrapLocation(this@FormGiatActivity) {

                        if(editId>0){
                            presenter.updateGiat(editId,data, file)
                        }else{
                            presenter.postGiat(data, file)
                        }


                    }
                }
            }
        }

        if(editId >0){
            editForm()
        }

    }


    fun editForm() {
        val source = preference.getStoredGiat()
        binding.apply {
            etTitle.setText(source.judul)
            etUrl.setText(source.url)
            etKeterangan.setText(source.deskripsi)


            btApply.text = "Edit Giat"
            if (source.foto != null) {
                bindImage(source.foto)
            }

        }

    }

    fun bindImage(url: String?) {
        binding.foto.add.visibility = View.GONE
        binding.foto.photo.bindImage(this, url)
        binding.foto.llFile.visibility = View.VISIBLE
        binding.foto.delete.setOnClickListener {
            binding.foto.add.visibility = View.VISIBLE
            binding.foto.llFile.visibility = View.GONE
            this.file = null
        }
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_CANCELED) {
            return
        }
        when (requestCode) {
            101 -> {
                val path = data?.getParcelableArrayListExtra<Uri>(FishBun.INTENT_PATH)

                path?.get(0)?.let { Log.d("PATH", it.toString()) }
                //var path = data!!.getParcelableArrayListExtra(FishBun.INTENT_PATH);
                val file = File(getPathUri(this, path?.get(0))) //ImagePicker.getFile(data)
                Log.d("PATH", file.absolutePath)


                if (file != null) {
                    binding.foto.add.visibility = View.GONE
                    binding.foto.photo.bindImage(this, file.absolutePath)
                    binding.foto.llFile.visibility = View.VISIBLE
                    binding.foto.delete.setOnClickListener {
                        binding.foto.add.visibility = View.VISIBLE
                        binding.foto.llFile.visibility = View.GONE
                        this.file = null
                    }

                    this.file = file

                }
            }
        }
    }

    override fun onSubmit(message: String, data: GiatItem) {
        Util.setToast(this, message)

        finish()
    }
    override fun onFailedMessage(msg: String) {
        skeleton.hideSkeleton()
        Util.setAlert(this, msg)
    }
}
package com.kawal.malang.officer.core.util

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.kawal.malang.officer.databinding.ActivityPreviewBinding

class PreviewActivity : AppCompatActivity() {
    lateinit var binding: ActivityPreviewBinding
    companion object{
        var ext_url = "EXT_URL"
    }

    lateinit var uri: Uri
    lateinit var url:String
    var loadingFinished = true
    var redirect = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        url= intent.getStringExtra(ext_url)?:""

        if(url.contains(".pdf")){
            url = "http://docs.google.com/gview?embedded=true&url=$url"
        }
        if(url.contains(".doc")){
            url = "http://docs.google.com/gview?embedded=true&url=$url"
        }
        if(url.contains(".xls")){

            binding.wvPreview.settings.useWideViewPort = true;
            url = "http://docs.google.com/gview?embedded=true&url=$url"
        }
        binding.wvPreview.settings.mixedContentMode = 0;
        binding.wvPreview.setLayerType(View.LAYER_TYPE_HARDWARE, null);

        binding.tx.text="http://docs.google.com/gview?embedded=true&url=$url"

        binding.wvPreview.settings.setSupportZoom(true)
        binding.wvPreview.settings.javaScriptEnabled = true
        binding.wvPreview.settings.setDomStorageEnabled(true);



        binding.wvPreview.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, progress: Int) {

                if (progress < 100 && binding.loading.visibility == View.GONE) {
                    binding.loading.visibility = View.VISIBLE
                }

                binding.loading.progress= progress.toFloat().toInt()
                if (progress == 100) {
                    binding.loading.visibility = View.GONE
                    binding.tx.visibility = View.GONE
                }
            }
        }

        binding.wvPreview.webViewClient = object : WebViewClient() {
//            @Deprecated("Deprecated in Java")
//            override fun onReceivedError(
//                view: WebView,
//                errorCode: Int,
//                description: String,
//                failingUrl: String
//            ) {
//                Toast.makeText(binding.root.context, description, Toast.LENGTH_SHORT).show()
//            }

//            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
//                view.loadUrl(url)
//                return true
//            }
        }
        binding.wvPreview.loadUrl(url)

    }

    override fun onResume() {
        super.onResume()
    }
}
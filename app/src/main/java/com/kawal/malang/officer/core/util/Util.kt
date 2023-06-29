package com.kawal.malang.officer.core.util

import android.Manifest
import android.annotation.SuppressLint
import android.app.*
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.IntentSender
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.BitmapDrawable
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.net.Uri
import android.os.AsyncTask
import android.os.Build
import android.os.Environment
import android.os.StrictMode
import android.provider.MediaStore
import android.provider.OpenableColumns
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.*
import androidx.annotation.NonNull
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.faltenreich.skeletonlayout.Skeleton
import com.faltenreich.skeletonlayout.applySkeleton
import com.faltenreich.skeletonlayout.createSkeleton
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import com.kawal.malang.officer.BuildConfig
import com.kawal.malang.officer.R
import com.kawal.malang.officer.core.util.ImageActivity.Companion.EXT_URL
import com.kawal.malang.officer.databinding.BsConfirmBinding
import com.kawal.malang.officer.presentation.auth.login.LoginActivity

import com.labters.lottiealertdialoglibrary.ClickListener
import com.labters.lottiealertdialoglibrary.DialogTypes
import com.labters.lottiealertdialoglibrary.LottieAlertDialog
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.json.JSONArray
import org.json.JSONObject

import java.io.*
import java.net.URISyntaxException
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern


object Util {
    private val mLocationRequest: LocationRequest = LocationRequest.create()

    private var globalLocation: Location? = null
    fun String.capitalizeWords(): String = split(" ").map { it.capitalize() }.joinToString(" ")
    fun isEmailValid(email: String?): Boolean {
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern: Pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher: Matcher = pattern.matcher(email)
        return matcher.matches()
    }

    fun skeletonSetup(skeleton: Skeleton): Skeleton {
        skeleton.shimmerDurationInMillis = 500
        skeleton.shimmerColor = Color.parseColor("#F0F0F2")
        skeleton.maskColor = Color.parseColor("#C8C8C8")

        skeleton.maskCornerRadius = 16.0F
        return skeleton
    }

    fun skeletonButton(view: View): Skeleton {
        var skeleton = view.createSkeleton()
        skeleton = skeletonSetup(skeleton)
        return skeleton
    }

    fun Skeleton.setupView(view: View) = run {
        view.createSkeleton()
        shimmerDurationInMillis = 500
        shimmerColor = Color.parseColor("#F0F0F2")
        maskColor = Color.parseColor("#C8C8C8")
        maskCornerRadius = 16.0F
    }

    fun Skeleton.setupRV(view: RecyclerView, layoutId: Int) = run {
        view.applySkeleton(layoutId)
        shimmerDurationInMillis = 500
        shimmerColor = Color.parseColor("#F0F0F2")
        maskColor = Color.parseColor("#C8C8C8")
        maskCornerRadius = 16.0F
    }

    fun Skeleton.hideSkeleton() = run {
        if (isSkeleton()) {
            showOriginal()
        }
    }

    fun skeletonShowOriginal(skeleton: Skeleton) {
        try {
            if (skeleton.isSkeleton()) {
                skeleton.showOriginal()
            }
        } catch (_: Exception) {

        }

    }

    val sbDuration = Snackbar.LENGTH_LONG
    fun snackbarSetup(snackBar: Snackbar): Snackbar {
        snackBar.setActionTextColor(Color.BLUE)
        val snackBarView = snackBar.view
        snackBarView.setBackgroundColor(Color.BLACK)
        val textView =
            snackBarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
        textView.setTextColor(Color.WHITE)
        return snackBar
    }

    fun ImageView.bindImage(context: Context, url: String?) = run {
        wrapGate {
            Glide.with(context).load(url?.replace("http:", "https:"))
                .placeholder(R.drawable.ic_camera).error(R.drawable.ic_camera)
                .into(this)
            setOnClickListener {
                val i = Intent(context, ImageActivity::class.java)
                i.putExtra(EXT_URL, url)
                context.startActivity(i)
            }
        }

    }

    fun ImageView.bindImage(context: Context, r_drawable: Int?) = run {
        Glide.with(context).load(r_drawable)
            .placeholder(R.drawable.ic_camera).error(R.drawable.ic_camera)
            .into(this)

        setOnClickListener {
            val i = Intent(context, ImageActivity::class.java)
            i.putExtra(EXT_URL, r_drawable)
            context.startActivity(i)
        }
    }

    fun ImageView.bindIcon(context: Context, url: String?) = run {

        Glide.with(context).load(url?.replace("http:", "https:"))
            .placeholder(R.drawable.ic_camera).error(R.drawable.ic_camera)
            .into(this)
    }

    fun ImageView.bindIcon(context: Context, r_drawable: Int?) = run {
        Glide.with(context).load(r_drawable)
            .placeholder(R.drawable.ic_camera).error(R.drawable.ic_camera)
            .into(this)

    }

    fun TextView.validation(): Boolean = run {
        if (text.toString() == "") {
            error = "Wajib diisi"
            return@run false
        } else {
            return@run true
        }
    }

    fun TextView.validVisible(): Boolean = run {
        if (visibility == View.VISIBLE) {
            error = "Wajib diisi"
            return@run false
        } else {
            return@run true
        }
    }

    fun TextView.fileValidation(): Boolean = run {
        if (isVisible) {
            error = "Wajib diisi"
            return@run false
        } else {
            return@run true
        }
    }

    fun toIDR(x: Float?): String {
        if (x == null) {
            return "-"
        }
        val format: NumberFormat = NumberFormat.getCurrencyInstance(Locale("in", "ID"))
        val result = format.format(x)

        return result
    }

    fun toMoneyFormat(x: Float?): String {
        if (x == null) {
            return "-"
        }
        val format: NumberFormat = NumberFormat.getCurrencyInstance(Locale("in", "ID"))
        val result = format.format(x).replace("Rp", "")

        return result
    }

    fun getTypeFace(context: Context, resId: Int): Typeface? {
        val tf: Typeface? = ResourcesCompat.getFont(context, resId)
        return tf;
    }

    fun currentDate(): String {
        val c: Date = Calendar.getInstance().getTime()
        val df = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val formattedDate: String = df.format(c)
        return formattedDate
    }

    fun currentDatetime(): String {
        val c: Date = Calendar.getInstance().getTime()
        val df = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val formattedDate: String = df.format(c)
        return formattedDate
    }

    fun dateFormatter(pre: String): String {
        val c: Date = Calendar.getInstance().getTime()
        val df = SimpleDateFormat("yyyy-MMM-dd", Locale.getDefault())
        val formattedDate: String = df.format(c)

        return formattedDate
    }

    fun openImage(context: Context, url: String?) {
        val i = Intent(context, ImageActivity::class.java)
        i.putExtra(ImageActivity.EXT_URL, url)
        context.startActivity(i)
    }

    fun openPdf(context: Context, url: String?) {
        val i = Intent(context, PreviewActivity::class.java)
        i.putExtra(PreviewActivity.ext_url, url)
        context.startActivity(i)
    }

    fun bitmapToFile(context: Context, bitmap: Bitmap): File {
        var f = File(context.getCacheDir(), "temp-")
        f.createNewFile();
        val bos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 0 /*ignored for PNG*/, bos)
        val bitmapdata: ByteArray = bos.toByteArray()

        //write the bytes in file
        //write the bytes in file
        var fos: FileOutputStream? = null
        try {
            fos = FileOutputStream(f)
        } catch (
            e: FileNotFoundException
        ) {
            e.printStackTrace()
        }
        try {
            fos!!.write(bitmapdata)
            fos.flush()
            fos.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return f
    }

    @NonNull
    public fun prepareFilePart(file: File, name: String): MultipartBody.Part {
        val requestFile =
            RequestBody.create(
                MediaType.parse("image"),
                file
            )
        return MultipartBody.Part.createFormData(name, file.name, requestFile)
    }


    fun reqBody(name: String): RequestBody {
        return RequestBody.create(MultipartBody.FORM, name)
    }

    @SuppressLint("SimpleDateFormat")
    fun toYmd(dateOrigin: String?): String {
        if (dateOrigin == null) {
            return ""
        }
        var date = dateOrigin

        var dateFormatter = SimpleDateFormat("dd/MM/yy HH:mm")
        return try {
            var format: SimpleDateFormat
            if (!date.contains(":")) {
                format =
                    SimpleDateFormat("dd MMMM yyyy")
                val newDate = format.parse(date)

                dateFormatter = SimpleDateFormat("yyyy-MM-dd")


            } else if (date.length == 19) {
                format =
                    SimpleDateFormat("dd/MM/yy HH:mm")

                dateFormatter = SimpleDateFormat("yyyy-MM-dd")
            } else if (date.contains("T")) {

                format =
                    SimpleDateFormat("yyyy-MM-dd")
                date = date.dropLast(10)

                dateFormatter = SimpleDateFormat("yyyy-MM-dd")

            } else {
                format =
                    SimpleDateFormat("yyyy-MM-ddTHH:mm:ss.000000Z")
                dateFormatter = SimpleDateFormat("yyyy-MM-dd")
            }
            val newDate = format.parse(date)

            dateFormatter.format(newDate!!)

        } catch (e: Exception) {
            date
        }

    }

    @SuppressLint("SimpleDateFormat")
    fun toYmd(year: Int, month: Int, day: Int): String {
        var MM = ""
        var dd = ""
        if ((month + 1) < 10) {
            MM = "0${(month + 1)}"
        } else {
            MM = "${month + 1}"
        }
        if ((day) < 10) {
            dd = "0$day"
        } else {
            dd = "$day"
        }
        return "$year-$MM-$dd"
    }

    @SuppressLint("SimpleDateFormat")
    fun toYmdhi(year: Int, month: Int, day: Int, hour: Int, minute: Int): String {
        var MM = ""
        var dd = ""
        var ii = ""
        var hh = ""
        if ((month + 1) < 10) {
            MM = "0${(month + 1)}"
        } else {
            MM = "${month + 1}"
        }
        if ((day) < 10) {
            dd = "0$day"
        } else {
            dd = "$day"
        }
        if ((hour) < 10) {
            hh = "0$hour"
        } else {
            hh = "$hour"
        }
        if ((minute) < 10) {
            ii = "0$minute"
        } else {
            ii = "$minute"
        }

        return "$year-$MM-$dd $hh:$ii"
    }


    fun setNotifBarColor(activity: Activity, colorId: Int, whiteIcon: Boolean) {
        activity.window?.statusBarColor = activity.resources.getColor(colorId, null)
        changeStatusBar(activity, whiteIcon)
    }

    fun changeStatusBar(activity: Activity, white: Boolean) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val decor: View = activity.window.decorView
            if (!white) {
                decor.systemUiVisibility = 0
            } else {
                decor.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }
    }

    @SuppressLint("SimpleDateFormat")
    fun getDate(dateOrigin: String?): Calendar {

        val cal = Calendar.getInstance()
        if (dateOrigin != "") {
            val sdf = SimpleDateFormat("dd MMMM yyyy")
            cal.time = sdf.parse(dateOrigin) // all done
        }
        return cal
    }

    @SuppressLint("SimpleDateFormat")
    fun getDatime(dateOrigin: String?): Calendar {

        val cal = Calendar.getInstance()
        if (dateOrigin != "") {
            val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
            cal.time = sdf.parse(dateOrigin) // all done
        }
        return cal
    }

    @SuppressLint("SimpleDateFormat")
    fun getTime(timeOrigin: String?): Calendar {

        val cal = Calendar.getInstance()
        if (timeOrigin != "") {
            val sdf = SimpleDateFormat("HH:mm:ss")
            cal.time = sdf.parse(timeOrigin) // all done
        }
        return cal
    }

    fun toHm(hour: Int, minute: Int): String {
        var hm = ""

        hm = if (hour.toString().length == 1) {
            "0$hour"
        } else {
            "$hour"
        }
        hm = if (minute.toString().length == 1) {
            hm + ":0$minute"
        } else {
            hm + ":$minute"
        }
        return hm + ":00"
    }

    @SuppressLint("SimpleDateFormat")
    fun showDate(dateOrigin: String?): String {
        if (dateOrigin == null) {
            return ""
        }
        var date = dateOrigin

        var dateFormatter = SimpleDateFormat("dd/MM/yy HH:mm")
        return try {
            var format: SimpleDateFormat
            if (!date.contains(":")) {
                format =
                    SimpleDateFormat("yyyy-MM-dd")
                val newDate = format.parse(date)

                dateFormatter = SimpleDateFormat("dd MMMM yyyy")


            } else if (date.length == 19) {
                format =
                    SimpleDateFormat("yyyy-MM-dd hh:mm:ss")

                dateFormatter = SimpleDateFormat("dd/MM/yy HH:mm")
            } else if (date.contains("T")) {

                format =
                    SimpleDateFormat("yyyy-MM-dd")
                date = date.dropLast(10)

                dateFormatter = SimpleDateFormat("dd MMM yy")

            } else {
                format =
                    SimpleDateFormat("yyyy-MM-ddTHH:mm:ss.000000Z")
                dateFormatter = SimpleDateFormat("dd/MM/yy HH:mm")
            }
            val newDate = format.parse(date)

//                val dateFormatter = SimpleDateFormat(
//                    "dd/MM/yyyy"
//                )
            //val dateFormatter = SimpleDateFormat("dd/MM/yy HH:mm")
//                if(dateFormatter.format(newDate!!).contains("00:00")){
//                    dateFormatter.format(newDate!!).replace("00:00","")
//                }else{
//                    dateFormatter.format(newDate!!)
//                }
            dateFormatter.format(newDate!!)

        } catch (e: Exception) {
            date
        }

    }

    class doAsync(val handler: () -> Unit) : AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg params: Void?): Void? {
            handler()
            return null
        }
    }

    fun showFullDate(date: String?): String {
        if (date == null) {
            return ""
        }

        var dateFormatter = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale("in_ID"))
        return try {
            var format: SimpleDateFormat
            if (!date.contains(":")) {
                format =
                    SimpleDateFormat("yyyy-MM-dd")
                val newDate = format.parse(date)

                dateFormatter = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale("in", "ID", "ID"))


            } else if (date.length == 19) {
                format =
                    SimpleDateFormat("yyyy-MM-dd hh:mm:ss")

//                dateFormatter = SimpleDateFormat("dd/MM/yy HH:mm")
                val locale = Locale("id", "ID")
                dateFormatter = SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm", locale)
            } else {
                format =
                    SimpleDateFormat("yyyy-MM-ddTHH:mm:ss.000000Z")
                dateFormatter = SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm", Locale("in_ID"))
            }
            val newDate = format.parse(date)

//                val dateFormatter = SimpleDateFormat(
//                    "dd/MM/yyyy"
//                )
            //val dateFormatter = SimpleDateFormat("dd/MM/yy HH:mm")
//                if(dateFormatter.format(newDate!!).contains("00:00")){
//                    dateFormatter.format(newDate!!).replace("00:00","")
//                }else{
//                    dateFormatter.format(newDate!!)
//                }
            dateFormatter.format(newDate!!)

        } catch (e: Exception) {
            date
        }

    }

    fun JSONObject.toMap(): Map<String, *> = keys().asSequence().associateWith {
        when (val value = this[it]) {
            is JSONArray -> {
                val map = (0 until value.length()).associate { Pair(it.toString(), value[it]) }
                JSONObject(map).toMap().values.toList()
            }
            is JSONObject -> value.toMap()
            JSONObject.NULL -> null
            else -> value
        }
    }

    fun showShortDate(date: String?): String {
        if (date == null) {
            return ""
        }

        var dateFormatter = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale("in_ID"))
        return try {
            var format: SimpleDateFormat
            if (!date.contains(":")) {
                format =
                    SimpleDateFormat("yyyy-MM-dd")
                val newDate = format.parse(date)

                dateFormatter = SimpleDateFormat("EEE, dd MMM yyyy", Locale("in", "ID", "ID"))


            } else if (date.length == 19) {
                format =
                    SimpleDateFormat("yyyy-MM-dd hh:mm:ss")

//                dateFormatter = SimpleDateFormat("dd/MM/yy HH:mm")
                val locale = Locale("id", "ID")
                dateFormatter = SimpleDateFormat("EEE, dd MMM yyyy HH:mm", locale)
            } else {
                format =
                    SimpleDateFormat("yyyy-MM-ddTHH:mm:ss.000000Z")
                dateFormatter = SimpleDateFormat("EEE, dd MMM yyyy HH:mm", Locale("in_ID"))
            }
            val newDate = format.parse(date)

//                val dateFormatter = SimpleDateFormat(
//                    "dd/MM/yyyy"
//                )
            //val dateFormatter = SimpleDateFormat("dd/MM/yy HH:mm")
//                if(dateFormatter.format(newDate!!).contains("00:00")){
//                    dateFormatter.format(newDate!!).replace("00:00","")
//                }else{
//                    dateFormatter.format(newDate!!)
//                }
            dateFormatter.format(newDate!!)

        } catch (e: Exception) {
            date
        }

    }

    @SuppressLint("SimpleDateFormat")
    fun showTime(date: String?): String {
        if (date == null) {
            return ""
        }
        return try {
            var format: SimpleDateFormat
            if (date.length == 10) {
                format =
                    SimpleDateFormat("yyyy-MM-dd")
                val newDate = format.parse(date)
            } else {
                format =
                    SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
            }
            val newDate = format.parse(date)

            val dateFormatter = SimpleDateFormat("HH:mm")
            dateFormatter.format(newDate)
        } catch (e: Exception) {
            date
        }
    }

    @SuppressLint("SimpleDateFormat")
    fun showDateTime(dateOrigin: String?): String {
        if (dateOrigin == null) {
            return ""
        }
        var date = dateOrigin
        var dateFormatter = SimpleDateFormat("dd/MM/yyyy HH:mm")
        return try {
            var format: SimpleDateFormat
            if (date.length == 10) {
                format =
                    SimpleDateFormat("yyyy-MM-dd")
                val newDate = format.parse(date)
            } else if (date.contains("T")) {

                format =
                    SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
                date = date.dropLast(19)

            } else if (date.length == 16) {
                format =
                    SimpleDateFormat("yyyy-MM-dd hh:mm")
            } else {
                format =
                    SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
            }
            val newDate = format.parse(date)

            dateFormatter.format(newDate)
        } catch (e: Exception) {
            date
        }
    }


    @Throws(URISyntaxException::class)
    fun getPath(context: Context, uri: Uri): String? {
        if ("content".equals(uri.getScheme(), ignoreCase = true)) {
            val projection = arrayOf("_data")
            var cursor: Cursor? = null
            try {
                cursor = context.contentResolver.query(uri, projection, null, null, null)
                val column_index: Int = cursor!!.getColumnIndexOrThrow("_data")
                if (cursor.moveToFirst()) {
                    return cursor.getString(column_index)
                }
            } catch (e: java.lang.Exception) {
                // Eat it
            }
        } else if ("file".equals(uri.getScheme(), ignoreCase = true)) {
            return uri.getPath()
        }
        return null
    }


    fun getFileName(uri: Uri, activity: Activity): String? {
        var result: String? = null
        if (uri.scheme == "content") {
            val cursor: Cursor? =
                activity.contentResolver.query(uri, null, null, null, null)
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result =
                        cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
                }
            } finally {
                cursor?.close()
            }
        }
        if (result == null) {
            result = uri.path
            val cut = result!!.lastIndexOf('/')
            if (cut != -1) {
                result = result.substring(cut + 1)
            }
        }
        return result
    }

    fun getFileName(url: String?): String? {
        if (url != null) {
            return url.substring(url.lastIndexOf('/') + 1)
        }
        return url
    }


    fun getHex(context: Context, resId: Int): String {
        return context.resources.getString(resId).replace("#ff", "#");
    }

    fun getColoredSpanned(text: String, color: String): String? {
        return "<font color=$color>$text</font>"
    }

    fun isPermissionDenied(activity: Activity, permission:String): Boolean {

        Log.d("PERMISSION $permission",ContextCompat.checkSelfPermission(
            activity.baseContext,
            permission).toString() )

        ActivityCompat.requestPermissions(
            activity,
            arrayOf(
                permission,
            ),
            Math.random().toInt()
        )

        return   ContextCompat.checkSelfPermission(
            activity.baseContext,
            permission
        )==PackageManager.PERMISSION_DENIED
    }

    fun askCameraPermission(activity: Activity) {




        var isDenied =
            isPermissionDenied(activity, Manifest.permission.READ_MEDIA_IMAGES) ||
                    isPermissionDenied(activity, Manifest.permission.CAMERA)

        if(!isDenied){
            setToast(activity, "Please enable permission")
            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
            val uri = Uri.fromParts("package", activity.packageName, null)
            intent.data = uri
            activity.startActivity(intent)
        }

//        ActivityCompat.requestPermissions(
//            activity,
//            arrayOf(
//                Manifest.permission.WRITE_EXTERNAL_STORAGE,
//            ),
//            1
//        )



    }

    fun downloadFile(activity: Activity, url: String) {
        val SDK_INT = Build.VERSION.SDK_INT
        if (SDK_INT > 8) {
            val policy: StrictMode.ThreadPolicy = StrictMode.ThreadPolicy.Builder()
                .permitAll().build()
            StrictMode.setThreadPolicy(policy)
            //your codes here
        }
        if (Build.VERSION.SDK_INT > 22) {
            val permissionCheck = ContextCompat.checkSelfPermission(
                activity.baseContext,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                    activity,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    1
                )
            }
        }


        downloadFileKai(activity, url)
        return

//            val folder = File(Environment.getExternalStorageDirectory().path + "/" + "Huma-Betang")
//            if (!folder.exists()) {
//                folder.mkdirs()
//            }
//            val fileName = getFileName(url)
//            val urlOfTheFile = url
//
//            FileDownloadManager.initDownload(
//                activity,
//                urlOfTheFile,
//                folder.absolutePath,
//                fileName.toString()
//            )
//
//
//            Toast.makeText(activity,"Mengunduh File $fileName",Toast.LENGTH_LONG).show()


    }


    fun downloadFileKai(activity: Activity, url: String) {
        val fileName = getFileName(url)

        val downloadUri = Uri.parse(url)
        val request = DownloadManager.Request(
            downloadUri
        )
        request.setAllowedNetworkTypes(
            DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE
        )
            .setAllowedOverRoaming(true).setTitle(fileName)
            .setDescription("Downloading file")
            .setDestinationInExternalPublicDir(
                Environment.DIRECTORY_DOWNLOADS,
                File.separator + "panicbutton" + File.separator + fileName
            )

        val path =
            Environment.DIRECTORY_DOWNLOADS + File.separator + "panicbutton" + File.separator + fileName

        val downloadManager = activity.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        downloadManager.enqueue(request)


        val file = File(
            Environment.DIRECTORY_DOWNLOADS,
            File.separator + "panicbutton" + File.separator + fileName
        )
        //setSuccessDownload(activity,"File berhasil disimpan di $path",file)

//            Toast.makeText(activity,"Mengunduh File $fileName",Toast.LENGTH_LONG).show()


    }


    fun getFile(_uri: Uri, activity: Activity): String? {
        var result: String? = null
        if (_uri != null && "content" == _uri.getScheme()) {
            val cursor: Cursor = activity.contentResolver.query(
                _uri,
                arrayOf(MediaStore.Images.ImageColumns.DATA),
                null,
                null,
                null
            )!!
            cursor.moveToFirst()
            result = cursor.getString(0)
            cursor.close()
        } else {
            result = _uri.getPath()
        }
        return result
    }


    fun isMyServiceRunning(serviceClass: Class<*>, mActivity: Activity): Boolean {
        val manager: ActivityManager =
            mActivity.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        for (service in manager.getRunningServices(Int.MAX_VALUE)) {
            if (serviceClass.name == service.service.getClassName()) {
                Log.i("Service status", "Running")
                return true
            }
        }
        Log.i("Service status", "Not running")
        return false
    }

    fun isLocationEnabledOrNot(context: Context): Boolean {
        var locationManager: LocationManager? = null
        locationManager =
            context!!.getSystemService(Context.LOCATION_SERVICE) as LocationManager?
        return locationManager!!.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager!!.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }

    fun showAlertLocation(context: Context, title: String, message: String, btnText: String) {
        val alertDialog = AlertDialog.Builder(context).create()
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)
        alertDialog.setButton(btnText) { dialog, which ->
            dialog.dismiss()
            context.startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
        }
        alertDialog.show()
    }

    fun checkLocation(context: Context): Boolean? {
        val lm: LocationManager =
            context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val isNetworkEnabled = lm
            .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        val isGPSEnabled = lm
            .isProviderEnabled(LocationManager.GPS_PROVIDER);


        if (!isNetworkEnabled && !isGPSEnabled) {
            setAlertInfo(
                context,
                "Lokasi Tidak Ditemukan",
                "Silahkan nyalakan GPS untuk menggunakan layanan ini."
            )
            return false
        } else {
            return true
        }

    }


    fun setAlert(activity: Activity, msg: String) {
        wrapGate {


            if (msg.lowercase() == "unauthorized") {
                var preference = AppPreference(activity)
                preference.deleteAuth()
                preference.setPatrolStatus(false)
                val i = Intent(activity, LoginActivity::class.java)
                activity.startActivity(i)
                activity.finishAffinity()
            } else {
                val alertDialog: LottieAlertDialog =
                    LottieAlertDialog.Builder(activity, DialogTypes.TYPE_ERROR)
                        .setTitle("Oops..")
                        .setDescription(msg)
                        .build()
                alertDialog.setCancelable(true)
                alertDialog.show()
            }

        }
    }

    fun setAlert(context: Context, msg: String) {
        if (msg.lowercase() == "unauthorized") {
            var preference = AppPreference(context)
            preference.deleteAuth()
            val i = Intent(context, LoginActivity::class.java)
            context.startActivity(i)
            wrapGate { (context as Activity).finishAffinity() }

        } else {
            val alertDialog: LottieAlertDialog =
                LottieAlertDialog.Builder(context, DialogTypes.TYPE_ERROR)
                    .setTitle("Oops..")
                    .setDescription(msg)
                    .build()
            alertDialog.setCancelable(true)
            alertDialog.show()
        }
    }

    fun setAlertInfo(context: Context, title: String, msg: String) {
        val alertDialog: LottieAlertDialog =
            LottieAlertDialog.Builder(context, DialogTypes.TYPE_ERROR)
                .setTitle(title)
                .setDescription(msg)
                .build()
        alertDialog.setCancelable(true)
        alertDialog.show()
    }

//    fun setSuccess (activity: Activity, msg:String, onDismiss: () -> Unit){
//        val alertDialog : LottieAlertDialog = LottieAlertDialog.Builder(activity, DialogTypes.TYPE_SUCCESS)
//            .setTitle("Berhasil")
//            .setDescription(msg)
//            .build()
//
//        alertDialog.setNoneListener(object: ClickListener
//        {
//            override fun onClick(dialog: LottieAlertDialog) {
//                dialog.dismiss()
//            }
//        })
//        )

//        alertDialog.setOnDismissListener {
//            onDismiss()
//        }
    //.setPositiveText(yesText)
    //            //.setPositiveButtonColor(ContextCompat.getColor(activity, R.color.blue_base))
    //            .setPositiveTextColor(ContextCompat.getColor(activity, R.color.white))
    //            .setPositiveListener(object: ClickListener {
    //                override fun onClick(dialog: LottieAlertDialog) {
    //                    dialog.dismiss()
    //                    yes()
    //                }
    //            }
//        alertDialog.setCancelable(true)
//        alertDialog.show()
//    }

    fun setSuccess(activity: Activity, msg: String) {
        val alertDialog: LottieAlertDialog =
            LottieAlertDialog.Builder(activity, DialogTypes.TYPE_SUCCESS)
                .setTitle("Berhasil")
                .setDescription(msg)
                .build()
        alertDialog.setCancelable(true)
        alertDialog.show()
    }


    fun setAskDialog(
        activity: Activity,
        title: String,
        msg: String,
        yesText: String,
        noText: String = "Tutup",
        yes: () -> Unit
    ) {
        val alertDialog: LottieAlertDialog =
            LottieAlertDialog.Builder(activity, DialogTypes.TYPE_QUESTION)
                .setTitle(title)

                .setDescription(msg)
                .setNegativeText(noText)
                //.setNegativeButtonColor(ContextCompat.getColor(activity, R.color.grey))
                .setNegativeTextColor(ContextCompat.getColor(activity, R.color.white))
                .setNegativeListener(object : ClickListener {
                    override fun onClick(dialog: LottieAlertDialog) {
                        dialog.dismiss()
                    }
                }
                )
                .setPositiveText(yesText)
                //.setPositiveButtonColor(ContextCompat.getColor(activity, R.color.blue_base))
                .setPositiveTextColor(ContextCompat.getColor(activity, R.color.white))
                .setPositiveListener(object : ClickListener {
                    override fun onClick(dialog: LottieAlertDialog) {
                        dialog.dismiss()
                        yes()
                    }
                }
                )
                .build()
        alertDialog.setCancelable(true)
        alertDialog.show()
    }

    fun setLoading(activity: Activity, msg: String): LottieAlertDialog {
        val alertDialog: LottieAlertDialog =
            LottieAlertDialog.Builder(activity, DialogTypes.TYPE_LOADING)
                .setTitle("Harap Tunggu")
                .setDescription(msg)
                .build()
        alertDialog.setCancelable(false)

        return alertDialog
    }

    fun setDatePicker(
        context: Context,
        year1: Int,
        month1: Int,
        day1: Int,
        onClick: (show: String, value: String, year: Int, monthOfYear: Int, dayOfMonth: Int) -> Unit
    ) {
        var show = ""
        var value = ""

        val dpd = DatePickerDialog(
            context,
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                show = "$dayOfMonth/${monthOfYear + 1}/$year"
                value = toYmd(year, (monthOfYear), dayOfMonth)

                var year1 = year

                onClick(show, value, year, monthOfYear, dayOfMonth)
            },
            year1,
            month1,
            day1
        )

        dpd.show()
    }

    fun setToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }

    fun debugToast(context: Context, msg: String) {
        if (BuildConfig.DEBUG) {
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
        }
    }

    fun setupPopupView(context: Context, baseView: View, layout: Int): Pair<View, PopupWindow> {
        val layoutInflater: LayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var popupView = layoutInflater.inflate(layout, null)

        val popupWindow = PopupWindow(
            popupView,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        // popupWindow.setIsClippedToScreen(true)
        popupWindow.isAttachedInDecor = true


        popupWindow.setBackgroundDrawable(BitmapDrawable())
        popupWindow.isOutsideTouchable = true
        popupWindow.setOnDismissListener(PopupWindow.OnDismissListener {

        })
        popupWindow.elevation = 4F

        //popupWindow.showAsDropDown(baseView)
        return Pair(popupView, popupWindow)
    }

    fun setupWebview(wv: WebView, url: String): WebView {
        wv.settings.loadsImagesAutomatically = true
        wv.settings.javaScriptEnabled = true
        wv.settings.domStorageEnabled = true
        wv.settings.setSupportZoom(true)
        wv.settings.builtInZoomControls = true
        wv.settings.displayZoomControls = false
        wv.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        wv.webViewClient = WebViewClient()
        wv.loadUrl(url)
        return wv
    }

    fun setVisibility(b: Boolean): Int {
        return if (b) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    fun setVisibility(views: Array<View>): Int {
        for (i in views) {
            if (i.visibility == View.VISIBLE) {
                return View.VISIBLE
            }
        }
        return return View.GONE
    }

    fun setupPreview(wv: WebView, url: String): WebView {
        wv.webViewClient = WebViewClient()
        wv.settings.setSupportZoom(true)
        wv.settings.javaScriptEnabled = true
        wv.loadUrl(url)
        return wv
    }

    fun setupPreview(wv: WebView): WebView {
        wv.webViewClient = WebViewClient()
        wv.settings.setSupportZoom(true)
        wv.settings.javaScriptEnabled = true
        return wv
    }

    fun checkFileSize(uri: Uri, context: Context): Boolean {
        val sizeBytes = getRealSizeFromUri(uri, context)
        val sizeKB: Float = sizeBytes.toFloat() / 1024
        val sizeMB: Float = sizeKB.toFloat() / 1024
        val showSize = sizeMB.toString().substring(0, sizeMB.toString().indexOf(".") + 2)
        if (sizeMB > (5 * 1024 * 1024)) {
            setAlertInfo(
                context,
                "File terlalu besar",
                "Ukuran file harus kurang dari 3 MB.\n (File yang anda pilih ${showSize} MB)"
            )
            return false
        }
        return true
    }

    private fun getRealSizeFromUri(uri: Uri, context: Context): Long {
        val SDK_INT = Build.VERSION.SDK_INT
        if (SDK_INT > 8) {
            val policy: StrictMode.ThreadPolicy = StrictMode.ThreadPolicy.Builder()
                .permitAll().build()
            StrictMode.setThreadPolicy(policy)
            //your codes here
        }
        if (Build.VERSION.SDK_INT > 22) {
            val permissionCheck = ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                    context as Activity,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    1
                )
            }
        }

        var cursor: Cursor? = null
        return try {
            val proj =
                arrayOf(MediaStore.Audio.Media.SIZE)
            cursor = context.contentResolver.query(uri, proj, null, null, null)
            val column_index = cursor!!.getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE)
            cursor.moveToFirst()
            cursor.getString(column_index).toLong()
        } finally {
            cursor?.close()
            0.0F
        }
    }

    fun wrapGate(code: () -> Unit) {
        try {
            code()
        } catch (e: Exception) {
            Log.e("Error Log",e.toString())
        }
    }

    fun wrapLocation(context: Context, code: (l: Location) -> Unit) {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            return
        }


        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
        if (globalLocation != null) {
            code(globalLocation!!)
            return
        }
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
//                    Timber.e("${location?.latitude}")
//                    Timber.e("${location?.longitude}")
                if (location != null) {
                    code(location)
                } else {
                    setAlertInfo(
                        context,
                        "Lokasi Tidak Ditemukan",
                        "Silahkan nyalakan GPS untuk menggunakan layanan ini."
                    )
                }
            }
    }

    fun startLocation() {
        mLocationRequest.interval = 60000
        mLocationRequest.fastestInterval = 5000
        mLocationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        val mLocationCallback: LocationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
//                if (locationResult == null) {
//                    return
//                }
                for (location in locationResult.getLocations()) {
                    if (location != null) {
                        globalLocation = location
                    }
                }
            }
        }
    }

    fun toPreview(activity: Activity, data: String) {
        if (data.contains(".pdf")) {
            val browserIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse(data))
            activity.startActivity(browserIntent)
        } else if (data.contains(".jpg") || data.contains(".png") || data.contains(".jpeg")) {
            openImage(activity, data)
        } else {
            val browserIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse(data))
            activity.startActivity(browserIntent)
        }


    }

    private fun openFile(url: File, activity: Activity) {
        try {
            val uri = Uri.fromFile(url)
            val intent = Intent(Intent.ACTION_VIEW)
            if (url.toString().contains(".doc") || url.toString().contains(".docx")) {
                // Word document
                intent.setDataAndType(uri, "application/msword")
            } else if (url.toString().contains(".pdf")) {
                // PDF file
                intent.setDataAndType(uri, "application/pdf")
            } else if (url.toString().contains(".ppt") || url.toString().contains(".pptx")) {
                // Powerpoint file
                intent.setDataAndType(uri, "application/vnd.ms-powerpoint")
            } else if (url.toString().contains(".xls") || url.toString().contains(".xlsx")) {
                // Excel file
                intent.setDataAndType(uri, "application/vnd.ms-excel")
            } else if (url.toString().contains(".zip")) {
                // ZIP file
                intent.setDataAndType(uri, "application/zip")
            } else if (url.toString().contains(".rar")) {
                // RAR file
                intent.setDataAndType(uri, "application/x-rar-compressed")
            } else if (url.toString().contains(".rtf")) {
                // RTF file
                intent.setDataAndType(uri, "application/rtf")
            } else if (url.toString().contains(".wav") || url.toString().contains(".mp3")) {
                // WAV audio file
                intent.setDataAndType(uri, "audio/x-wav")
            } else if (url.toString().contains(".gif")) {
                // GIF file
                intent.setDataAndType(uri, "image/gif")
            } else if (url.toString().contains(".jpg") || url.toString()
                    .contains(".jpeg") || url.toString().contains(".png")
            ) {
                // JPG file
                intent.setDataAndType(uri, "image/jpeg")
            } else if (url.toString().contains(".txt")) {
                // Text file
                intent.setDataAndType(uri, "text/plain")
            } else if (url.toString().contains(".3gp") || url.toString().contains(".mpg") ||
                url.toString().contains(".mpeg") || url.toString()
                    .contains(".mpe") || url.toString().contains(".mp4") || url.toString()
                    .contains(".avi")
            ) {
                // Video files
                intent.setDataAndType(uri, "video/*")
            } else {
                intent.setDataAndType(uri, "*/*")
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            activity.startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(
                activity,
                "No application found which can open the file",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun bsConfirm(
        context: Context,
        title: String,
        caption: String,
        icon: Int? = R.drawable.ic_confirm,
        code: () -> Unit
    ) {
        val layoutInflater: LayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v = layoutInflater.inflate(R.layout.bs_confirm, null)

        var bsd = BottomSheetDialog(context, R.style.BottomSheetDialog)
        var bsBind = BsConfirmBinding.bind(v)

        if (icon != null) {
            bsBind.icon.bindImage(context, icon)
        }
        bsBind.txTitle.text = title
        bsBind.txCaption.text = caption

        bsd.setContentView(bsBind.root)
        bsd.setCanceledOnTouchOutside(true)

        bsBind.btClose.setOnClickListener {
            bsd.dismiss()
        }
        bsBind.btNegative.setOnClickListener {
            bsd.dismiss()
        }
        bsBind.btPositive.setOnClickListener {
            bsd.dismiss()
            code()
        }


        bsd.show()
    }

    fun bsDelete(context: Context, title: String, caption: String, code: () -> Unit) {
        val layoutInflater: LayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v = layoutInflater.inflate(R.layout.bs_confirm, null)

        var bsd = BottomSheetDialog(context, R.style.BottomSheetDialog)
        var bsBind = BsConfirmBinding.bind(v)

        bsBind.icon.bindImage(context, R.drawable.ic_alert)
        bsBind.txTitle.text = title
        bsBind.txCaption.text = caption

        bsBind.btNegative.strokeColor = ColorStateList.valueOf(Color.DKGRAY)
        bsBind.btNegative.setTextColor(ColorStateList.valueOf(Color.DKGRAY))
        bsBind.btPositive.backgroundTintList = ColorStateList.valueOf(Color.RED)

        bsd.setContentView(bsBind.root)
        bsd.setCanceledOnTouchOutside(true)


        bsBind.btClose.setOnClickListener {
            bsd.dismiss()
        }
        bsBind.btNegative.setOnClickListener {
            bsd.dismiss()
        }
        bsBind.btPositive.setOnClickListener {
            bsd.dismiss()
            code()
        }
        bsd.show()
    }


    fun copyStreamToFile(inputStream: InputStream, outputFile: File) {
        inputStream.use { input ->
            val outputStream = FileOutputStream(outputFile)
            outputStream.use { output ->
                val buffer = ByteArray(4 * 1024) // buffer size
                while (true) {
                    val byteCount = input.read(buffer)
                    if (byteCount < 0) break
                    output.write(buffer, 0, byteCount)
                }
                output.flush()
            }
        }
    }

    fun getLocationDescription(context: Context, lat: Double, long: Double): String {
        val geocoder = Geocoder(context)

        var locName = ""
        try {
            val addressList: List<Address> =
                geocoder.getFromLocation(lat, long, 5) as List<Address>

            if (addressList.isEmpty()) {
                return locName
            }

            val split: Array<String> = addressList[0].getAddressLine(0).split(", ").toTypedArray()
            locName = addressList[0].getAddressLine(0).replace(split[0] + ", ", "")

            locName = split[1]
            if (split.size > 1) {
                locName = locName + ", " + split[2]
            }
            if (split.size > 2) {
                locName = locName + ", " + split[3]
            }


        } catch (e: IOException) {
            e.printStackTrace()
        }
        return locName
    }

    const val APP_UPDATE_REQUEST_CODE = 1997



    fun View.begone() = run {
        visibility = View.GONE
    }

    fun View.arise() = run {
        visibility = View.VISIBLE
    }


    fun getPathUri(activity:Activity, uri: Uri?): String? {
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = activity.contentResolver.query(uri!!, projection, null, null, null) ?: return null
        val column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        cursor.moveToFirst()
        val s = cursor.getString(column_index)
        cursor.close()
        return s
    }


//    fun bsArchive(context: Context, code: (nomor:String, kategoriId:Int?, kkaId:Int?, file: File?)->Unit){
//        var preference = AppPreference(context)
//
//        val layoutInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//        val v = layoutInflater.inflate(R.layout.bs_archive, null)
//
//        var bsd = BottomSheetDialog(context, R.style.BottomSheetDialog)
//        var bsBind = BsArchiveBinding.bind(v)
//
//
//        bsd.setContentView(bsBind.root)
//        bsd.setCanceledOnTouchOutside(true)
//
//        val kategori = preference.getStoredKategoriArsip()
//
//        val kategoriName = kategori.map { it.nama }
//
//        var kategoriId:Int? = null
//        var kkaId:Int? = null
//
//        bsBind.spKategori.setItems(kategoriName)
//        bsBind.spKategori.setOnSpinnerItemSelectedListener<String> { oldIndex, oldItem, newIndex, newItem ->
//            kategoriId =kategori.map { it.id }[newIndex]
//        }
//
//        bsBind.spKlasifikasi.setItems(preference.getKategoriKKAName())
//        bsBind.spKlasifikasi.setOnSpinnerItemSelectedListener<String> { oldIndex, oldItem, newIndex, newItem ->
//            kkaId =kategori.map { it.id }[newIndex]
//        }
//
//
//        bsBind.btClose.setOnClickListener {
//            bsd.dismiss()
//        }
//
//
//        bsBind.btApply.setOnClickListener {
//            var valid =true
//            valid = bsBind.etNomor.validation()
//            if(kategoriId==null){
//                valid = false
//                bsBind.spKategori.error="Wajib diisi"
//            }
//            if(kkaId==null){
//                valid = false
//                bsBind.spKlasifikasi.error="Wajib diisi"
//            }
//
//            if(valid){
//                code(bsBind.etNomor.text.toString(), kategoriId, kkaId, null)
//                bsd.dismiss()
//            }
//
//        }
//        bsd.show()
//    }


//        private fun popupSnackbarForCompleteUpdate(activity: Activity) {
//            val snackbar = Snackbar.make(
//                activity.window.decorView.rootView,
//                "An update has just been downloaded.",
//                Snackbar.LENGTH_INDEFINITE)
//            snackbar.setAction("RESTART") { appUpdateManager.completeUpdate() }
//            snackbar.setActionTextColor(ContextCompat.getColor(activity, R.color.colorAccent))
//            snackbar.show()
//        }


}
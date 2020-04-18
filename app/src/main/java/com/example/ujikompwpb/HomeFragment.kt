package com.example.ujikompwpb

import android.Manifest.permission.CAMERA
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentResolver
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home_fragment.*
import java.io.File
import java.io.IOException
import java.nio.file.Files.createFile
import java.text.SimpleDateFormat
import java.util.*
import java.util.jar.Manifest

class HomeFragment : AppCompatActivity() {

    private val IMAGE_CAPTURE_CODE = 1001
    private val PERMISSION_CODE = 1000;
    var image_uri : Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_fragment)


        val imageView = findViewById<ImageView>(R.id.image_view)
        val capture_btn = findViewById<TextView>(R.id.capture_btn)

        capture_btn.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if (checkSelfPermission(android.Manifest.permission.CAMERA)
                    == PackageManager.PERMISSION_DENIED ||
                    checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_DENIED){
                    //permission was not enabled
                    val permission = arrayOf(android.Manifest.permission.CAMERA, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    //show popup to request permission
                    requestPermissions(permission, PERMISSION_CODE)
                }
                else{
                    //permission already granted
                    openCamera()
                }
            }
            else{
                //system os is < marshamallow
                openCamera()
            }

        }




        val btn_look_respon = findViewById<Button>(R.id.btn_look_respon)
        val btn_profile = findViewById<Button>(R.id.btn_profile)
        val ic_profile = findViewById<ImageView>(R.id.ic_profile)
        val txt_send_report = findViewById<TextView>(R.id.txt_send_report)
        val btn_logout_apk = findViewById<ImageButton>(R.id.btn_logout_apk)



        btn_look_respon.setOnClickListener {
            intent = Intent(this, ResponFragment::class.java)
            startActivity(intent)
        }

        btn_profile.setOnClickListener {
            intent = Intent(this, ProfileFragment::class.java)
            startActivity(intent)
        }
        ic_profile.setOnClickListener {
            intent = Intent(this, ProfileFragment::class.java)
            startActivity(intent)
        }
        txt_send_report.setOnClickListener {
            val builder = AlertDialog.Builder(this@HomeFragment)

            builder.setTitle("Send Report")
            builder.setMessage("You sure you will send this report ? ")
            builder.setPositiveButton("Yes") { dialog, which ->
                Toast.makeText(this, "Your report has been sent", Toast.LENGTH_LONG).show()
            }
            builder.setNegativeButton("No") { dialog, which ->
                Toast.makeText(this, "You canceled send of the report", Toast.LENGTH_LONG).show()
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }

        btn_logout_apk.setOnClickListener {
            Toast.makeText(this, "Your account has been signed out", Toast.LENGTH_LONG).show()
            FirebaseAuth.getInstance().signOut()
            intent = Intent(this, LoginFragment::class.java)
            startActivity(intent)
        }





    }

    private fun openCamera() {

        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, "New Picture")
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the Camera")
        image_uri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
        //camera intent
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri)
        startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.size > 0 &&  grantResults [0] ==
                        PackageManager.PERMISSION_GRANTED){
                    //permission from popup was granted
                    openCamera()
                }
                else{
                    //permission from popup was denied
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //caled when image was captured from camera intent
        if (resultCode == Activity.RESULT_OK)
            //set image captured
            image_view.setImageURI(image_uri)
    }
}

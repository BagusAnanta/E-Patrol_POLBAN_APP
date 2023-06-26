package com.annas.e_patrolpolbanapp.view.reportArea

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.annas.e_patrolpolbanapp.R
import com.annas.e_patrolpolbanapp.view.absen.AbsenActivity
import com.annas.e_patrolpolbanapp.view.main.MainActivity
import com.google.android.gms.auth.api.signin.internal.Storage
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.util.UUID

class ReportAreaActivity : AppCompatActivity() {
    lateinit var takeCameraImage : ImageView
    lateinit var kejadianInput : EditText
    lateinit var submitData : Button

    lateinit var rootNode : FirebaseDatabase
    lateinit var reference : DatabaseReference

    private val PIC_ID = 123
    private val REQUEST_CAMERA_CODE = 124
    private var Uidcode = 1

   lateinit var filepath : Uri
   lateinit var firebaseStorage : FirebaseStorage
   lateinit var storageReference : StorageReference
    val GenerateUUID = UUID.randomUUID().toString()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_area)

        takeCameraImage = findViewById(R.id.imageKejadian)
        kejadianInput = findViewById(R.id.inputDeskripsi)
        submitData = findViewById(R.id.btnInputReport)

        // check permission
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            // if permission is not gratted
            ActivityCompat.requestPermissions(this@ReportAreaActivity, arrayOf(Manifest.permission.CAMERA),REQUEST_CAMERA_CODE)
        }

        takeCameraImage.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, PIC_ID)
        }

        // Button onClick intent into submit data
        submitData.setOnClickListener {
            rootNode = FirebaseDatabase.getInstance()
            reference = rootNode.getReference("UserReported")

            // get data
            Uidcode++
            val convert_Uid = Uidcode.toString()
            val photo_path = GenerateUUID
            val deskripsi = kejadianInput.text.toString()
            val isSafe = "Not Safe"

            // input into data class
            val firebaseDataClass = FireBaseDataClassNoSafe(photo_path,deskripsi,isSafe)

            // setValue in here
            reference.child(convert_Uid).setValue(firebaseDataClass)

            // after send data, we intent this
            val intent = Intent(ReportAreaActivity@this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == PIC_ID && resultCode == RESULT_OK && data != null){
            val photo : Bitmap = data?.extras?.get("data") as Bitmap
            takeCameraImage.setImageBitmap(photo)

            }
        }
}
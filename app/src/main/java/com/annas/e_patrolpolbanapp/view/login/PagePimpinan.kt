package com.annas.e_patrolpolbanapp.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.annas.e_patrolpolbanapp.R
import com.annas.e_patrolpolbanapp.utils.SessionLogin
import com.annas.e_patrolpolbanapp.view.component.DialogComponent
import com.annas.e_patrolpolbanapp.view.history.HistoryActivity
import com.annas.e_patrolpolbanapp.view.qrgenerate.QrGenerate
import kotlinx.android.synthetic.main.activity_page_pimpinan.*

class PagePimpinan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_pimpinan)
        // setInitLayout()
    }

   /* private fun setInitLayout() {
        val session = SessionLogin(this)
        session.checkLogin()

        btn_lihathistory.setOnClickListener {
            val intent = Intent(this@PagePimpinan, HistoryActivity::class.java)
            startActivity(intent)
        }

        btn_tambahlokasi.setOnClickListener {
            qrCodeGenerateOption()
        }

    }

    private fun qrCodeGenerateOption(){
       *//* val onPositif = {
            val intent = Intent(this@PagePimpinan, QrGenerate::class.java)
            startActivity(intent)
            finish()
        }
         DialogComponent().DialogComponentOption(
             this@PagePimpinan,
             title = "Generate QR Code",
             message = "Apakah Anda ingin membuat Qr Code ?",
             iconSet = android.R.drawable.ic_dialog_info,
             onCancel = true,
             onPositiveFunction = onPositif
         )*//*

        val builder = AlertDialog.Builder(this@PagePimpinan)
        builder.setTitle("Generate QR Code")
        builder.setMessage("Apakah Anda ingin membuat Qr Code ?")
        builder.setIcon(android.R.drawable.ic_dialog_info)

        // if positive button option
        builder.setPositiveButton("Ya"){dialogInterface, which ->
            // we gonna intent in here
            val intent = Intent(this@PagePimpinan, QrGenerate::class.java)
            startActivity(intent)
            finish()
        }

        // if negative button option
        builder.setNegativeButton("Tidak"){ dialogInterface, which ->
            // no Anymore code in here
        }
        val alertDialog : AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()

    }*/
}
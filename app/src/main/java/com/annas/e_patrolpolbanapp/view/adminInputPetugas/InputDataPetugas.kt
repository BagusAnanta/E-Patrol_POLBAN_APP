package com.annas.e_patrolpolbanapp.view.adminInputPetugas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.annas.e_patrolpolbanapp.R
import com.annas.e_patrolpolbanapp.view.main.MainActivity
import com.annas.e_patrolpolbanapp.viewmodel.AdminViewModel
import com.google.android.material.textfield.TextInputEditText

class InputDataPetugas : AppCompatActivity() {
    lateinit var inputNama : EditText
    lateinit var inputNo : EditText
    lateinit var inputArea : EditText
    lateinit var inputWaktu : EditText
    lateinit var inputUsername : TextInputEditText
    lateinit var inputPassword : TextInputEditText
    lateinit var buttonGetRecordData : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_data_petugas)

        inputNama = findViewById(R.id.inputNamaPetugas)
        inputNo = findViewById(R.id.inputNo)
        inputArea = findViewById(R.id.inputArea)
        inputWaktu = findViewById(R.id.inputWaktu)

        // for akun petugas
        inputUsername = findViewById(R.id.inputUsername)
        inputPassword = findViewById(R.id.inputPassword)

        buttonGetRecordData = findViewById(R.id.btnRecord)

        insertDataPetugas()
    }

    private fun insertDataPetugas(){
        buttonGetRecordData.setOnClickListener {
            val nama_Petugas = inputNama.text.toString()
            val no_Petugas = inputNo.text.toString()
            val area_petugas = inputArea.text.toString()
            val waktu_kerja = inputWaktu.text.toString()

            val username_Petugas_baru = inputUsername.text.toString()
            val password_Petugas_baru = inputPassword.text.toString()

            if(nama_Petugas.isEmpty() || no_Petugas.isEmpty() || area_petugas.isEmpty() || waktu_kerja.isEmpty() || username_Petugas_baru.isEmpty() || password_Petugas_baru.isEmpty()){
                // if a edit text have empty
                Toast.makeText(this,"Data Tidak Boleh Kosong !", Toast.LENGTH_SHORT).show()
            } else {
                // insert data
                val adminViewModel: AdminViewModel? = null
                adminViewModel?.addDataPetugas(
                    nama_Petugas,
                    no_Petugas,
                    area_petugas,
                    waktu_kerja,
                    username_Petugas_baru,
                    password_Petugas_baru
                )

                var listData = arrayOf(adminViewModel)
                Log.d("Size Data", listData.size.toString())

                Toast.makeText(this,"Data Anda berhasil dimasukkan!", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@InputDataPetugas,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
package com.example.mediocurso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mediocurso.databinding.ActivityScannerBinding
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class ActivityScanner : AppCompatActivity() {

    lateinit var binding: ActivityScannerBinding

    val db : FirebaseFirestore = FirebaseFirestore.getInstance()

    companion object{
        val NOMBRE_TABLA = "users"
        val CAMPO_CORREO = "correo"
        val CAMPO_NOMBRE = "nombre"
        val CAMPO_EMPRESA = "empresa"
        val CAMPO_TELEFONO = "telefono"
        val CAMPO_PUESTO = "puesto empresa"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScannerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.qrImage.setOnClickListener{
            val RegisterIntent = Intent(this, RegistroActivity::class.java)
            startActivity(RegisterIntent)
        }


    }
}
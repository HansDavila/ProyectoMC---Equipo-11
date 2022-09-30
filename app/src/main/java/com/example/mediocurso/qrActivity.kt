package com.example.mediocurso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import com.example.mediocurso.databinding.ActivityRegisterBinding.inflate

class qrActivity : AppCompatActivity() {
    lateinit var binding: qrActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr)

        //binding = qrActivity.inflate(layoutInflater)

        /*
        binding.btnCerrar2.setOnClickListener()
        {
            val intentMainActivity = Intent(this, MainActivity::class.java)
            startActivity(intentMainActivity)
        }
        */
    }
}
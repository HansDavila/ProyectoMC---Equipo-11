package com.example.mediocurso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mediocurso.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var  binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
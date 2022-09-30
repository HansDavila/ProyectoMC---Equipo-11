package com.example.mediocurso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mediocurso.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegistrar.setOnClickListener{
            val intentRegisterActivity = Intent(this, RegisterActivity::class.java)
            startActivity(intentRegisterActivity)




        }


        //setup
        setup()

    }

    private fun setup() {



        binding.btnLogin.setOnClickListener{
            if (binding.tvEmail.text.isNotEmpty() && binding.tvPassword.text.isNotEmpty()){

                FirebaseAuth.getInstance().signInWithEmailAndPassword(binding.tvEmail.text.toString(),
                    binding.tvPassword.text.toString()).addOnCompleteListener{

                    if(it.isSuccessful){
                        var toast = Toast.makeText(this, "ACCESO CONCEDIDO", Toast.LENGTH_SHORT).show()
                    }else{
                        var toast = Toast.makeText(this, "ERROR AL INICIAR SESION CON USUARIO", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
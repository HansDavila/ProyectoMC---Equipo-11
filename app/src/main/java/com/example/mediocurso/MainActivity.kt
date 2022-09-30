package com.example.mediocurso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mediocurso.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
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
                        showEmpleado(binding.tvEmail.text.toString())
                    }else{
                        var toast = Toast.makeText(this, "ERROR AL INICIAR SESION CON USUARIO", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }


    private fun showEmpleado(email: String){

        var puesto: String = ""

        db.collection(RegisterActivity.NOMBRE_TABLA).whereEqualTo(RegisterActivity.CAMPO_CORREO,email).get().addOnSuccessListener { documents ->


            val user = documents.first()
            puesto = user.get(CAMPO_PUESTO).toString()

            if(puesto.equals("empleado")){
                val EmpleadoIntent = Intent(this, ActivityEmpleado::class.java).apply {
                    putExtra(RegisterActivity.CAMPO_CORREO,email)
                }
                var toast = Toast.makeText(this, "ENTRADA DESDE DENTRO CON PUESTO: $puesto", Toast.LENGTH_SHORT).show()
                startActivity(EmpleadoIntent)

            }else if(puesto.equals("admin")){
                val AdminIntent = Intent(this, ActivityAdmin::class.java).apply {
                    putExtra(RegisterActivity.CAMPO_CORREO,email)
                }
                startActivity(AdminIntent)
            }

        }

    }
}
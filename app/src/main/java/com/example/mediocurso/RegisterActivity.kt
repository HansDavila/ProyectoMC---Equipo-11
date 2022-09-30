package com.example.mediocurso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mediocurso.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class RegisterActivity : AppCompatActivity() {
    lateinit var  binding: ActivityRegisterBinding
    val db : FirebaseFirestore = FirebaseFirestore.getInstance()
    var puesto = ""

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
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnRegistrar.setOnClickListener{
            if (binding.tvNombre.text.isNotEmpty() && binding.tvIdEmpleado.text.isNotEmpty() && binding.tvPassword.text.isNotEmpty() && binding.tvEmpresa.text.isNotEmpty() && binding.tvEmpresa.text.isNotEmpty()
                && binding.tvCorreo.text.isNotEmpty()){

                var switchState = binding.switchPuesto.isActivated


                FirebaseAuth.getInstance().createUserWithEmailAndPassword(binding.tvCorreo.text.toString(),     //crear auntenticador con datos de usuario
                    binding.tvPassword.text.toString()).addOnCompleteListener{


                    if(it.isSuccessful){

                        if(switchState){
                            puesto = "admin"
                        }else{
                            puesto = "empleado"
                        }

                        //CREACION DE BASE DE DATOS
                        db.collection(NOMBRE_TABLA).document(binding.tvIdEmpleado.text.toString()).set(
                            hashMapOf(

                                CAMPO_EMPRESA to binding.tvEmpresa.text.toString(),
                                CAMPO_NOMBRE to binding.tvNombre.text.toString(),
                                CAMPO_TELEFONO to binding.tvTelefono.text.toString(),
                                CAMPO_CORREO to binding.tvCorreo.text.toString(),
                                CAMPO_PUESTO to puesto
                            )
                        )

                        var toast = Toast.makeText(this, "USUARIO ${binding.tvNombre.text.toString()} GENERADO EXITOSAMENTE", Toast.LENGTH_SHORT).show()


                        showEmpleado(binding.tvCorreo.text.toString(), puesto)

                    }else{
                        var toast = Toast.makeText(this, "INGRESE TODOS LOS DATOS", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }


    private fun showEmpleado(email: String, puesto:String ){

        if(puesto.equals("empleado")){
            val EmpleadoIntent = Intent(this, ActivityEmpleado::class.java).apply {
                putExtra(CAMPO_CORREO,email)
            }
            startActivity(EmpleadoIntent)
        }

    }


}
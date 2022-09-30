package com.example.mediocurso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import com.example.mediocurso.databinding.ActivityModificarBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.lang.reflect.Modifier

class ActivityModificar : AppCompatActivity() {
    lateinit var binding:ActivityModificarBinding

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
        binding = ActivityModificarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle? = intent.extras
        val id: String? = bundle?.getString("id")
        var puesto:String = ""

        if (id != null) {
            db.collection(NOMBRE_TABLA).document(id).get().addOnSuccessListener { documentos ->
                val user = documentos

                binding.tvNombre.setText(user.get(CAMPO_CORREO).toString())
                binding.tvTelefono.setText(user.get(CAMPO_TELEFONO).toString())
                binding.tvEmpresa.setText(user.get(CAMPO_EMPRESA).toString())
                binding.tvCorreo.setText(user.get(CAMPO_CORREO).toString())
                puesto = user.id
            }


        }

        binding.btnModificar.setOnClickListener{
            if (binding.tvNombre.text.isNotEmpty() && binding.tvTelefono.text.isNotEmpty()  && binding.tvEmpresa.text.isNotEmpty() && binding.tvEmpresa.text.isNotEmpty()
                && binding.tvCorreo.text.isNotEmpty()){

                        //CREACION DE BASE DE DATOS
                if (id != null) {
                    db.collection(RegisterActivity.NOMBRE_TABLA).document(id).set(
                        hashMapOf(

                            RegisterActivity.CAMPO_EMPRESA to binding.tvEmpresa.text.toString(),
                            RegisterActivity.CAMPO_NOMBRE to binding.tvNombre.text.toString(),
                            RegisterActivity.CAMPO_TELEFONO to binding.tvTelefono.text.toString(),
                            RegisterActivity.CAMPO_CORREO to binding.tvCorreo.text.toString(),

                        )
                    )
                    var toast = Toast.makeText(this, "USUARIO ${binding.tvNombre.text.toString()} ACTUALIZADO EXITOSAMENTE", Toast.LENGTH_SHORT).show()


                    //showEmpleado(binding.tvCorreo.text.toString(), puesto)
                }



            }else{
                        var toast = Toast.makeText(this, "INGRESE TODOS LOS DATOS", Toast.LENGTH_SHORT).show()
            }


            }
        }

    /*
    private fun showEmpleado(email: String, puesto:String ){

        if(puesto.equals("empleado")){
            val EmpleadoIntent = Intent(this, ActivityEmpleado::class.java).apply {
                putExtra(RegisterActivity.CAMPO_CORREO,email)
            }
            startActivity(EmpleadoIntent)
        }else if(puesto.equals("admin")){
            val AdminIntent = Intent(this, ActivityAdmin::class.java).apply {
                putExtra(RegisterActivity.CAMPO_CORREO,email)
            }
            startActivity(AdminIntent)
        }

    }
    */



    }




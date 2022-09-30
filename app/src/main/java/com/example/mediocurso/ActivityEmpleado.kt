package com.example.mediocurso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mediocurso.databinding.ActivityEmpleadoBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot

class ActivityEmpleado : AppCompatActivity() {
    lateinit var binding: ActivityEmpleadoBinding
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

        binding = ActivityEmpleadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setup

        val bundle: Bundle? = intent.extras
        val email: String? = bundle?.getString(CAMPO_CORREO)

        db.collection(NOMBRE_TABLA).whereEqualTo(CAMPO_CORREO,email).get().addOnSuccessListener { documents ->
            /*
            val users = mutableListOf<QueryDocumentSnapshot>()
            for(document in documents){
                users.add(document)
            }
            */


            val user = documents.first()

            binding.tvName.setText(getString(R.string.Nombre_empleado, user.get(CAMPO_NOMBRE).toString()))
            binding.correoTv.setText(getString(R.string.correo_empleado, user.get(CAMPO_CORREO).toString()))
            binding.telefono.setText(getString(R.string.correo_empleado, user.get(CAMPO_TELEFONO).toString()))
            binding.empresa.setText(getString(R.string.empresa_empleado, user.get(CAMPO_EMPRESA).toString()))
            binding.idEmpleado.setText(getString(R.string.Id_empleado, user.id))
            binding.puesto.setText(getString(R.string.Puesto_empleado, user.get(CAMPO_PUESTO).toString()))


            /*
            binding.correoTv.text =  user.get(CAMPO_CORREO).toString()
            binding.telefono.text =  user.get(CAMPO_TELEFONO).toString()
            binding.empresa.text =  user.get(CAMPO_EMPRESA).toString()
            binding.puesto.text =  user.get(CAMPO_PUESTO).toString()
            binding.idEmpleado.text = user.id*/
        }

    }
}
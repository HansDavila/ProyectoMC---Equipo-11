package com.example.mediocurso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mediocurso.databinding.ActivityModificarBinding
import com.example.mediocurso.databinding.ActivityQrBinding
import com.google.firebase.firestore.FirebaseFirestore

class QrActivity : AppCompatActivity() {

    lateinit var binding: ActivityQrBinding

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
        binding = ActivityQrBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle? = intent.extras
        val id: String? = bundle?.getString("id")
        var puesto:String = ""

        if (id != null) {
            db.collection(ActivityModificar.NOMBRE_TABLA).document(id).get().addOnSuccessListener { documentos ->
                val user = documentos

                binding.tvName.setText(getString(R.string.Nombre_empleado, user.get(ActivityEmpleado.CAMPO_NOMBRE).toString()))

                binding.tvid.setText(getString(R.string.Id_admin, user.id))

            }


        }
    }
}
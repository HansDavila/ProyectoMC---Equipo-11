package com.example.mediocurso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mediocurso.databinding.ActivityAdminBinding
import com.example.mediocurso.databinding.ActivityEmpleadoBinding
import com.google.firebase.firestore.FirebaseFirestore

class ActivityAdmin : AppCompatActivity() {

    lateinit var binding: ActivityAdminBinding
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCerrar4.setOnClickListener()
        {
            val intentMainActivity = Intent(this, MainActivity::class.java)
            startActivity(intentMainActivity)
        }

        binding.btnEscanear2.setOnClickListener()
        {
            var toast = Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
        }
    }
}

/*
        val bundle: Bundle? = intent.extras
        val email: String? = bundle?.getString(ActivityEmpleado.CAMPO_CORREO)

        db.collection(ActivityEmpleado.NOMBRE_TABLA).whereEqualTo(ActivityEmpleado.CAMPO_CORREO,email).get().addOnSuccessListener { documents ->

            val users = mutableListOf<QueryDocumentSnapshot>()
            for(document in documents){
                users.add(document)
            }



            val user = documents.first()

            binding.tvName.setText(getString(R.string.Nombre_empleado, user.get(ActivityEmpleado.CAMPO_NOMBRE).toString()))
            binding.correoTv.setText(getString(R.string.correo_empleado, user.get(ActivityEmpleado.CAMPO_CORREO).toString()))
            binding.telefono.setText(getString(R.string.Telefono_empleado, user.get(ActivityEmpleado.CAMPO_TELEFONO).toString()))
            binding.empresa.setText(getString(R.string.empresa_empleado, user.get(ActivityEmpleado.CAMPO_EMPRESA).toString()))
            binding.idEmpleado.setText(getString(R.string.Id_admin, user.id))
            binding.puesto.setText(getString(R.string.Puesto_empleado, user.get(ActivityEmpleado.CAMPO_PUESTO).toString()))


            /*
            binding.correoTv.text =  user.get(CAMPO_CORREO).toString()
            binding.telefono.text =  user.get(CAMPO_TELEFONO).toString()
            binding.empresa.text =  user.get(CAMPO_EMPRESA).toString()
            binding.puesto.text =  user.get(CAMPO_PUESTO).toString()
            binding.idEmpleado.text = user.id*/
package com.dorysparadise.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dorysparadise.bl.models.Usuario
import com.dorysparadise.da.io.RetrofitAdapter
import com.dorysparadise.da.io.RetrofitService
import com.dorysparadise.databinding.ActivityPerfilesBinding

class PerfilesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPerfilesBinding
    private lateinit var retrofitService: RetrofitService
    private lateinit var usuario: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecursos()
        initListeners()

//        lifecycleScope.launch(Dispatchers.IO) {
//            val usuario1 = retrofitService.usuarioPorId(1)
//            val usuario2 = retrofitService.usuarioPorId(2)
//            withContext(Dispatchers.Main) {
//                binding.txtTitulo.text = respuesta[0].descripcion
//                binding.txtSeleccionar.text = usuario.nombre
//                binding.imgbtnDory.setI
//            }
//        }

    }

    private fun initRecursos() {
        retrofitService = RetrofitAdapter.getRetrofit()
    }

    private fun initListeners() {
        binding.imgbtnSol.setOnClickListener { irInicioSesion(1) }
        binding.imgbtnDory.setOnClickListener { irInicioSesion(2) }
    }

    private fun irInicioSesion(id: Int) {
        val intent = Intent(this, InicioSesionActivity::class.java)
        intent.putExtra("id", id)
//        intent.putExtra("id", usuario)
        startActivity(intent)
    }


    

}
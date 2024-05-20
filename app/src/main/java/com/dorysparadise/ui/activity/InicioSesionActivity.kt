package com.dorysparadise.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dorysparadise.bl.models.Usuario
import com.dorysparadise.da.io.RetrofitAdapter
import com.dorysparadise.da.io.RetrofitService
import com.dorysparadise.databinding.ActivityInicioSesionBinding

class InicioSesionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInicioSesionBinding
    private lateinit var retrofitService: RetrofitService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val foo = intent
        val nombre = intent.getIntExtra("id", 0)

        initRecursos()
        initListeners()
        setValores()
    }

    private fun initRecursos() {
        binding = ActivityInicioSesionBinding.inflate(layoutInflater)
        retrofitService = RetrofitAdapter.getRetrofit()
    }

    private fun initListeners() {
        binding.btnIngresar.setOnClickListener { irBarraNavegacion() }
    }

    private fun setValores() {
//        binding.imgUsuario.setImageDrawable()
    }

    private fun irBarraNavegacion() {
        val miIntent = Intent(this, BarraNavActivity::class.java)
        val usuario = intent.getSerializableExtra("id", Usuario)
    }
}
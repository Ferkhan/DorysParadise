package com.dorysparadise.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.dorysparadise.R
import com.dorysparadise.bl.models.Usuario
import com.dorysparadise.da.io.RetrofitAdapter
import com.dorysparadise.da.io.RetrofitService
import com.dorysparadise.databinding.ActivityPerfilesBinding
import com.dorysparadise.utilities.PicassoUtil
import com.dorysparadise.utilities.UtilityApplication.Companion.sharedPrefs
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PerfilesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPerfilesBinding
    private lateinit var retrofitService: RetrofitService
    private lateinit var usuario1: Usuario
    private lateinit var usuario2: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecursos()
        initListeners()

    }

    private fun setValores() {
        Picasso.get()
            .load("https://images.dog.ceo/breeds/hound-afghan/n02088094_1023.jpg")
            .into(binding.imgbtnSol)
        PicassoUtil().getImg("perfil/perfil.jpg")
            .placeholder(R.drawable.usuario)
            .into(binding.imgbtnDory)
    }

    private fun initRecursos() {
        retrofitService = RetrofitAdapter.getRetrofit()

        lifecycleScope.launch(Dispatchers.IO) {
            usuario1 = retrofitService.getUsuarioPorId(1).body()!!
            usuario2 = retrofitService.getUsuarioPorId(2).body()!!
            withContext(Dispatchers.Main) {
                setValores()
            }
        }
    }

    private fun initListeners() {
        binding.imgbtnSol.setOnClickListener { irInicioSesion(1) }
        binding.imgbtnDory.setOnClickListener { irInicioSesion(2) }
    }

    private fun irInicioSesion(id: Int) {
        val intent = Intent(this, InicioSesionActivity::class.java)
        if (id == 1)
            sharedPrefs.setUsuario(usuario1)
        else
            sharedPrefs.setUsuario(usuario2)

        startActivity(intent)
    }


    

}
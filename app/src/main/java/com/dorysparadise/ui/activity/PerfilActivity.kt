package com.dorysparadise.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dorysparadise.R
import com.dorysparadise.bl.models.Usuario
import com.dorysparadise.databinding.ActivityPerfilBinding
import com.dorysparadise.utilities.PicassoUtil
import com.dorysparadise.utilities.UtilityApplication
import com.squareup.picasso.Picasso

class PerfilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPerfilBinding
    private lateinit var usuario: Usuario
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecursos()
        initListeners()
        setValores()
    }

    private fun initRecursos() {
        usuario = UtilityApplication.sharedPrefs.getUsuario()
    }

    private fun setValores() {
        binding.txtNombre.text = usuario.nombre
        binding.txtCorreo.text = usuario.correo
        PicassoUtil().getImg(usuario.imgRuta)
            .into(binding.imgUsuario)
    }

    private fun initListeners() {
        binding.btnEditar.setOnClickListener { irPerfilConfig() }

        binding.btnLegislacion.setOnClickListener { irLegislacion() }
    }

    private fun irLegislacion() {
        startActivity(Intent(this, LegislacionActivity::class.java))
    }

    private fun irPerfilConfig() {
        startActivity(Intent(this, PerfilConfigActivity::class.java))
    }
}
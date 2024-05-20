package com.dorysparadise.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dorysparadise.R
import com.dorysparadise.databinding.ActivityPerfilBinding

class PerfilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPerfilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
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
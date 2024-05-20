package com.dorysparadise.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dorysparadise.R
import com.dorysparadise.databinding.ActivityPerfilConfigBinding

class PerfilConfigActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPerfilConfigBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilConfigBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
    }

    private fun initListeners() {
        binding.btnCancelar.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }
}
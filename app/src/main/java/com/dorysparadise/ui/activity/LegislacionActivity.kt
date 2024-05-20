package com.dorysparadise.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dorysparadise.R
import com.dorysparadise.databinding.ActivityLegislacionBinding

class LegislacionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLegislacionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLegislacionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
    }

    private fun initListeners() {
        binding.btnAceptar.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }
}
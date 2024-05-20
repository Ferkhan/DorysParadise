package com.dorysparadise.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.dorysparadise.R
import com.dorysparadise.bl.models.Producto
import com.dorysparadise.databinding.ActivityBarraNavBinding
import com.dorysparadise.ui.fragment.ProductosFragment

class BarraNavActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBarraNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        reemplazarFragment(Productos())

    }

    private fun initRecursos() {
        binding = ActivityBarraNavBinding.inflate(layoutInflater)
    }

    private fun initListeners() {
        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.productos -> reemplazarFragment(Productos())
                R.id.saldo -> reemplazarFragment(Saldo())
                R.id.sugerencias -> reemplazarFragment(Sugerencias())
            }
            true
        }
    }

    private fun reemplazarFragment(fragmento: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransacction = fragmentManager.beginTransaction()
        fragmentTransacction.replace(R.id.frame_layout, fragmento)
        fragmentTransacction.commit()
    }
}
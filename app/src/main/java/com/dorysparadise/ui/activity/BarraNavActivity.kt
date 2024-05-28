package com.dorysparadise.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dorysparadise.R
import com.dorysparadise.databinding.ActivityBarraNavBinding
import com.dorysparadise.ui.fragment.ProductosFragment
import com.dorysparadise.ui.fragment.SaldoFragment
import com.dorysparadise.ui.fragment.SugerenciasFragment
import com.dorysparadise.utilities.PicassoUtil
import com.dorysparadise.utilities.UtilityApplication.Companion.sharedPrefs

class BarraNavActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBarraNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBarraNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            reemplazarFragment(ProductosFragment())
        }

        initRecursos()
        initListeners()
        setValores()

    }

    private fun setValores() {
        PicassoUtil().getImg(sharedPrefs.getUsuario().imgRuta)
            .into(binding.imgPerfil)
    }

    private fun initRecursos() {

    }

    private fun initListeners() {
        binding.imgPerfil.setOnClickListener { irPerfil() }

        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.productos -> reemplazarFragment(ProductosFragment())
                R.id.saldo -> reemplazarFragment(SaldoFragment())
                R.id.sugerencias -> reemplazarFragment(SugerenciasFragment())
            }
            true
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val productosFragment = ProductosFragment()
                val currentFragment = supportFragmentManager.findFragmentById(R.id.frame_layout)

                if (currentFragment !is ProductosFragment) {
                    reemplazarFragment(productosFragment)
                    binding.bottomNav.selectedItemId = R.id.productos
                } else {
                    finish()
                }
            }

        })
    }

    private fun irPerfil() {
        startActivity(Intent(this, PerfilActivity::class.java))
    }

    private fun reemplazarFragment(fragmento: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransacction = fragmentManager.beginTransaction()
        fragmentTransacction.replace(R.id.frame_layout, fragmento)
        fragmentTransacction.commit()
    }


}
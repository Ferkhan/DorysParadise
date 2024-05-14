package com.dorysparadise.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.widget.TextView
import android.widget.Toast
import androidx.activity.SystemBarStyle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.dorysparadise.R
import com.dorysparadise.bl.entities.Producto
import com.dorysparadise.bl.repositories.ProductoRepo
import com.dorysparadise.bl.repositories.UsuarioRepo
import com.dorysparadise.databinding.ActivityPerfilesBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class PerfilesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPerfilesBinding
    private lateinit var texto: TextView
//    private val listaProduc = mutableLiveData<Int>()
    private lateinit var productoRepo: ProductoRepo
    private lateinit var productos: List<Producto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        inicarRecursos()
        iniciarListeners()

        val usuarioRepo = UsuarioRepo(this)
        val productoRepo = ProductoRepo(this)

//        productoRepo.obtenerRegistros3()
        lifecycleScope.launch(Dispatchers.Main) {
//
//            binding.txtTitulo.text = productoRepo.getListaProductos()[0].getNombre()
            // WITH CONTEXT
            productos = productoRepo.obtenerRegistros2()
            if (productos.isNotEmpty()) {
                binding.txtTitulo.text = productos[0].getNombre()
            } else {
                binding.txtTitulo.text = "no hay nada *troste"
            }
        }

            // LIVE DATA
//            productoRepo.obtenerRegistros().observe(this@PerfilesActivity) { listaProductos ->
//                Log.e("DoryError", "lifecycle")
//                if (listaProductos.isNotEmpty()) {
//                    binding.txtTitulo.text = listaProductos[0].getNombre()
//                } else {
//                binding.txtTitulo.text = "patata"
//                }
//
//            }
//        }

    }

    private fun inicarRecursos() {
        productoRepo = ProductoRepo(this)
    }

    private fun iniciarListeners() {
        binding.imgbtnSol.setOnClickListener {
            Toast.makeText(this, "Sol", Toast.LENGTH_LONG).show()
        }
        binding.imgbtnDory.setOnClickListener {
            Toast.makeText(this, "Dory", Toast.LENGTH_SHORT).show()
        }
    }


    

}
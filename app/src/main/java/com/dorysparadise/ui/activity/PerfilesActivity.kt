package com.dorysparadise.ui.activity

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.dorysparadise.bl.models.Producto
import com.dorysparadise.da.io.RetrofitAdapter
import com.dorysparadise.databinding.ActivityPerfilesBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PerfilesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPerfilesBinding
    private lateinit var texto: TextView
//    private val listaProduc = mutableLiveData<Int>()
    private lateinit var productos: List<Producto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        inicarRecursos()
        iniciarListeners()

        val service = RetrofitAdapter.getRetrofit()
        lifecycleScope.launch(Dispatchers.IO) {
            val respuesta = service.productoLista()
            val usuario = service.usuarioPorId(1)
            withContext(Dispatchers.Main) {
                binding.txtTitulo.text = respuesta[0].descripcion
                binding.txtSeleccionar.text = usuario.nombre
            }
        }

    }

    private fun inicarRecursos() {
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
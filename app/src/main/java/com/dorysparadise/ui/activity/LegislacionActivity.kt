package com.dorysparadise.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.dorysparadise.bl.adapters.PoliticaAdapter
import com.dorysparadise.bl.models.Politica
import com.dorysparadise.da.io.RetrofitAdapter
import com.dorysparadise.databinding.ActivityLegislacionBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LegislacionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLegislacionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLegislacionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setValores()
        initListeners()
        initRecyclerView()
    }

    private fun initListeners() {
        binding.btnAceptar.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }

    private fun setValores() {
        cambiarAviso("Cargando politicas...")
    }

    private fun initRecyclerView() {
        lifecycleScope.launch (Dispatchers.IO){
            val respuesta = RetrofitAdapter.getRetrofit().getPoliticaLista()
            val adaptador: PoliticaAdapter
            val listaPoliticas: List<Politica>

            withContext(Dispatchers.Main) {
                if (respuesta.isSuccessful) {
                    listaPoliticas = respuesta.body()!!
                    if (listaPoliticas.isNotEmpty()) {
                        adaptador = PoliticaAdapter(listaPoliticas)
                        binding.rvPoliticas.layoutManager = LinearLayoutManager(this@LegislacionActivity)
                        binding.txtAviso.text = null
                        binding.rvPoliticas.adapter = adaptador
                    } else {
                        cambiarAviso("No existen politicas")
                    }
                } else {
                    cambiarAviso("Error de conexión. Vuelva a intentarlo")
                }
            }
        }
    }

    private fun cambiarAviso(mensaje: String) {
        binding.txtAviso.text = mensaje
    }
}
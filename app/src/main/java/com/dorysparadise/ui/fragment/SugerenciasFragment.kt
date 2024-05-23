package com.dorysparadise.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.dorysparadise.bl.adapters.SugerenciasAdapter
import com.dorysparadise.bl.models.Sugerencia
import com.dorysparadise.da.io.RetrofitAdapter
import com.dorysparadise.databinding.FragmentSugerenciasBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SugerenciasFragment : Fragment() {
    private lateinit var binding: FragmentSugerenciasBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSugerenciasBinding.inflate(inflater, container, false)

        setValores()
        initRecyclerView()

        return binding.root
    }

    private fun setValores() {
        cambiarAviso("Cargando sugerencias...")
    }

    private fun initRecyclerView() {
        lifecycleScope.launch (Dispatchers.IO){
            val respuesta = RetrofitAdapter.getRetrofit().getSugerenciaLista()
            val adaptador: SugerenciasAdapter
            val listaSugerencias: List<Sugerencia>

            withContext(Dispatchers.Main) {
                if (respuesta.isSuccessful) {
                    listaSugerencias = respuesta.body()!!
                    if (listaSugerencias.isNotEmpty()) {
                        adaptador = SugerenciasAdapter(listaSugerencias)
                        binding.rvSugerencias.layoutManager = LinearLayoutManager(context)
                        binding.txtAviso.text = null
                        binding.rvSugerencias.adapter = adaptador
                    } else {
                        cambiarAviso("No existen sugerencias")
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
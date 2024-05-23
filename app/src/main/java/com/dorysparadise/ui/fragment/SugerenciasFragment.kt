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
            debug("ingreso a lifecycle")
            val respuesta = RetrofitAdapter.getRetrofit().getSugerenciaLista()
            debug("retrofit")
            val adaptador: SugerenciasAdapter
            debug("adaptador")
            val listaSugerencias: List<Sugerencia>
            debug("fin de declaraciones")

            withContext(Dispatchers.Main) {
                if (respuesta.isSuccessful) {
                    debug("respuesta succesful")
                    listaSugerencias = respuesta.body()!!
                    if (listaSugerencias.isNotEmpty()) {
                        debug("lista no vacia")
                        adaptador = SugerenciasAdapter(listaSugerencias)
                        binding.rvSugerencias.layoutManager = LinearLayoutManager(context)
                        binding.txtAviso.text = null
                        binding.rvSugerencias.adapter = adaptador
                    } else {
                        debug("lista vacia")
                        cambiarAviso("No existen sugerencias")
                    }
                } else {
                    debug("error de conexion")
                    cambiarAviso("Error de conexión. Vuelva a intentarlo")
                }
            }
        }
    }

    private fun cambiarAviso(mensaje: String) {
        binding.txtAviso.text = mensaje
    }

    private fun debug(mensaje: String) {
        Log.i("MyDorisError", mensaje)
    }


}
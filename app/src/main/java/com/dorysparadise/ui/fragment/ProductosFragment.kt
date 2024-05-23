package com.dorysparadise.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dorysparadise.bl.adapters.ProductosAdapter
import com.dorysparadise.bl.models.Producto
import com.dorysparadise.da.io.RetrofitAdapter
import com.dorysparadise.databinding.FragmentProductosBinding
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductosFragment : Fragment() {
    private lateinit var binding: FragmentProductosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductosBinding.inflate(inflater, container, false)

        setValores()
        initRecyclerView()

        return binding.root
    }

    private fun setValores() {
        cambiarAviso("Cargando productos...")
    }

    private fun initRecyclerView() {

        lifecycleScope.launch (Dispatchers.IO){
            val respuesta = RetrofitAdapter.getRetrofit().getProductoLista()
            val adaptador: ProductosAdapter
            val listaProductos: List<Producto>

            withContext(Dispatchers.Main) {
                if (respuesta.isSuccessful) {
                    listaProductos = respuesta.body()!!
                    if (listaProductos.isNotEmpty()) {
                        adaptador = ProductosAdapter(listaProductos)
                        binding.rvProductos.layoutManager = LinearLayoutManager(context)
                        binding.txtAviso.text = null
                        binding.rvProductos.adapter = adaptador
                    } else {
                        cambiarAviso("No existen productos disponibles")
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
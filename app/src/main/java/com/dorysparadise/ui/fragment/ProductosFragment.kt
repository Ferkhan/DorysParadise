package com.dorysparadise.ui.fragment

import android.os.Bundle
import android.util.Log
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
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class ProductosFragment : Fragment() {
    private lateinit var binding: FragmentProductosBinding
    private lateinit var listaProductos: List<Producto>
    private lateinit var respuesta: Response<List<Producto>>
    private lateinit var adaptador: ProductosAdapter
    private lateinit var espera: Deferred<Response<List<Producto>>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.i("DorysProduct", "view create")
        binding = FragmentProductosBinding.inflate(inflater, container, false)

        setValores()
        initRecyclerView()

        return binding.root
    }

    private fun setValores() {
        cambiarAviso("Cargando productos...")
    }

    private fun initRecyclerView() {
        lifecycleScope.launch (Dispatchers.Main){
            respuesta = withContext(Dispatchers.IO) { RetrofitAdapter.getRetrofit().getProductoLista() }
            if (respuesta.isSuccessful) {
                listaProductos = respuesta.body()!!
                if (listaProductos.isNotEmpty()) {
                    adaptador = ProductosAdapter(listaProductos)
                    binding.rvProductos.setHasFixedSize(true)
                    binding.rvProductos.adapter = adaptador
                    binding.rvProductos.layoutManager = LinearLayoutManager(context)
                    binding.txtAviso.text = null
                } else {
                    cambiarAviso("No existen productos disponibles")
                }
            } else {
                cambiarAviso("Error de conexión. Vuelva a intentarlo")
            }
        }
    }

    private fun cambiarAviso(mensaje: String) {
        binding.txtAviso.text = mensaje
    }
}
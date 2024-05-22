package com.dorysparadise.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.dorysparadise.R
import com.dorysparadise.bl.adapters.ProductosAdapter
import com.dorysparadise.da.io.RetrofitAdapter
import com.dorysparadise.da.io.RetrofitService
import com.dorysparadise.databinding.FragmentProductosBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductosFragment : Fragment() {
    private lateinit var binding: FragmentProductosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductosBinding.inflate(inflater, container, false)

        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        lifecycleScope.launch (Dispatchers.IO){
            val listaProductos = RetrofitAdapter.getRetrofit().getProductoLista()
            val adaptador = ProductosAdapter(listaProductos)

            withContext(Dispatchers.Main) {
                binding.rvProductos.layoutManager = LinearLayoutManager(context)
                binding.rvProductos.adapter = adaptador
            }
        }
    }
}
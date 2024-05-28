package com.dorysparadise.bl.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dorysparadise.R
import com.dorysparadise.bl.models.Producto

class ProductosAdapter(val listaProductos: List<Producto>) : RecyclerView.Adapter<ProductosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductosViewHolder(layoutInflater.inflate(R.layout.item_producto, parent, false))
    }


    override fun getItemCount(): Int = listaProductos.size


    override fun onBindViewHolder(holder: ProductosViewHolder, position: Int) {
        holder.bind(listaProductos[position])
    }

    fun updateData(newItems: List<Producto>) {
        listaProductos.toMutableList().clear()
        listaProductos.toMutableList().addAll(newItems)
        notifyDataSetChanged()     }
}
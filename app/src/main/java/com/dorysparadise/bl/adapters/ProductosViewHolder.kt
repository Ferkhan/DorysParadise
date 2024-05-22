package com.dorysparadise.bl.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dorysparadise.bl.models.Producto
import com.dorysparadise.databinding.ItemProductoBinding
import com.dorysparadise.utilities.PicassoUtil

class ProductosViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemProductoBinding.bind(view)

    fun bind(producto: Producto) {
        val precio = "Precio: ${producto.precio} dorydolares"
        val provedor = "Ofertado por ${producto.usuario}"
        val disponibilidad = "Disponibilidad: ${producto.disponibilidad}"

        binding.txtNombre.text = producto.nombre
        binding.txtDescripcion.text = producto.descripcion
        binding.txtProvedor.text = provedor
        binding.txtPrecio.text = precio
        binding.txtDisponibilidad.text = disponibilidad
//        PicassoUtil().getImg(producto.imgRuta).into(binding.imgProducto)
    }
}

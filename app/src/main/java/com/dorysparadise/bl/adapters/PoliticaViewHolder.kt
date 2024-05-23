package com.dorysparadise.bl.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dorysparadise.bl.models.Politica
import com.dorysparadise.databinding.ItemPoliticaBinding

class PoliticaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemPoliticaBinding.bind(view)

    fun bind(politica: Politica) {
        binding.txtTitulo.text = politica.titulo
        binding.txtContenido.text = politica.contenido
    }
}
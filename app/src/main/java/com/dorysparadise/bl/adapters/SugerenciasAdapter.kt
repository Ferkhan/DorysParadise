package com.dorysparadise.bl.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dorysparadise.R
import com.dorysparadise.bl.models.Sugerencia

class SugerenciasAdapter(private val listaSugerencias: List<Sugerencia>) : RecyclerView.Adapter<SugerenciasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SugerenciasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SugerenciasViewHolder(layoutInflater.inflate(R.layout.item_sugerencia, parent, false))
    }

    override fun getItemCount(): Int = listaSugerencias.size

    override fun onBindViewHolder(holder: SugerenciasViewHolder, position: Int) {
        holder.bind(listaSugerencias[position])
    }
}
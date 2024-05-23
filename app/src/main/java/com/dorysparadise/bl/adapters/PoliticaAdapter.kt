package com.dorysparadise.bl.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dorysparadise.R
import com.dorysparadise.bl.models.Politica

class PoliticaAdapter(private val listaPoliticas: List<Politica>) : RecyclerView.Adapter<PoliticaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoliticaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PoliticaViewHolder(layoutInflater.inflate(R.layout.item_politica, parent, false))
    }

    override fun getItemCount(): Int = listaPoliticas.size

    override fun onBindViewHolder(holder: PoliticaViewHolder, position: Int) {
        holder.bind(listaPoliticas[position])
    }
}
package com.dorysparadise.bl.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dorysparadise.bl.models.Sugerencia
import com.dorysparadise.databinding.ItemSugerenciaBinding

class SugerenciasViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemSugerenciaBinding.bind(view)

    fun bind(sugerencia: Sugerencia) {
        binding.txtDescripcion.text = sugerencia.descripcion
        binding.txtUsuario.text = sugerencia.usuario
        binding.txtSituacion.text = sugerencia.situacion
        binding.txtFecha.text = sugerencia.fechaPubli.toString()
    }
}
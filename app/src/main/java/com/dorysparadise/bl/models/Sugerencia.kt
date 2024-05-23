package com.dorysparadise.bl.models

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class Sugerencia(
    val id: Int,
    val usuario: String,
    val situacion: String,
    val descripcion: String,
    @SerializedName("fecha_publicacion")
    val fechaPubli: String
//    val fechaPubli: LocalDateTime
)

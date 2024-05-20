package com.dorysparadise.bl.models

import com.google.gson.annotations.SerializedName

data class Producto (
    val id: Int,
    val usuario: String,
    val disponibilidad: String,
    val clasificacion: String,
    val nombre: String,
    val descripcion: String,
    val precio: Int,
    @SerializedName("img_ruta")
    val imgRuta: String


)
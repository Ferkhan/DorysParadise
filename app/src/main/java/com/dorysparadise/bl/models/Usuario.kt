package com.dorysparadise.bl.models

import com.google.gson.annotations.SerializedName

data class Usuario(
    val id: Int,
    val rol: String,
    val nombre: String,
    val correo: String,
    val clave: String,
    @SerializedName("img_ruta")
    val imgRuta: String
)
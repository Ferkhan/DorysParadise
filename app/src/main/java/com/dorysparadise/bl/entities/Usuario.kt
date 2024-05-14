package com.dorysparadise.bl.entities

data class Usuario(
    private val id: Int,
    private val rol: String,
    private val nombre: String,
    private val correo: String,
    private val clave: String,
    private val imgRuta: String
)
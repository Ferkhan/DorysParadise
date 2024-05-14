package com.dorysparadise.bl.entities

data class Producto (
    private val id: Int,
    private val usuario: String,
    private val disponibilidad: String,
    private val clasificacion: String,
    private val nombre: String,
    private val descripcion: String,
    private val precio: Int,
    private val imgRuta: String
)
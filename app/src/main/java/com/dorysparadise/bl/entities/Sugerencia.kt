package com.dorysparadise.bl.entities

import java.time.LocalDateTime

data class Sugerencia(
    private val id: Int,
    private val usuario: String,
    private val situacion: String,
    private val descripcion: String,
    private val fechaPubli: LocalDateTime
)

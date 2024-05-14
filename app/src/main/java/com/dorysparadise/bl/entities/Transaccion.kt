package com.dorysparadise.bl.entities

import java.time.LocalDateTime

data class Transaccion(
    private val id: Int,
    private val usuario: String,
    private val operacion: String,
    private val precio: Int,
    private val motivo: String,
    private val fechaOperacion: LocalDateTime
)
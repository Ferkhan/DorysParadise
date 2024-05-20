package com.dorysparadise.bl.models

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class Transaccion(
    val id: Int,
    val usuario: String,
    val operacion: String,
    val precio: Int,
    val motivo: String,
    @SerializedName("fecha_operacion")
    val fechaOperacion: LocalDateTime
)
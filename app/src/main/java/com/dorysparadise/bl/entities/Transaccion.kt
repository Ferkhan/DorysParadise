package com.dorysparadise.bl.entities

import java.time.LocalDateTime

data class Transaccion(
    private var id: Int? = null,
    private var usuario: String? = null,
    private var operacion: String? = null,
    private var precio: Int? = null,
    private var motivo: String? = null,
    private var fechaOperacion: LocalDateTime? = null
) {
    fun setId(id: Int) {this.id = id}
    fun getId() = this.id
    fun setUsuario(usuario: String) {this.usuario = usuario}
    fun getUsuario() = this.usuario
    fun setOperacion(operacion: String) {this.operacion = operacion}
    fun getOperacion() = this.operacion
    fun setMotivo(motivo: String) {this.motivo = motivo}
    fun getMotivo() = this.motivo
    fun setPrecio(precio: Int) {this.precio = precio}
    fun getPrecio() = this.precio
    fun setFechaOperacion(fechaOperacion: LocalDateTime) {this.fechaOperacion = fechaOperacion}
    fun getFechaOperacion() = this.fechaOperacion
}

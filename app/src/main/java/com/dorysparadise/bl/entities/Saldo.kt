package com.dorysparadise.bl.entities

data class Saldo(
    private var id: Int,
    private var cantidad: Int
) {
    fun setId(id: Int) {this.id = id}
    fun getId() = this.id
    fun setCantidad(cantidad: Int) {this.cantidad = cantidad}
    fun getCantidad() = this.cantidad
}

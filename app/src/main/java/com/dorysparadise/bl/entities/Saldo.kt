package com.dorysparadise.bl.entities

data class Saldo(
    private var id: Int? = null,
    private var cantidad: Int? = null
) {

    fun setId(id: Int) {this.id = id}
    fun getId() = this.id
    fun setCantidad(cantidad: Int) {this.cantidad = cantidad}
    fun getCantidad() = this.cantidad
}

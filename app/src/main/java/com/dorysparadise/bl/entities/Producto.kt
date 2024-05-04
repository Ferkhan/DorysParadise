package com.dorysparadise.bl.entities

data class Producto (
    private var id: Int,
    private var usuario: String,
    private var disponibilidad: String,
    private var clasificacion: String,
    private var nombre: String,
    private var descripcion: String,
    private var precio: Int,
    private var imgRuta: String
) {
    fun setId(id: Int) {this.id = id}
    fun getId() = this.id
    fun setUsuario(usuario: String) {this.usuario = usuario}
    fun getUsuario() = this.usuario
    fun setDisponibilidad(disponibilidad: String) {this.disponibilidad = disponibilidad}
    fun getDisponibilidad() = this.disponibilidad
    fun setClasificacion(clasificacion: String) {this.clasificacion = clasificacion}
    fun getClasificacion() = this.clasificacion
    fun setNombre(nombre: String) {this.nombre = nombre}
    fun getNombre() = this.nombre
    fun setDescripcion(descripcion: String) {this.descripcion = descripcion}
    fun getDescripcion() = this.descripcion
    fun setPrecio(precio: Int) {this.precio = precio}
    fun getPrecio() = this.precio
    fun setImgRuta(imgRuta: String) {this.imgRuta = imgRuta}
    fun getImgRuta() = this.imgRuta
}
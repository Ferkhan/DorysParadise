package com.dorysparadise.bl.entities

data class Producto (
    private var id: Int? = null,
    private var usuario: String? = null,
    private var disponibilidad: String? = null,
    private var clasificacion: String? = null,
    private var nombre: String? = null,
    private var descripcion: String? = null,
    private var precio: Int? = null,
    private var imgRuta: String? = null
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
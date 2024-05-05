package com.dorysparadise.bl.entities

data class Usuario(
    private var id: Int? = null,
    private var rol: String? = null,
    private var nombre: String? = null,
    private var correo: String? = null,
    private var clave: String? = null,
    private var imgRuta: String? = null
) {
    fun setId(id: Int) {this.id = id}
    fun getId() = this.id
    fun setRol(rol: String) {this.rol = rol}
    fun getRol() = this.rol
    fun setNombre(nombre: String) {this.nombre = nombre}
    fun getNombre() = this.nombre
    fun setCorreo(corre: String) {this.correo = correo}
    fun getCorreo() = this.correo
    fun setClave(clave: String) {this.clave = clave}
    fun getClave() = this.clave
    fun setImgRuta(imgRuta: String) {this.imgRuta = imgRuta}
    fun getImgRuta() = this.imgRuta

}

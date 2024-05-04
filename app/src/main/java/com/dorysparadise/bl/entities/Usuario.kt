package com.dorysparadise.bl.entities

data class Usuario(
    private var id: Int,
    private var rol: String,
    private var correo: String,
    private var clave: String,
    private var imgRuta: String
) {
    fun setId(id: Int) {this.id = id}
    fun getId() = this.id
    fun setRol(rol: String) {this.rol = rol}
    fun getRol() = this.rol
    fun setCorreo(corre: String) {this.correo = correo}
    fun getCorreo() = this.correo
    fun setClave(clave: String) {this.clave = clave}
    fun getClave() = this.clave
    fun setImgRuta(imgRuta: String) {this.imgRuta = imgRuta}
    fun getImgRuta() = this.imgRuta

}

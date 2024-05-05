package com.dorysparadise.bl.entities

import java.time.LocalDateTime

data class Sugerencia(
    private var id: Int? = null,
    private var usuario: String? = null,
    private var situacion: String? = null,
    private var descripcion: String? = null,
    private var fechaPubli: LocalDateTime? = null
) {
    fun setId(id: Int) {this.id = id}
    fun getId() = this.id
    fun setUsuario(usuario: String) {this.usuario = usuario}
    fun getUsuario() = this.usuario
    fun setSituacion(situacion: String) {this.situacion = situacion}
    fun getSituacion() = this.situacion
    fun setDescripcion(descripcion: String) {this.descripcion = descripcion}
    fun getDescripcion() = this.descripcion
    fun setFechaPubli(fechaPubli: LocalDateTime) {this.fechaPubli = fechaPubli}
    fun getFechaPubli() = this.fechaPubli
}

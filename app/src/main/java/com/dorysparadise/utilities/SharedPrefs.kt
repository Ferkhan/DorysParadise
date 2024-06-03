package com.dorysparadise.utilities

import android.content.Context
import com.dorysparadise.bl.models.Usuario

// Guardar datos en la memoria del dispositivo (Shared Preferences)
class SharedPrefs(val contexto: Context) {
    private val SHARED_NAME = "BD_local"
    private val SHARED_USUARIO_ID = "usuario_id"
    private val SHARED_USUARIO_NOMBRE = "usuario_nombre"
    private val SHARED_USUARIO_ROL = "usuario_rol"
    private val SHARED_USUARIO_CORREO = "usuario_correo"
    private val SHARED_USUARIO_CLAVE = "usuario_clave"
    private val SHARED_USUARIO_IMG = "usuario_img"
    private val SHARED_USUARIO = "usuario"
    private val almacen = contexto.getSharedPreferences(SHARED_NAME, 0)

    fun setIdUsuario(id: Int) {
        almacen.edit().putInt(SHARED_USUARIO_ID, id).apply()
    }
    fun getIdUsuario(): Int = almacen.getInt(SHARED_USUARIO_ID, 0)

    fun setUsuario(usuario: Usuario) {
        almacen.edit().putInt(SHARED_USUARIO_ID, usuario.id).apply()
        almacen.edit().putString(SHARED_USUARIO_CORREO, usuario.correo).apply()
        almacen.edit().putString(SHARED_USUARIO_ROL, usuario.rol).apply()
        almacen.edit().putString(SHARED_USUARIO_NOMBRE, usuario.nombre).apply()
        almacen.edit().putString(SHARED_USUARIO_CLAVE, usuario.clave).apply()
        almacen.edit().putString(SHARED_USUARIO_IMG, usuario.imgRuta).apply()
    }

    fun getUsuario() : Usuario {
        return Usuario(
            almacen.getInt(SHARED_USUARIO_ID, 0),
            almacen.getString(SHARED_USUARIO_ROL, "")!!,
            almacen.getString(SHARED_USUARIO_NOMBRE, "")!!,
            almacen.getString(SHARED_USUARIO_CORREO, "")!!,
            almacen.getString(SHARED_USUARIO_CLAVE, "")!!,
            almacen.getString(SHARED_USUARIO_IMG, "")!!
        )
    }
}
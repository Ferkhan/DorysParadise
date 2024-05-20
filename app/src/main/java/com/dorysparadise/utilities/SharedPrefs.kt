package com.dorysparadise.utilities

import android.content.Context

// Guardar datos en la memoria del dispositivo (Shared Preferences)
class SharedPrefs(val contexto: Context) {
    val SHARED_NAME = "BD_local"
    val SHARED_ID_USUARIO = "id_usuario"
    val almacen = contexto.getSharedPreferences(SHARED_NAME, 0)

    fun setIdUsuario(id: Int) {
        almacen.edit().putInt(SHARED_ID_USUARIO, id).apply()
    }

    fun getIdUsuario(): Int = almacen.getInt(SHARED_ID_USUARIO, 0)
}
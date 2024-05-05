package com.dorysparadise.bl.repositories

import android.content.Context
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.dorysparadise.bl.entities.Usuario
import org.json.JSONException

class UsuarioRepo(contexto: Context) : GestorRepo(contexto) {

    fun obtenerPorId(id: String): Usuario {
        val usuario = Usuario()

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, "$url/usuario_leer_id.php?id=$id", null,
            { response ->
                try {
                    if (response.length() > 0){
                        usuario.setId(response.getInt("id"))
                        usuario.setRol(response.getString("rol"))
                        usuario.setNombre(response.getString("nombre"))
                        usuario.setCorreo(response.getString("correol"))
                        usuario.setClave(response.getString("clave"))
                        usuario.setImgRuta(response.getString("imgRuta"))
                    }
                } catch (error: JSONException) {
                    Toast.makeText(contexto, error.message, Toast.LENGTH_LONG).show()
                }
            },
            { error ->
                Toast.makeText(contexto, error.message, Toast.LENGTH_LONG).show()
            }
        )

        requestQueue.add(jsonObjectRequest)

        return usuario
    }
}
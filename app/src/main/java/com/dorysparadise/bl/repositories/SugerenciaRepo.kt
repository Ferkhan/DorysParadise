package com.dorysparadise.bl.repositories

import android.content.Context
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.dorysparadise.bl.entities.Sugerencia
import org.json.JSONException
import org.json.JSONObject
import java.time.LocalDateTime

class SugerenciaRepo(contexto: Context) : GestorRepo(contexto) {
    fun obtenerRegistros(): List<Sugerencia> {
        var sugerencia: Sugerencia
        val listaSugerencias = mutableListOf<Sugerencia>()
        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET, "$url/sugerencia_leer_todo.php", null,
            { response ->
                try {
                    var jsonObject: JSONObject
                    for (i in 0 until response.length()) {
                        jsonObject = response.getJSONObject(i)
                        sugerencia = Sugerencia()
                        sugerencia.setId(jsonObject.getInt("id"))
                        sugerencia.setUsuario(jsonObject.getString("usuario"))
                        sugerencia.setSituacion(jsonObject.getString("situacion"))
                        sugerencia.setDescripcion(jsonObject.getString("descripcion"))
                        sugerencia.setFechaPubli(LocalDateTime.parse(jsonObject.getString("fecha_publicacion")))
                        listaSugerencias.add(sugerencia)
                    }
                } catch (error: JSONException) {
                    Toast.makeText(contexto, error.message, Toast.LENGTH_LONG).show()
                }
            },
            { error ->
                Toast.makeText(contexto, error.message, Toast.LENGTH_LONG).show()
            }
        )

        requestQueue.add(jsonArrayRequest)

        return listaSugerencias
    }
}
package com.dorysparadise.bl.repositories

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.dorysparadise.bl.entities.Producto
import org.json.JSONException
import org.json.JSONObject

class ProductoRepo(contexto: Context) : GestorRepo(contexto) {
    private val listaProductos = mutableListOf<Producto>()

    fun obtenerRegistros() : List<Producto> {
        var producto: Producto
        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, "$url/producto_leer_todo.php", null,
            { response ->
                try {
                    var jsonObject: JSONObject
                    for (i in 0 until response.length()) {
                        jsonObject = response.getJSONObject(i)
                        producto = Producto()
                        producto.setId(jsonObject.getInt("id"))
                        producto.setUsuario(jsonObject.getString("usuario"))
                        producto.setDisponibilidad(jsonObject.getString("disponibilidad"))
                        producto.setClasificacion(jsonObject.getString("clasificacion"))
                        producto.setNombre(jsonObject.getString("nombre"))
                        producto.setDescripcion(jsonObject.getString("descripcion"))
                        producto.setPrecio(jsonObject.getInt("precio"))
                        producto.setImgRuta(jsonObject.getString("img_ruta"))
                        listaProductos.add(producto)
                    }
                } catch (error: JSONException) {
                    Toast.makeText(contexto, error.message, Toast.LENGTH_LONG).show()
                    //TODO: log
                    Log.e("DoryError", error.message.toString())

                }
            },
            { error ->
                Toast.makeText(contexto, error.message, Toast.LENGTH_LONG).show()
                Log.e("DoryError", error.message.toString())
            }
        )
        //TODO: log
        if (listaProductos.isEmpty()) Log.e("DoryError", "repo lista vacía")

        requestQueue.add(jsonArrayRequest)

        return listaProductos.toList()
    }
}
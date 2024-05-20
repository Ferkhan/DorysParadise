//package com.dorysparadise.bl.repositories
//
//import android.content.Context
//import android.widget.Toast
//import com.android.volley.Request
//import com.android.volley.toolbox.JsonArrayRequest
//import com.dorysparadise.bl.models.Transaccion
//import org.json.JSONException
//import org.json.JSONObject
//import java.time.LocalDateTime
//
//class TransaccionRepo(contexto: Context) : GestorRepo(contexto) {
//    fun obtenerRegistros(): List<Transaccion> {
//        var transaccion: Transaccion
//        val listaTransacciones = mutableListOf<Transaccion>()
//        val jsonArrayRequest = JsonArrayRequest(
//            Request.Method.GET, "$url/transaccion_leer_todo.php", null,
//            { response ->
//                try {
//                    var jsonObject: JSONObject
//                    for (i in 0 until response.length()) {
//                        jsonObject = response.getJSONObject(i)
//                        transaccion = Transaccion()
//                        transaccion.setId(jsonObject.getInt("id"))
//                        transaccion.setUsuario(jsonObject.getString("usuario"))
//                        transaccion.setOperacion(jsonObject.getString("operacion"))
//                        transaccion.setPrecio(jsonObject.getInt("precio"))
//                        transaccion.setMotivo(jsonObject.getString("operacion"))
//                        transaccion.setFechaOperacion(LocalDateTime.parse(jsonObject.getString("fecha_operacion")))
//                        listaTransacciones.add(transaccion)
//                    }
//                } catch (error: JSONException) {
//                    Toast.makeText(contexto, error.message, Toast.LENGTH_LONG).show()
//                }
//            },
//            { error ->
//                Toast.makeText(contexto, error.message, Toast.LENGTH_LONG).show()
//            }
//        )
//
//        requestQueue.add(jsonArrayRequest)
//
//        return listaTransacciones
//    }
//}
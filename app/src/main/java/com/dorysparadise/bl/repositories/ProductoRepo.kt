//package com.dorysparadise.bl.repositories
//
//import android.content.Context
//import android.util.Log
//import android.widget.Toast
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import com.android.volley.Request
//import com.android.volley.toolbox.JsonArrayRequest
//import com.android.volley.toolbox.Volley
//import com.dorysparadise.bl.models.Producto
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.coroutineScope
//import kotlinx.coroutines.withContext
//import org.json.JSONException
//
//class ProductoRepo(contexto: Context) : GestorRepo(contexto) {
//    private val listaLiveProductos = MutableLiveData<List<Producto>>()
//    private val listaProductos = mutableListOf<Producto>()
//    suspend fun obtenerRegistros() : LiveData<List<Producto>> {
//        coroutineScope {
//            val jsonArrayRequest =
//                JsonArrayRequest(Request.Method.GET, "$url/producto_leer_todo.php", null,
//                    { response ->
//                        try {
//                            for (i in 0 until response.length()) {
//                                val jsonObject = response.getJSONObject(i)
//                                val producto = Producto(
//                                    id = jsonObject.getInt("id"),
//                                    usuario = jsonObject.getString("usuario"),
//                                    disponibilidad = jsonObject.getString("disponibilidad"),
//                                    clasificacion = jsonObject.getString("clasificacion"),
//                                    nombre = jsonObject.getString("nombre"),
//                                    descripcion = jsonObject.getString("descripcion"),
//                                    precio = jsonObject.getInt("precio"),
//                                    imgRuta = jsonObject.getString("img_ruta")
//                                )
//                                listaProductos.add(producto)
//                                Log.e("DoryError", producto.getNombre().toString())
//                            }
//                        } catch (error: JSONException) {
//                            Toast.makeText(contexto, error.message, Toast.LENGTH_LONG).show()
//                            //TODO: log
//                            Log.e("DoryError", error.message.toString())
//                        }
//                    },
//                    { error ->
//                        Toast.makeText(contexto, error.message, Toast.LENGTH_LONG).show()
//                        Log.e("DoryError", error.message.toString())
//                    }
//                )
//
//            if (listaProductos.isEmpty()) {
//                Log.e("DoryError", "productos vacios")
//            }
//            Log.e("DoryError", "antes de requestQueue")
//            requestQueue = Volley.newRequestQueue(contexto)
//            requestQueue.add(jsonArrayRequest)
//            Log.e("DoryError", "despues de requestQueue")
////            Thread.sleep(15000)
//            listaLiveProductos.postValue(listaProductos)
//            Log.e("DoryError", "despues de listaLiveProductos")
//
//        }
//        Log.e("DoryError", "antes del return")
//        return listaLiveProductos
//
//    }
//
//    suspend fun obtenerRegistros2() : List<Producto> {
//
//        return withContext(Dispatchers.IO) {
//            respuesta = false
//            var foobar: Boolean
//            val listaProductos = mutableListOf<Producto>()
//            val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, "$url/producto_leer_todo.php", null,
//                { response ->
//                    try {
//                        for (i in 0 until response.length()) {
//                            val jsonObject = response.getJSONObject(i)
//                            val producto = Producto(
//                                id = jsonObject.getInt("id"),
//                                usuario = jsonObject.getString("usuario"),
//                                disponibilidad = jsonObject.getString("disponibilidad"),
//                                clasificacion = jsonObject.getString("clasificacion"),
//                                nombre = jsonObject.getString("nombre"),
//                                descripcion = jsonObject.getString("descripcion"),
//                                precio = jsonObject.getInt("precio"),
//                                imgRuta = jsonObject.getString("img_ruta")
//                            )
//                             listaProductos.add(producto)
//                            Log.e("DoryError", producto.getNombre().toString())
//                            foobar = true
//                        }
//                        respuesta = true
//                    } catch (error: JSONException) {
////                        Toast.makeText(contexto, error.message, Toast.LENGTH_LONG).show()
//
//                        //TODO: log
//                        Log.e("DoryError", error.message.toString())
//                        respuesta = true
//                    }
//                },
//                { error ->
////                    Toast.makeText(contexto, error.message, Toast.LENGTH_LONG).show()
//                    Log.e("DoryError", "Error de no response: ${error.message.toString()}")
//                    respuesta = true
//                }
//            )
//
//            requestQueue = Volley.newRequestQueue(contexto)
//            requestQueue.add(jsonArrayRequest)
//
//            while (!respuesta) {}
//
//            listaProductos.toList()
//
//        }
//    }
//
//    fun obtenerRegistros3() {
//        respuesta = false
//        val jsonSuccess = JsonArrayRequest(Request.Method.GET, "$url/producto_leer_todo.php", null,
//            { response ->
//                try {
//                    for (i in 0 until response.length()) {
//                        val jsonObject = response.getJSONObject(i)
//                        val producto = Producto(
//                            id = jsonObject.getInt("id"),
//                            usuario = jsonObject.getString("usuario"),
//                            disponibilidad = jsonObject.getString("disponibilidad"),
//                            clasificacion = jsonObject.getString("clasificacion"),
//                            nombre = jsonObject.getString("nombre"),
//                            descripcion = jsonObject.getString("descripcion"),
//                            precio = jsonObject.getInt("precio"),
//                            imgRuta = jsonObject.getString("img_ruta")
//                        )
//                        listaProductos.add(producto)
//                        respuesta = true
//                        Log.e("DoryError", producto.getNombre().toString())
//                    }
//                } catch (error: JSONException) {
//                    //Toast.makeText(contexto, error.message, Toast.LENGTH_LONG).show()
//                    //TODO: log
//                    Log.e("DoryError", error.message.toString())
//                    respuesta = true
//                }
//            },
//            { error ->
//                //Toast.makeText(contexto, error.message, Toast.LENGTH_LONG).show()
//                Log.e("DoryError", error.message.toString())
//                respuesta = true
//            }
//        )
//
//
//        //stop
//
//        //return seguro
//    }
//
//    fun getListaProductos() = listaProductos
//
//
//}
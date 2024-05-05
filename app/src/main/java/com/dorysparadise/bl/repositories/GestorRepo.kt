package com.dorysparadise.bl.repositories

import android.content.Context
import com.android.volley.toolbox.Volley
import java.time.format.DateTimeFormatter


abstract class GestorRepo (protected val contexto: Context) {
    protected val url: String = "https://dorysparadise.000webhostapp.com/data_access"
    protected var requestQueue = Volley.newRequestQueue(contexto)
    protected val formato = DateTimeFormatter.ISO_LOCAL_DATE_TIME
    protected val msjErrorConn: String = "Error de conexión"

}
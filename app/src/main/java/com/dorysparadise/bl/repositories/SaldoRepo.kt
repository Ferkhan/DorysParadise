package com.dorysparadise.bl.repositories

import android.content.Context
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.dorysparadise.bl.entities.Saldo
import org.json.JSONException

class SaldoRepo(contexto: Context) : GestorRepo(contexto) {
    fun obtenerPorId(id: Int): Saldo {
        val saldo = Saldo()

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, "$url/saldo_leer_id.php?id=$id", null,
            { response ->
                try {
                    if (response.length() > 0){
                        saldo.setId(response.getInt("id"))
                        saldo.setCantidad(response.getInt("cantidad"))
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

        return saldo
    }
}
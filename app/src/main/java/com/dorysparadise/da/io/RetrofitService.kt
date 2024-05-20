package com.dorysparadise.da.io

import com.dorysparadise.bl.models.Producto
import com.dorysparadise.bl.models.Saldo
import com.dorysparadise.bl.models.Transaccion
import com.dorysparadise.bl.models.Usuario
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("producto_leer_todo.php")
    suspend fun productoLista(): List<Producto>

    @GET("sugerencia_leer_todo.php")
    suspend fun sugerenciaLista(): List<Saldo>

    @GET("usuario_leer_id.php")
    suspend fun usuarioPorId(
        @Query("id") id: Int
    ): Usuario

    @GET("saldo_leer_id.php")
    suspend fun saldoPorId(
        @Query("id") id: Int
    ): Saldo

    @GET("transaccion_leer_id.php")
    suspend fun transaccionPorId(
        @Query("id") id: Int
    ): Transaccion

}
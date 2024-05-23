package com.dorysparadise.da.io

import com.dorysparadise.bl.models.Politica
import com.dorysparadise.bl.models.Producto
import com.dorysparadise.bl.models.Saldo
import com.dorysparadise.bl.models.Sugerencia
import com.dorysparadise.bl.models.Transaccion
import com.dorysparadise.bl.models.Usuario
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RetrofitService {

    @GET("producto_leer_todo.php")
    suspend fun getProductoLista(): Response<List<Producto>>

    @GET("sugerencia_leer_todo.php")
    suspend fun getSugerenciaLista(): Response<List<Sugerencia>>

    @GET("politica_leer_todo.php")
    suspend fun getPoliticaLista(): Response<List<Politica>>

    @GET("usuario_leer_id.php")
    suspend fun getUsuarioPorId(
        @Query("id") id: Response<Int>
    ): Usuario

    @GET("saldo_leer_id.php")
    suspend fun getSaldoPorId(
        @Query("id") id: Response<Int>
    ): Saldo

    @GET("transaccion_leer_id.php")
    suspend fun getTransaccionPorId(
        @Query("id") id: Response<Int>
    ): Transaccion


}
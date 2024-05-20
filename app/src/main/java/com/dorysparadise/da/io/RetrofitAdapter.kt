package com.dorysparadise.da.io

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitAdapter {
    private const val URL = "https://dorysparadise.000webhostapp.com/data_access/"

    fun getRetrofit(): RetrofitService {
        return Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitService::class.java)
    }
}
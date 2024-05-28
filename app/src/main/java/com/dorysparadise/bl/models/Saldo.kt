package com.dorysparadise.bl.models

import com.google.gson.annotations.SerializedName

data class Saldo(
    @SerializedName("saldo_id")
    val id: Int,
    val cantidad: Int
)

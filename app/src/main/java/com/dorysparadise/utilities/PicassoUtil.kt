package com.dorysparadise.utilities

import com.squareup.picasso.Picasso

class PicassoUtil {
    private val url = "https://dorysparadise.000webhostapp.com/imagenes"

    fun getImg(imgNombre: String) = Picasso.get().load(url + imgNombre)
}
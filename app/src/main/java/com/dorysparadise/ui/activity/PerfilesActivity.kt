package com.dorysparadise.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.widget.TextView
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import com.dorysparadise.R
import com.dorysparadise.bl.repositories.ProductoRepo
import com.dorysparadise.bl.repositories.UsuarioRepo

class PerfilesActivity : AppCompatActivity() {
    private lateinit var texto: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfiles)

        inicarRecursos()
        val usuarioRepo = UsuarioRepo(this)
        val productoRepo = ProductoRepo(this)
        var msg1: String?
        var msg2: String?
        if (productoRepo.obtenerRegistros().count() > 0) {
            msg2 = productoRepo.obtenerRegistros()[0].getNombre()
            msg1 = usuarioRepo.obtenerPorId(1).getNombre()
        } else {
            msg2 = "lista vacia"
        }
        texto.text = msg2
        Log.e("DoryError", msg2 ?: "no hay mensaje")
    }

    private fun inicarRecursos() {
        texto = findViewById(R.id.txt_titulo)
    }
    

}
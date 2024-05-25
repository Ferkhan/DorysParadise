package com.dorysparadise.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dorysparadise.bl.models.Usuario
import com.dorysparadise.da.io.RetrofitAdapter
import com.dorysparadise.da.io.RetrofitService
import com.dorysparadise.databinding.ActivityInicioSesionBinding
import com.dorysparadise.utilities.PicassoUtil
import com.dorysparadise.utilities.UtilityApplication.Companion.sharedPrefs
import java.math.BigInteger
import java.security.MessageDigest

class InicioSesionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInicioSesionBinding
    private lateinit var retrofitService: RetrofitService
    private lateinit var usuario: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicioSesionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecursos()
        initListeners()
        setValores()
    }

    private fun initRecursos() {
        retrofitService = RetrofitAdapter.getRetrofit()
        usuario = sharedPrefs.getUsuario()
    }

    private fun initListeners() {
        binding.btnIngresar.setOnClickListener { irBarraNavegacion() }
    }

    private fun setValores() {
        binding.txtNombreUsuario.text = usuario.nombre
        PicassoUtil().getImg(usuario.imgRuta).into(binding.imgUsuario)
    }

    private fun irBarraNavegacion() {
        val miIntent = Intent(this, BarraNavActivity::class.java)

        if (compararClave(binding.edtxtClaveInput.text.toString())) {
            Toast.makeText(this, "Welcome, ${usuario.nombre}", Toast.LENGTH_SHORT).show()
            startActivity(miIntent)
        } else {
            Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
        }

    }

    /*
    Compara la clave ingresada con la clave almacenada del usuario para determinar
    si se ha ingresado la clave correcta
    */
    private fun compararClave(claveInput: String) : Boolean {
        val md = MessageDigest.getInstance("MD5")
        val claveMD5 = BigInteger(1, md.digest(claveInput.toByteArray())).toString(16).padStart(32, '0')
        return usuario.clave == claveMD5
    }
}
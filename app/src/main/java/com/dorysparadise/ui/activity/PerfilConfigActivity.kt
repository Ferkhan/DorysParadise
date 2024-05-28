package com.dorysparadise.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dorysparadise.bl.models.Usuario
import com.dorysparadise.databinding.ActivityPerfilConfigBinding
import com.dorysparadise.utilities.UtilityApplication.Companion.sharedPrefs
import java.math.BigInteger
import java.security.MessageDigest

class PerfilConfigActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPerfilConfigBinding
    private lateinit var usuario: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilConfigBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
        initRecursos()
        setValores()
    }

    private fun initRecursos() {
        usuario = sharedPrefs.getUsuario()
    }

    private fun setValores() {
        binding.editNombre.setText(usuario.nombre)
        binding.editCorreo.setText(usuario.correo)
    }


    private fun initListeners() {
        binding.btnCancelar.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
        binding.btnGuardar.setOnClickListener { actualizarDatos() }
    }

    private fun compararClave() : Boolean {
        return binding.editClaveNueva.text.toString() == binding.editClaveConfirm.text.toString()
    }

    private fun getMD5(claveInput: String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(claveInput.toByteArray())).toString(16).padStart(32, '0')
    }

    private fun toast(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }

    private fun actualizarDatos() {

        if (binding.editNombre.text.toString().trim().isEmpty()) {
            toast("Campo nombre está vacío")
            return
        }

        if (binding.editCorreo.text.toString().trim().isEmpty()) {
            toast("Campo correo está vacío")
            return
        }

        if (binding.editClaveNueva.text.toString().trim().isEmpty()) {
            toast("Campo contraseña está vacío")
            return
        }

        if (binding.editClaveConfirm.text.toString().trim().isEmpty()) {
            toast("Campo confirmar contraseña está vacío")
            return
        }

        if (!compararClave()) {
            toast("Las contraseñas no coinciden")
            return
        }

        val claveNueva = getMD5(binding.editClaveNueva.text.toString())
        toast("Cambios guardados con éxito: $claveNueva")
        onBackPressedDispatcher.onBackPressed()
    }
}
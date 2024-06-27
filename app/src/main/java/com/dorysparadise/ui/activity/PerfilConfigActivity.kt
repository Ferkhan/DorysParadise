package com.dorysparadise.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.dorysparadise.bl.models.RespuestaRetrofit
import com.dorysparadise.bl.models.Usuario
import com.dorysparadise.da.io.RetrofitAdapter
import com.dorysparadise.da.io.RetrofitService
import com.dorysparadise.databinding.ActivityPerfilConfigBinding
import com.dorysparadise.utilities.UtilityApplication.Companion.sharedPrefs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.math.BigInteger
import java.security.MessageDigest
import kotlin.coroutines.cancellation.CancellationException

class PerfilConfigActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPerfilConfigBinding
    private lateinit var usuario: Usuario
    private lateinit var respuestaRetrofit: Response<RespuestaRetrofit>

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
        binding.btnGuardar.setOnClickListener {
            toast("Opción no disponible por el momento")
//            actualizarDatos()
        }
    }

    private fun compararClave(): Boolean {
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
        if (!comprobarCampos()) return

        val claveNueva: String = if (binding.editClaveNueva.text.isEmpty())
            sharedPrefs.getUsuario().clave
        else
            getMD5(binding.editClaveNueva.text.toString())

        val id = usuario.id
        val rol = usuario.rol
        val nombre = binding.editNombre.text.toString()
        val correo = binding.editCorreo.text.toString()
        val img = usuario.imgRuta

        lifecycleScope.launch(Dispatchers.Main) {
            try {
                Log.d("DorysCancel", "entra al lifescope")
                respuestaRetrofit = withContext(Dispatchers.IO) {
                    RetrofitAdapter.getRetrofit().updateUsuarioPorId(
                        id,
                        nombre,
                        correo,
                        claveNueva
                    )
                }
                Log.d("DorysCancel", "entre with y el if")
                if (respuestaRetrofit.isSuccessful) {
                    toast(respuestaRetrofit.body()!!.mensaje)
                    sharedPrefs.setUsuario(
                        Usuario(
                            id,
                            rol,
                            nombre,
                            correo,
                            claveNueva,
                            img
                        )
                    )
                    Log.d("DorysCancel", "luego del share")
                } else {
                    toast("Error en la actualización de datos. Intente más tarde")
                }
            } catch (e: Exception) {
                Log.d("DorysCancel", e.toString())
            }
        }

//         onBackPressedDispatcher.onBackPressed()
    }

    private fun comprobarCampos(): Boolean {
        if (binding.editNombre.text.toString().trim().isEmpty()) {
            toast("Campo nombre está vacío")
            return false
        }

        if (binding.editCorreo.text.toString().trim().isEmpty()) {
            toast("Campo correo está vacío")
            return false
        }

        if (binding.editClaveNueva.text.isNotEmpty() || binding.editClaveConfirm.text.isNotEmpty()) {
            if (binding.editClaveNueva.text.toString().trim().isEmpty()) {
                toast("Campo contraseña está vacío")
                return false
            }

            if (binding.editClaveConfirm.text.toString().trim().isEmpty()) {
                toast("Campo confirmar contraseña está vacío")
                return false
            }
        }

        if (!compararClave()) {
            toast("Las contraseñas no coinciden")
            return false
        }

        return true
    }
}

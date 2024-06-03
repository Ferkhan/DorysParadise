package com.dorysparadise.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.dorysparadise.bl.models.RespuestaRetrofit
import com.dorysparadise.bl.models.Saldo
import com.dorysparadise.bl.models.Usuario
import com.dorysparadise.da.io.RetrofitAdapter
import com.dorysparadise.databinding.FragmentSaldoBinding
import com.dorysparadise.utilities.UtilityApplication.Companion.sharedPrefs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response


class SaldoFragment : Fragment() {
    private lateinit var binding: FragmentSaldoBinding
    private lateinit var respuestaSaldo: Response<Saldo>
    private lateinit var respuestaRetrofit: Response<RespuestaRetrofit>
    private lateinit var saldo: Saldo
    private val usuario: Usuario = sharedPrefs.getUsuario()
    private var autorizador: Boolean = false
    private val sumar = 1
    private val restar = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSaldoBinding.inflate(inflater, container, false)

        setValores()
        initListeners()

        return binding.root

    }

    private fun initListeners() {
        binding.btnSumar.setOnClickListener { cambiarCantidad(sumar) }
        binding.btnRestar.setOnClickListener { cambiarCantidad(restar) }
    }

    private fun cambiarCantidad(cantidad: Int) {
        if (usuario.rol != "admin") return

        if (!autorizador) return

        lifecycleScope.launch(Dispatchers.Main) {
            autorizador = false
            respuestaRetrofit = withContext(Dispatchers.IO) { RetrofitAdapter.getRetrofit().updateSaldoPorId(saldo.id, saldo.cantidad + cantidad) }

            if (respuestaRetrofit.isSuccessful) {
                actualizarCantidad()
            } else {
                toast(respuestaRetrofit.body()!!.mensaje)
            }
            autorizador = true
        }
    }

    private fun setValores() {
        cambiarAviso("Cargando su saldo actual...")
        actualizarCantidad()
        ocultarBotones()

    }

    private fun cambiarAviso(mensaje: String) {
        binding.txtSaldo.text = mensaje
    }

    private fun toast(mensaje: String) {
        Toast.makeText(requireContext(), mensaje, Toast.LENGTH_SHORT).show()
    }

    private fun actualizarCantidad() {
        lifecycleScope.launch(Dispatchers.Main) {
            respuestaSaldo = withContext(Dispatchers.IO) { RetrofitAdapter.getRetrofit().getSaldoPorId(2) }

            if (respuestaSaldo.isSuccessful) {
                saldo = respuestaSaldo.body()!!
                cambiarAviso("$${saldo.cantidad} dorydólares")
                autorizador = true
            } else
                cambiarAviso("Error de conexión. Vuelva a intentarlo")
        }
    }

    private fun ocultarBotones() {
        if (usuario.rol == "admin") return

        binding.btnSumar.visibility = View.GONE
        binding.btnRestar.visibility = View.GONE
    }
}
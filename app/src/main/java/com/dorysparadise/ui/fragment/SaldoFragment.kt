package com.dorysparadise.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.dorysparadise.bl.models.Saldo
import com.dorysparadise.da.io.RetrofitAdapter
import com.dorysparadise.databinding.FragmentSaldoBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response


class SaldoFragment : Fragment() {
    private lateinit var binding: FragmentSaldoBinding
    private lateinit var respuesta: Response<Saldo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSaldoBinding.inflate(inflater, container, false)

        setValores()

        return binding.root
    }

    private fun setValores() {
        cambiarAviso("Cargando productos...")

        lifecycleScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) { respuesta = RetrofitAdapter.getRetrofit().getSaldoPorId(2) }

            if (respuesta.isSuccessful)
                cambiarAviso("$${respuesta.body()!!.cantidad} dorydólares")
            else
                cambiarAviso("Error de conexión. Vuelva a intentarlo")
        }
    }

    private fun cambiarAviso(mensaje: String) {
        binding.txtSaldo.text = mensaje
    }
}
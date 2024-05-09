package com.jes.wikiworld

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jes.wikiworld.R
import com.jes.wikiworld.Singleton
import com.jes.wikiworld.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

        // Deshabilitar el botón de inicio de sesión hasta que se introduzca un nombre válido
        binding.boton.isEnabled = false




// Listener para el botón de inicio de sesión
        binding.boton.setOnClickListener {
            Log.d("LoginFragment", "Botón clicado") // Agrega esta línea para depurar
            val userName = binding.nombre.text.toString().trim()
            if (userName.isNotEmpty()) {
                Singleton.setUserName(userName)
                findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
            }
            Toast.makeText(
                requireActivity(),
                "Bienvenido, nos alegra verte de nuevo !!",
                Toast.LENGTH_LONG
            ).show()


        }




//


        // Listener para el campo de nombre
        binding.nombre.addTextChangedListener {
            binding.boton.isEnabled = it.toString().trim().isNotEmpty() // Habilitar el botón si el nombre no está vacío
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
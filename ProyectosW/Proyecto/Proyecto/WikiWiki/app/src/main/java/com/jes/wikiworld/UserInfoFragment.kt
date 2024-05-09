package com.jes.wikiworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.jes.wikiworld.databinding.FragmentUserInfoBinding

class UserInfoFragment : Fragment() {


    private var _binding: FragmentUserInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Habilitar el botón de retroceso en la barra de herramientas
        val actionBar = (requireActivity() as AppCompatActivity).supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        // Obtener el nombre de usuario del Singleton y establecerlo en la vista
        val userName = Singleton.getUserName()
        binding.username.text = userName

        // Establecer el email (puedes agregar más lógica aquí para obtener más información del usuario)
        binding.email.text = "usuario@example.com"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
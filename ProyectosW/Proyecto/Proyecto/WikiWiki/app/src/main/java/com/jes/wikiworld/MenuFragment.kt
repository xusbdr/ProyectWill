package com.jes.wikiworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jes.wikiworld.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        val view = binding.root

        // Recuperar el nombre de usuario del Bundle
        val username = arguments?.getString("username")

        // Mostrar el nombre de usuario en el TextView
        binding.btnSalirMenu.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_creditFragment)
        }

        binding.btnVolverLogin.setOnClickListener {
            findNavController().popBackStack(R.id.loginFragment, false)
        }

        binding.comentarios.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_detailFavItemFragment)
        }




        return view
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


package com.jes.wikiworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.jes.wikiworld.databinding.FragmentDetailItemBinding
class DetailItemFragment : Fragment() {

    private var _binding: FragmentDetailItemBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: ElviewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val selectedItem = arguments?.getSerializable("selectedItem") as? Item2
        val additionalInfo = arguments?.getString("additionalInfo")

        if (selectedItem != null) {
            // Mostrar la información del elemento seleccionado en el diseño
            binding.nameTextView.text = selectedItem.nombre
            binding.descriptionTextView.text = selectedItem.description

            // Mostrar la información adicional
            binding.additionalInfoTextView.text = additionalInfo
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
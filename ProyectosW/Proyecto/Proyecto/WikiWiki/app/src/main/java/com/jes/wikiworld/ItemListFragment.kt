package com.jes.wikiworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jes.wikiworld.databinding.FragmentItemListBinding

class ItemListFragment : Fragment() {

    private val favoritos = mutableListOf<Item2>()
    private lateinit var binding: FragmentItemListBinding
    private lateinit var adapter: ItemAdapter2
    private lateinit var recyclerView: RecyclerView

    private val sharedViewModel: ElviewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemListBinding.inflate(inflater, container, false)
        recyclerView = binding.recycler
        adapter = ItemAdapter2(favoritos)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        // Habilitar el botón de retroceso en la barra de herramientas
        val actionBar = (requireActivity() as AppCompatActivity).supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        // Configurar el botón para añadir contenido a favoritos
        val addContentButton: Button = binding.Favoritos
        addContentButton.setOnClickListener {
            val selectedItems = adapter.getSelectedItems().toList()
            sharedViewModel.setSelectedItems(selectedItems)

            val action = ItemListFragmentDirections.actionItemListFragmentToFavItemListFragment()
            findNavController().navigate(action)
        }

        // Si la lista favoritos está vacía, entonces la llenamos con los elementos de muestra
        if (favoritos.isEmpty()) {
            favoritos.addAll(getSampleItems())
            adapter.notifyDataSetChanged()
        }

        return binding.root
    }

    private fun getSampleItems(): List<Item2> {
        return listOf(
            Item2(1, "Descubre las montañas", "Alpinismo"),
            Item2(2, "Las mejores pistas", "Running"),
            Item2(3, "Rutas en familia", "Senderismo"),
            Item2(4, "Las mejores playas", "Surf"),
            Item2(5, "MTB o carretera", "Ciclismo")
        )
    }
}
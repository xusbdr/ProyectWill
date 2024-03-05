package com.jes.wikiworld

import ItemAdapter2
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jes.wikiworld.Item2
import com.jes.wikiworld.R

class ItemListFragment : Fragment() {

    private val favoriteItems = mutableListOf<Item2>()
    private lateinit var adapter: ItemAdapter2
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        recyclerView = view.findViewById(R.id.favItemListFragment)
        adapter = ItemAdapter2(favoriteItems)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        favoriteItems.addAll(getSampleItems())

        // Configurar el botón de retroceso
        val backButton: Button = view.findViewById(R.id.AñadirContenido)
        backButton.setOnClickListener {
            requireActivity().onBackPressed()
        }

        // Configurar el botón para añadir contenido
        val addContentButton: Button = view.findViewById(R.id.AñadirContenido)
        addContentButton.setOnClickListener {
            // Navegar a otro fragmento (reemplaza R.id.destinationFragment con el ID del fragmento al que deseas navegar)
            findNavController().navigate(R.id.action_itemListFragment_to_destinationFragment)
        }

        return view
    }

    private fun getSampleItems(): List<Item2> {
        return listOf(
            Item2("Alpinismo", "Descripción del favorito 1", "Rutas Varias 1"),
            Item2("Running", "Descripción del favorito 2", "Apuntarse a grupos 2"),
            Item2("Senderismo", "Descripción del favorito 3", "En marcha 3")
        )
    }
}


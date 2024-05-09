package com.jes.wikiworld

import ItemAdapter
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
import com.jes.wikiworld.databinding.FragmentFavItemListBinding


class FavItemListFragment : Fragment() {
    private val favoritos = mutableListOf<Item2>()
    private lateinit var adapter: ItemAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var backButton: Button

    private val sharedViewModel: ElviewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFavItemListBinding.inflate(inflater, container, false)
        recyclerView = binding.favoritos
        adapter = ItemAdapter(favoritos)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        // Observar los elementos seleccionados desde el ViewModel
        sharedViewModel.selectedItems.observe(viewLifecycleOwner) { items ->
            addToFavorites(items)
        }

        // Habilitar el botón de retroceso en la barra de herramientas
        val actionBar = (requireActivity() as AppCompatActivity).supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        // Inicializar el botón para volver atrás
        backButton = binding.btnVolverAtras
        backButton.setOnClickListener {
            // Borrar la selección en el adaptador antes de retroceder
            adapter.clearSelection()
            // Retroceder a la pantalla anterior
            findNavController().popBackStack()
        }

        // Agregar listener al botón para volver al MainFragment
        val mainButton: Button = binding.btnVolverAtras
        mainButton.setOnClickListener {
            val selectedItems = adapter.getSelectedItems().toList()

            // Crear un Bundle para pasar información al DetailFragment
            val bundle = Bundle()

            // Obtener el elemento seleccionado
            val selectedItem = adapter.getSelectedItems().firstOrNull()

            if (selectedItem != null) {
                // Obtener la información adicional del Singleton
                val additionalInfo = Singleton.AdditionalInfoProvider.getAdditionalInfo(selectedItem.nombre)

                // Agregar la información adicional al Bundle
                bundle.putSerializable("selectedItem", selectedItem)
                bundle.putString("additionalInfo", additionalInfo)

                // Navegar al DetailItemFragment con el Bundle
                findNavController().navigate(R.id.action_favItemListFragment_to_detailItemFragment, bundle)
            }
        }

        adapter.setOnDeleteClickListener { item ->
            favoritos.remove(item)
            adapter.notifyDataSetChanged()
        }
        return binding.root
    }

    private fun addToFavorites(items: List<Item2>) {
        favoritos.clear() // Limpiar la lista antes de agregar nuevos elementos
        favoritos.addAll(items)
        adapter.notifyDataSetChanged()
    }

    private fun getSampleItems(): List<Item2> {
        return listOf()
    }
}
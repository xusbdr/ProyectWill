package com.jes.wikiworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.jes.wikiworld.databinding.FragmentDetailFavItemBinding



class DetailFavItemFragment : Fragment() {

    private var _binding: FragmentDetailFavItemBinding? = null
    private val binding get() = _binding!!

    private lateinit var comentariosAdapter: ComentariosAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailFavItemBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        comentariosAdapter = ComentariosAdapter(mutableListOf())

        binding.commentsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = comentariosAdapter
        }


        //


        binding.addCommentButton.setOnClickListener {
            val author = binding.ruta.text.toString()

            if (author.isNotEmpty()) { // Verifica si el campo de autor no está vacío
                val newComment = Comment(author, "") // Crear un nuevo comentario con autor pero sin contenido
                addComment(newComment)

                binding.ruta.text.clear()
            } else {
                Toast.makeText(requireContext(), "Por favor, completa el campo.No puede estar vacio", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun addComment(comment: Comment) {
        comentariosAdapter.addComment(comment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
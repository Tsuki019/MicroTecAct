package com.prvt.microtecact.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.prvt.microtecact.R
import com.prvt.microtecact.databinding.FragmentHomeBinding

/**
 * Fragment inicial de la aplicacion, donde se encuentra la imagen de presentacion y el boton para
 * mostrar la informacion de la llamada de los datos
 */

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() =_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding= FragmentHomeBinding.inflate(inflater, container, false)

        //Configuracion del boton de navegacion
        binding.button.setOnClickListener{
            findNavController().navigate(R.id.informationListFragment)
        }

        return binding.root
    }

}
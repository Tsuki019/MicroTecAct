package com.prvt.microtecact.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.prvt.microtecact.R
import com.prvt.microtecact.databinding.FragmentHomeBinding
import com.prvt.microtecact.databinding.FragmentInformationListBinding

/**
 * Fragment de la vista en donde se muestra la informacion obtenida desde la Api
 */

class InformationListFragment : Fragment() {

    private var _binding: FragmentInformationListBinding? = null

    private val binding get() =_binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding= FragmentInformationListBinding.inflate(inflater, container, false)

        binding.backNavButton.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }
}
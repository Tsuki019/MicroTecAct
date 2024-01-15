package com.prvt.microtecact.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.prvt.microtecact.databinding.FragmentInformationListBinding
import com.prvt.microtecact.ui.viewmodel.InformationListViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Fragment de la vista en donde se muestra la informacion obtenida desde la Api
 */

class InformationListFragment : Fragment() {

    private var _binding: FragmentInformationListBinding? = null

    private val binding get() =_binding!!

    private val infoPokeViewModel : InformationListViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        infoPokeViewModel.loadInfoPoke()
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

//        lifecycleScope.launch {
//            delay(2000)
//        }
        lifecycleScope.launch {
            infoPokeViewModel.isLoading.collectLatest {
                if (!it){
                    binding.text1.apply {
                        text = if(infoPokeViewModel.loadError.value != ""){
                            infoPokeViewModel.loadError.value
                        }else{

                            //Coloca la informacion al TextView de la segunda vista
                            infoPokeViewModel.infoPokemon.value!!.toString()
                        }
                    }
                }
            }
        }
        return binding.root
    }
}
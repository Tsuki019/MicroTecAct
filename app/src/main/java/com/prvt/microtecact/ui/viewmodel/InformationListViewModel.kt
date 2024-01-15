package com.prvt.microtecact.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prvt.microtecact.data.models.Pokemon
import com.prvt.microtecact.domain.usecases.GetPokemonInfoUseCase
import com.prvt.microtecact.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel para el almacenamiento y la entrega de la informacion para el fragmento [InformationListFragment]
 */

@HiltViewModel
class InformationListViewModel @Inject constructor(
    private val infoUseCase: GetPokemonInfoUseCase
) : ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    private val _infoPokemon = MutableStateFlow<Pokemon?>(null)
    val infoPokemon = _infoPokemon.asStateFlow()

    private val _loadError = MutableStateFlow("")
    val loadError = _loadError.asStateFlow()

    fun loadInfoPoke(){
        if (_infoPokemon.value == null){
            viewModelScope.launch {
                when(val result = infoUseCase.getPokemonInfo()){
                    is Resource.Success -> {
                        _infoPokemon.value = result.data
                    }
                    is Resource.Error -> {
                        println(result.data)
                        _loadError.value = result.message!!
                    }
                }
                _isLoading.value = false
            }
        }
    }

}
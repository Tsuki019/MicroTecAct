package com.prvt.microtecact.domain.usecases

import com.prvt.microtecact.data.models.Pokemon
import com.prvt.microtecact.data.network.GetPokemonRepository
import com.prvt.microtecact.util.Resource
import javax.inject.Inject

/**
 * Caso de uso encargado de obtener la informacion necesaria para la aplicacion desde el
 * repositorio correspondiente
 */

class GetPokemonInfoUseCase @Inject constructor(
    private val repoPoke: GetPokemonRepository
) {

    //En este caso no se necesita mas manejo de la informacion por lo que solo se hace el llamado
    //al repositorio
    suspend fun getPokemonInfo() : Resource<Pokemon>{
        return repoPoke.getPokemonInfo()
    }
}
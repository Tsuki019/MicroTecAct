package com.prvt.microtecact.data.network

import com.prvt.microtecact.data.models.Pokemon
import com.prvt.microtecact.data.network.PokemonApi
import com.prvt.microtecact.util.Constants.API_URL
import com.prvt.microtecact.util.Resource
import javax.inject.Inject

/**
 * Repositorio que se encarga de hacer la llamada a la API.
 *
 * Regresa la informacion del pokemon si la consulta se hace con exito, de lo contrario regresa
 * un mensaje de error
 */

class GetPokemonRepository @Inject constructor(
    private val api: PokemonApi
) {

    suspend fun getPokemonInfo(): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo()
        } catch(e: Exception) {
            return Resource.Error("${e.message}")
        }
        return Resource.Success(response)
    }
}
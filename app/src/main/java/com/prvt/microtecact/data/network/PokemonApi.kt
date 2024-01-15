package com.prvt.microtecact.data.network

import com.prvt.microtecact.data.models.Pokemon
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * API utilizada en la aplicacion
 */
interface PokemonApi {

    //Esta API esta proveida desde [AppModule]
    @GET(".")
    suspend fun getPokemonInfo(): Pokemon
}
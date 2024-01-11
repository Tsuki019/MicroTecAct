package com.prvt.microtecact.data.network

import com.prvt.microtecact.data.models.Pokemon
import retrofit2.http.GET


interface PokemonApi {

    @GET("/")
    suspend fun getPokemonInfo(): Pokemon
}
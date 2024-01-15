package com.prvt.microtecact.di

import com.prvt.microtecact.data.network.GetPokemonRepository
import com.prvt.microtecact.data.network.PokemonApi
import com.prvt.microtecact.util.Constants.API_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Modulo proveedor del API utilizado en la aplicacion
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    //Provee retrofit junto con un posible client.
    @Singleton
    @Provides
    fun providePokemonApi(): PokemonApi{
        return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(API_URL)
        .build()
        .create(PokemonApi::class.java) //Puede estar en un client proveido por separado en este mismo modulo
    }
}
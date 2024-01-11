package com.prvt.microtecact.di

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
 * Modulo proveedor para la llamada de la api
 */

//TODO El Modulo manda un error de Hilt que no me dio tiempo de corregir,
// manda el error incluso sin la funcion que provee

//@Module
//@InstallIn(SingletonComponent::class)
//object AppModule {
//
//    @Singleton
//    @Provides
//    fun providePokemonApi(): PokemonApi{
//        return Retrofit.Builder()
//        .addConverterFactory(GsonConverterFactory.create())
//        .baseUrl(API_URL)
//        .build()
//        .create(PokemonApi::class.java)
//    }
//}
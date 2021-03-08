package com.diaa.pokemonViperPattern.network

import com.diaa.pokemonViperPattern.models.PokemonResponse
import io.reactivex.Single
import retrofit2.Response


interface ApiHelper {

    suspend fun getPokemon(): Response<PokemonResponse>

}
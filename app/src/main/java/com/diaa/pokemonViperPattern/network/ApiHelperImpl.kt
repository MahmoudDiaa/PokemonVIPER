package com.diaa.pokemonViperPattern.network

import com.diaa.pokemonViperPattern.models.PokemonResponse
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {
    override suspend fun getPokemon(): Response<PokemonResponse> = apiService.getPokemon()


}
package com.diaa.pokemonViperPattern.network

import com.diaa.pokemonViperPattern.models.PokemonResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers


interface ApiService {
    @Headers(JSON_CONTENT_TYPE)
    @GET("pokemon")
    suspend fun getPokemon(): Response<PokemonResponse>

    companion object {
        private const val JSON_CONTENT_TYPE: String = "Content-Type: application/json"

    }
}
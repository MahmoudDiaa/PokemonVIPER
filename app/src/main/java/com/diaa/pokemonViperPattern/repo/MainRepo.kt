package com.diaa.pokemonViperPattern.repo

import com.diaa.pokemonViperPattern.models.PokemonResponse
import com.diaa.pokemonViperPattern.network.ApiHelper
import com.diaa.pokemonViperPattern.ui.main.MainContract
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject


class MainRepo @Inject constructor(private val apiHelper: ApiHelper) : MainContract.Repo {
    override suspend fun getPokemonResponse(): Flow<Response<PokemonResponse>> {
        return flow { emit(apiHelper.getPokemon() )  }
    }
}
package com.diaa.pokemonViperPattern.repo

import com.diaa.pokemonViperPattern.models.Pokemon
import com.diaa.pokemonViperPattern.ui.details.DetailsContract
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow


class DetailsRepo :DetailsContract.Repo {
    override fun getPokemon(): Flow<Pokemon> {
        TODO("Not yet implemented")
    }


}
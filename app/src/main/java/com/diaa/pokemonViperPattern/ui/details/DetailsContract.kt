package com.diaa.pokemonViperPattern.ui.details

import android.os.Bundle
import com.diaa.pokemonViperPattern.models.Pokemon
import kotlinx.coroutines.flow.Flow

interface DetailsContract {
    interface View {
        fun showLoading()
        fun dismissLoading()
        fun setData(data: Pokemon)
        fun showMessage(msg: String)

    }

    interface Presenter {

        fun bindView(view: View,activityView: android.view.View)
        fun unBindView()
        fun onViewCreated(pokemon: Pokemon?)
        fun onBackClicked()
        fun onError(error: Throwable)

    }

    interface Interactor {
        fun getPokemonData(onSusses: Pokemon, onError: (Throwable) -> Unit)
        fun dispose()
    }

    interface Router {
        fun finish()

    }

    interface Repo {
        fun getPokemon(): Flow<Pokemon>
    }
}
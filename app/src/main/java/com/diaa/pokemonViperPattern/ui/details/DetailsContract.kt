package com.diaa.pokemonViperPattern.ui.details

import com.diaa.pokemonViperPattern.models.Pokemon
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

interface DetailsContract {
    interface View {
        fun showLoading()
        fun dismissLoading()
        fun setData(data: List<Pokemon>)
        fun showMessage(msg: String)

    }

    interface Presenter {

        fun bindView(view: DetailsContract.View)
        fun unBindView()
        fun onViewCreated()
        fun inItemClicked(data: Pokemon)
        fun onBackClicked()

    }

    interface Interactor {
        fun getPokemonData(onSusses: Pokemon, onError: (Throwable) -> Unit)
    }

    interface Router {
        fun finish()

    }

    interface Repo {
        fun getPokemon(): Flow<Pokemon>
    }
}
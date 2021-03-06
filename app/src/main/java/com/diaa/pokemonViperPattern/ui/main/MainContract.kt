package com.diaa.pokemonViperPattern.ui.main

import com.diaa.pokemonViperPattern.models.Pokemon
import com.diaa.pokemonViperPattern.models.PokemonResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface MainContract {
    interface View {
        fun showLoading()
        fun dismissLoading()
        fun setData(data: List<Pokemon>)
        fun showMessage(msg: String)

    }

    interface Presenter {

        fun bindView(view: View, fragment: MainFragment, activityView: android.view.View)
        fun unBindView()
        fun onViewCreated()
        fun onItemClicked(pokemon: Pokemon)
        fun onBackClicked()


    }

    interface Interactor {
        fun getPokemonData(onSusses: (PokemonResponse) -> Unit, onError: (Throwable) -> Unit)
    }

    interface Router {
        fun finish()
        fun openFullPokemon(pokemon: Pokemon)
    }

    interface Repo {
        suspend fun getPokemonResponse(): Flow<Response<PokemonResponse>>
    }
}
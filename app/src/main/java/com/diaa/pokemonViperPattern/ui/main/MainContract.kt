package com.diaa.pokemonViperPattern.ui.main

import android.view.View
import com.diaa.pokemonViperPattern.models.Pokemon
import com.diaa.pokemonViperPattern.models.PokemonResponse
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

interface MainContract {
    interface View {
        fun showLoading()
        fun dismissLoading()
        fun setData(data: List<Pokemon>)
        fun showMessage(msg: String)

    }

    interface Presenter {

        fun bindView(view: View,activity: MainActivity,activityView: android.view.View)
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
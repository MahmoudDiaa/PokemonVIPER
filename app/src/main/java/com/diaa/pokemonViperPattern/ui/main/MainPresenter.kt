package com.diaa.pokemonViperPattern.ui.main

import android.util.Log
import android.view.View
import com.diaa.pokemonViperPattern.models.Pokemon
import javax.inject.Inject

class MainPresenter @Inject constructor(
//    private val activity: MainActivity,
    private val interactor: MainInteractor
) : MainContract.Presenter {

    private var view: MainContract.View? = null
    private lateinit var router: MainRouter


    override fun bindView(
        view: MainContract.View,
        activity: MainActivity,
        activityView: View
    ) {
        this.view = view
       this.router=MainRouter(activity,activityView)
    }

    override fun unBindView() {
        view = null
        interactor.dispose()
    }

    override fun onViewCreated() {
        Log.e("presenter", "onViewCreated: ")
        view?.showLoading()
        interactor.getPokemonData(
            {
                Log.e("presenter", "onViewCreated: interactor ")
                view?.dismissLoading()
                view?.setData(it.results)
            }, this::onError
        )
    }

    override fun onItemClicked(pokemon: Pokemon) {
        router.openFullPokemon(pokemon)
    }

    override fun onBackClicked() {
        router.finish()
    }

    private fun onError(error: Throwable) {
        view?.dismissLoading()
        error.message?.let { view?.showMessage(it) }
    }
}
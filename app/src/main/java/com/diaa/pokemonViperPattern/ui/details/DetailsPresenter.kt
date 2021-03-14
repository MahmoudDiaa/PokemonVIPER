package com.diaa.pokemonViperPattern.ui.details

import android.util.Log
import android.view.View
import com.diaa.pokemonViperPattern.models.Pokemon


class DetailsPresenter :
    DetailsContract.Presenter {

    private var view: DetailsContract.View? = null
    private lateinit var router: DetailsRouter

    override fun bindView(view: DetailsContract.View, activityView: View) {

        this.view = view
        Log.e("presenter", "bindView: "+(this.view==null) )
        this.view!!.showLoading()
        this.router = DetailsRouter(activityView)
    }

    override fun unBindView() {
        view = null
    }

    override fun onViewCreated(pokemon: Pokemon?) {
        Log.e("presenter", "onViewCreated: " + (view == null))
        view?.dismissLoading()
        Log.e("presenter", "onViewCreated: " + (view == null))
        view?.setData(pokemon!!)
    }


    override fun onBackClicked() {
        router.finish()
    }

    override fun onError(error: Throwable) {
        view?.dismissLoading()
        error.message?.let { view?.showMessage(it) }
    }

}
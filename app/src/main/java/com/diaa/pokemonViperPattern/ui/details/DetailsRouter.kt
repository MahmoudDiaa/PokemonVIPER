package com.diaa.pokemonViperPattern.ui.details

import android.view.View
import androidx.navigation.Navigation


class DetailsRouter(private val activityView: View) : DetailsContract.Router {
    override fun finish() {
        Navigation.findNavController(activityView).popBackStack()
    }


}
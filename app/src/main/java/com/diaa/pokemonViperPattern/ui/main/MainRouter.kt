package com.diaa.pokemonViperPattern.ui.main

import android.util.Log
import android.view.View
import com.diaa.pokemonViperPattern.App
import com.diaa.pokemonViperPattern.models.Pokemon
import com.diaa.pokemonViperPattern.ui.details.DetailsActivity


class MainRouter(private val activity: MainActivity, private val activityView: View) :
    MainContract.Router {
    override fun finish() {
        activity.finish()
    }

    override fun openFullPokemon(pokemon: Pokemon) {
        Log.e("MainRouter", "openFullPokemon: $activity")
//        activity.findNavController(R.id.main_pokemon)
//            .navigate(R.id.action_main_pokemon_to_pokemon_details)
//        Navigation.findNavController(activity.currentFocus!!)
//            .navigate(R.id.action_main_pokemon_to_pokemon_details)
//        Navigation.findNavController(activityView).navigate(R.id.pokemon_details)

        App.INSTANCE.navigation(activity.applicationContext, DetailsActivity::class.java)

    }


}
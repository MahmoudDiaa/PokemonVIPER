package com.diaa.pokemonViperPattern.ui.main

import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.os.persistableBundleOf
import androidx.navigation.Navigation
import com.diaa.pokemonViperPattern.R
import com.diaa.pokemonViperPattern.models.Pokemon


class MainRouter(private val fragment: MainFragment, private val activityView: View) :
    MainContract.Router {
    override fun finish() {
        Navigation.findNavController(activityView).popBackStack()
    }

    override fun openFullPokemon(pokemon: Pokemon) {
        Log.e("MainRouter", "openFullPokemon: $fragment")
//        activity.findNavController(R.id.main_pokemon)
//            .navigate(R.id.action_main_pokemon_to_pokemon_details)
//        Navigation.findNavController(activity.currentFocus!!)
//            .navigate(R.id.action_main_pokemon_to_pokemon_details)
        val bundle = bundleOf("pokemon" to pokemon)
        Log.e("router", "openFullPokemon: "+pokemon.name )
        Navigation.findNavController(activityView).navigate(R.id.pokemon_details,bundle)

//        App.INSTANCE.navigation(activity.applicationContext, DetailsActivity::class.java)

    }


}
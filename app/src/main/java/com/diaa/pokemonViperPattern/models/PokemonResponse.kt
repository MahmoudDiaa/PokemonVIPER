package com.diaa.pokemonViperPattern.models

data class PokemonResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: ArrayList<Pokemon>
)
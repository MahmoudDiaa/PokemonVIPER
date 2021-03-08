package com.diaa.pokemonViperPattern.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val name: String,
    var url: String
): Parcelable
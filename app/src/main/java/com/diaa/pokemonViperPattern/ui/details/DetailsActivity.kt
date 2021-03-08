package com.diaa.pokemonViperPattern.ui.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.diaa.pokemonViperPattern.models.Pokemon


class DetailsActivity : AppCompatActivity(),DetailsContract.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun dismissLoading() {
        TODO("Not yet implemented")
    }

    override fun setData(data: List<Pokemon>) {
        TODO("Not yet implemented")
    }

    override fun showMessage(msg: String) {
        TODO("Not yet implemented")
    }
}
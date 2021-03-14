package com.diaa.pokemonViperPattern.ui.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.diaa.pokemonViperPattern.BuildConfig
import com.diaa.pokemonViperPattern.databinding.PokemonDetailBinding
import com.diaa.pokemonViperPattern.models.Pokemon
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class DetailsFragment : Fragment(), DetailsContract.View {
    private var _binding: PokemonDetailBinding? = null

    private val binding get() = _binding!!

    private val presenter  = DetailsPresenter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PokemonDetailBinding.inflate(inflater, container, false)

        val pokemon =arguments?.getParcelable<Pokemon>("pokemon")
        presenter.bindView(this, binding.root)

        presenter.onViewCreated(pokemon)
        return binding.root

    }

    override fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
        binding.cardView.visibility = View.GONE
    }

    override fun dismissLoading() {
        binding.progressBar.visibility = View.GONE
        binding.cardView.visibility = View.VISIBLE
    }

    override fun setData(data: Pokemon) {
        Glide.with(this).load(data.url).into(binding.pkImage)
        binding.pkName.text = data.name
    }

    override fun showMessage(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}
package com.diaa.pokemonViperPattern.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.diaa.pokemonViperPattern.databinding.ActivityMainBinding
import com.diaa.pokemonViperPattern.models.Pokemon
import com.diaa.pokemonViperPattern.ui.main.adpters.PokemonAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment(), MainContract.View {

    @Inject
    lateinit var presenter: MainPresenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityMainBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initView()
        presenter.bindView(this, this, binding.root)
        presenter.onViewCreated()


        return root
    }

    private fun initView() {
        val manager =
            LinearLayoutManager(activity).apply { orientation = LinearLayoutManager.VERTICAL }
        binding.pokemonRv.layoutManager = manager
    }

    override fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
        binding.pokemonRv.visibility = View.GONE
    }

    override fun dismissLoading() {
        binding.progressBar.visibility = View.GONE
        binding.pokemonRv.visibility = View.VISIBLE
    }

    override fun setData(data: List<Pokemon>) {

        val adapter = PokemonAdapter(object : PokemonAdapter.PokemonListener {
            override fun onItemClick(data: Pokemon) {


                presenter.onItemClicked(data)
            }
        })
        adapter.submitList(data)

        binding.pokemonRv.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unBindView()
    }

    override fun showMessage(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}
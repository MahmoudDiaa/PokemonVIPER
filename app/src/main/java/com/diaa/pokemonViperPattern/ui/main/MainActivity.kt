package com.diaa.pokemonViperPattern.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.diaa.pokemonViperPattern.R
import com.diaa.pokemonViperPattern.databinding.ActivityMainBinding
import com.diaa.pokemonViperPattern.models.Pokemon
import com.diaa.pokemonViperPattern.ui.main.adpters.PokemonAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainContract.View {
    @Inject
    lateinit var presenter: MainPresenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initView()
        presenter.bindView(this, this,binding.root)
        presenter.onViewCreated()



    }

    private fun initView() {
        val manager = LinearLayoutManager(this).apply { orientation = LinearLayoutManager.VERTICAL }
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
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
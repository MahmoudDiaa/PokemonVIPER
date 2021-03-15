package com.diaa.pokemonViperPattern.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.diaa.pokemonViperPattern.R
import com.diaa.pokemonViperPattern.databinding.FirstLayoutBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstActivity : AppCompatActivity() {
    private lateinit var binding: FirstLayoutBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FirstLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.nav_host_fragment_activity_main)


    }

    override fun onBackPressed() {
        if (!navController.popBackStack())
            super.onBackPressed()


    }
}
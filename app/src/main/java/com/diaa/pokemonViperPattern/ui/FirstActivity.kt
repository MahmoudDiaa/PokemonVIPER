package com.diaa.pokemonViperPattern.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.diaa.pokemonViperPattern.databinding.FirstLayoutBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstActivity : AppCompatActivity() {
    private lateinit var binding: FirstLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FirstLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
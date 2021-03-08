package com.diaa.pokemonViperPattern.ui.main.adpters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.diaa.pokemonViperPattern.databinding.PokemonListBinding
import com.diaa.pokemonViperPattern.models.Pokemon

class PokemonAdapter(private val listener: PokemonListener) :
    RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            PokemonListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    private val diffCallback = object : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }
    private val differ = AsyncListDiffer(this, diffCallback)

    fun submitList(list: List<Pokemon>) = differ.submitList(list)

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(differ.currentList[position], listener)

    class ViewHolder(private val binding: PokemonListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Pokemon, listener: PokemonListener) {
            binding.pkName.text = data.name
            Log.e("Adapter", "bind: ${data.url}")
            Glide.with(this.itemView).load(data.url).into(binding.pkImage)

            binding.root.setOnClickListener { listener.onItemClick(data) }
        }
    }

    interface PokemonListener {
        fun onItemClick(data: Pokemon)
    }
}
package com.diaa.pokemonViperPattern.ui.main

import android.util.Log
import com.diaa.pokemonViperPattern.models.PokemonResponse
import com.diaa.pokemonViperPattern.repo.MainRepo
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


class MainInteractor @Inject constructor(private val repo: MainRepo) :
    MainContract.Interactor {
    private val compositeDisposable = CompositeDisposable()

    override fun getPokemonData(onSusses: (PokemonResponse) -> Unit, onError: (Throwable) -> Unit) {


        CoroutineScope(Dispatchers.IO).launch {
            repo.getPokemonResponse().filter {
                it.isSuccessful && it.code() == 200
            }

                .catch {

                    onError.invoke(it)
                }
                .collect {
                    it.body()?.results?.forEach { pokemon ->
                        val urlArray = pokemon.url.split("/")
                        urlArray.forEach { url -> Log.e("MainViewModel", "getEmployees: $url") }
                        pokemon.url =
                            "https://pokeres.bastionbot.org/images/pokemon/" + urlArray[urlArray.size - 2] + ".png"
                    }
                    withContext(Dispatchers.Main) { onSusses.invoke(it.body()!!) }
                }

        }


    }

    fun dispose() = compositeDisposable.dispose()

    companion object {
        private const val TAG = "MainInteractor"
    }
}
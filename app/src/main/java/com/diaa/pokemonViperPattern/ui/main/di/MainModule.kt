package com.diaa.pokemonViperPattern.ui.main.di

import com.diaa.pokemonViperPattern.repo.MainRepo
import com.diaa.pokemonViperPattern.ui.main.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
//
//@InstallIn(ActivityComponent::class)
//@Module
//object MainModule {
//    @Provides
//    @ActivityScoped
//    fun router(activity: MainActivity): MainContract.Router = MainRouter(activity)
//
//    @Provides
//    @ActivityScoped
//    fun presenter(router: MainContract.Router, interactor: MainInteractor) =
//        MainPresenter(router, interactor)
//
//    @Provides
//    @ActivityScoped
//    fun interactor(repository: MainRepo) = MainInteractor(repository)
//}

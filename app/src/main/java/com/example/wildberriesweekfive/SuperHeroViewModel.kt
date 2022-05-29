package com.example.wildberriesweekfive

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

open class SuperHeroViewModel : ViewModel() {

    val itemsSuperHeroes = MutableLiveData<List<SuperHeroJSON>>()
    private val api = RetrofitFactory.new()
    private var job: Job? = null

    fun request() {
        job?.cancel()
        job = viewModelScope.launch(Dispatchers.IO) {

            val superHero = api.getSuperHeroes()

            itemsSuperHeroes.postValue(superHero)

        }

    }

}
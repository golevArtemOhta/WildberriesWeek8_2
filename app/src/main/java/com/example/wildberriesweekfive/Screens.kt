package com.example.wildberriesweekfive

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun Main() = FragmentScreen { SuperHeroesListFragment() }
    fun SuperHeroItemScreen(bundle: Bundle) = FragmentScreen { SuperHeroItemFragment.newInstance(bundle) }
    fun InfoScreen() = FragmentScreen { InfoFragment.newInstance() }

}
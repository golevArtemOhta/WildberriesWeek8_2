package com.example.wildberriesweekfive

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wildberriesweekfive.databinding.ActivityMainBinding
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val navigator = AppNavigator(this, R.id.fragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            App.INSTANCE.router.newRootScreen(Screens.Main())
        }

        binding.imageButtonInfo.setOnClickListener {
            App.INSTANCE.router.navigateTo(Screens.InfoScreen())
        }


    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.INSTANCE.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        App.INSTANCE.navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        App.INSTANCE.router.navigateTo(Screens.Main())
    }

//    private fun openFragment() {
//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.fragment, SuperHeroesListFragment.newInstance())
//            .commit()
//    }
}
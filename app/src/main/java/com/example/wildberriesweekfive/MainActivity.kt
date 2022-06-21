package com.example.wildberriesweekfive

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.wildberriesweekfive.databinding.ActivityMainBinding
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    lateinit var itemInfo: MenuItem

    private val navigator = AppNavigator(this, R.id.fragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            App.INSTANCE.router.newRootScreen(Screens.Main())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        itemInfo = menu!!.findItem(R.id.info)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.info) {
            App.INSTANCE.router.navigateTo(Screens.InfoScreen())
            itemInfo.isVisible = false
        }
        return true
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
        itemInfo.isVisible = true
    }


}
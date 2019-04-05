package com.example.android

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val navController: NavController by lazy {
        Navigation.findNavController(this, R.id.nav_host)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.drawer, menu)
        val appBarConfiguration = AppBarConfiguration.Builder(menu).apply {
            setDrawerLayout(drawer)
        }.build()
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration)
        return true
    }

    private fun initView() {
        setSupportActionBar(toolbar)

        nav_view.setNavigationItemSelectedListener { item ->
            if (drawer.isDrawerOpen(nav_view)) {
                drawer.closeDrawer(nav_view)
            }
            handleNavigation(item.itemId)
        }
    }

    private fun handleNavigation(itemId: Int): Boolean {
        if (navController.currentDestination?.id == itemId) {
            return false
        }
        navController.navigate(itemId)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, drawer) || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}

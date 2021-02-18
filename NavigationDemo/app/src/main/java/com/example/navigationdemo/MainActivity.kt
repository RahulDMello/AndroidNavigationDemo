package com.example.navigationdemo

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
        val topLevelDestinations = setOf(
            R.id.flow1Fragment1,
            R.id.flow2MainFragment,
            R.id.flow3Fragment1,
            R.id.flow4Fragment1
        )
        appBarConfiguration = AppBarConfiguration(topLevelDestinations, findViewById<DrawerLayout>(R.id.drawer_layout))
        setupActionBarWithNavController(navController, appBarConfiguration)
        findViewById<NavigationView>(R.id.nav_view)
            .setupWithNavController(navController)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav).apply {
            setupWithNavController(navController)
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            bottomNav.isVisible = destination.id != R.id.flow4Fragment1
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }
}
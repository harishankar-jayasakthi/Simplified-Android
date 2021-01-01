package com.jetpackio.navigationmaster

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import kotlinx.android.synthetic.main.eg1_nav_graph_activity_main.*
import kotlinx.android.synthetic.main.eg1_nav_graph_activity_main.toolbar
import kotlinx.android.synthetic.main.eg2_activity_main.*

class Eg1NavGraphActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration //menu button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.eg1_nav_graph_activity_main)

        // Create Toolbar and set support action bar
        setSupportActionBar(toolbar)

        // Get NavController
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Get App Configuration from nav graph
        appBarConfiguration = AppBarConfiguration(navController.graph)

        setupActionBarWithNavController(navController, appBarConfiguration)
        //toolbar.setupWithNavController(navController, appBarConfiguration)


        // Get NavHostFragment & ChildFragmentManager of NavHostFragment
        /*val navHostChildFragmentManager = navHostFragment.childFragmentManager
        navHostChildFragmentManager.addOnBackStackChangedListener {
            val backStackEntryCount = navHostChildFragmentManager.backStackEntryCount
            val fragments = navHostChildFragmentManager.fragments
            println("NavHost count: $backStackEntryCount, fragments: $fragments")
        }*/
    }
    //....................................................................................menu button
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        // Navigates to destination which is both has the same id in menu.xml and nav_graph.xml.
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }
    // This function is required with appbar to handle back button
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
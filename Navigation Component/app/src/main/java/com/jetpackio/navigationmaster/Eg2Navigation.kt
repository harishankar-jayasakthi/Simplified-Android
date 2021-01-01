package com.jetpackio.navigationmaster

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import kotlinx.android.synthetic.main.eg2_activity_main.*

class Eg2Navigation : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.eg2_activity_main)

        setSupportActionBar(toolbar)

        // Get NavController
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController


        // which fragments should display hamburger button and the ones not included back arrow
      /*  appBarConfiguration = AppBarConfiguration(
                setOf(R.id.dest_page1, R.id.dest_page2,R.id.dest_page3),
                drawerLayout
        )*/
        appBarConfiguration = AppBarConfiguration(navController.graph,drawerLayout)


        navView.setupWithNavController(navController) // This does NOT modify the appBar

        toolbar.setupWithNavController(navController, appBarConfiguration)

        bottomView?.setupWithNavController(navController)

        bottomView.setOnNavigationItemSelectedListener {
            NavigationUI.onNavDestinationSelected(it, navController)
        }


       // listenForNavigationEvents(navController, toolbar)
    }

    // Setting menu options
  /*  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        // Navigates to destination which is both has the same id in menu.xml and nav_graph.xml.
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }*/


/*
    private fun listenForNavigationEvents(navController: NavController, toolbar: Toolbar) {

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.dest_page3) {
                toolbar.visibility = View.GONE
            } else {
                toolbar.visibility = View.VISIBLE
            }
        }

        //.....................................................bottom nav
        supportFragmentManager.addOnBackStackChangedListener {
            val backStackEntryCount = supportFragmentManager.backStackEntryCount
            val fragments = supportFragmentManager.fragments
            val fragmentCount = fragments.size
            Toast.makeText(
                this,
                "MainActivity backStackEntryCount: $backStackEntryCount, fragmentCount: $fragmentCount, fragments: $fragments",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
*/

}
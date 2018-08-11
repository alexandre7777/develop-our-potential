package com.alexandre.potentialgrowth.ui

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.ui.favorites.FavoritesActivity
import com.alexandre.potentialgrowth.ui.home.HomeActivity
import com.alexandre.potentialgrowth.ui.instruction.InstructionActivity
import com.alexandre.potentialgrowth.ui.licence.LicenceActivity
import com.alexandre.potentialgrowth.ui.yourdairy.YourDairyActivity
import kotlinx.android.synthetic.main.activity_home.*

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(toolbar)

        setupDrawer()
    }


    private fun setupDrawer() {

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // set item as selected to persist highlight

            // close drawer when item is tapped
            drawerLayout.closeDrawers()

            // Add code here to update the UI based on the item selected
            // For example, swap UI fragments here

            when (menuItem.title) {
                resources.getString(R.string.home) -> {
                    if(!menuItem.isChecked) {
                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                    }
                }
                resources.getString(R.string.instruction) -> {
                    if(!menuItem.isChecked) {
                        val intent = Intent(this, InstructionActivity::class.java)
                        startActivity(intent)
                    }
                }
                resources.getString(R.string.your_dairy) -> {
                    if(!menuItem.isChecked) {
                        val intent = Intent(this, YourDairyActivity::class.java)
                        startActivity(intent)
                    }
                }
                resources.getString(R.string.favorites) -> {
                    if(!menuItem.isChecked) {
                        val intent = Intent(this, FavoritesActivity::class.java)
                        startActivity(intent)
                    }
                }
                resources.getString(R.string.licence) -> {
                    if(!menuItem.isChecked) {
                        val intent = Intent(this, LicenceActivity::class.java)
                        startActivity(intent)
                    }
                }
            }

            menuItem.isChecked = true

            true
        }

        val actionbar: ActionBar? = supportActionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
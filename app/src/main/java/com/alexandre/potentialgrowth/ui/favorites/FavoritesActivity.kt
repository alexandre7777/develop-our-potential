package com.alexandre.potentialgrowth.ui.favorites

import android.os.Bundle
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.ui.MainActivity
import kotlinx.android.synthetic.main.activity_home.*

class FavoritesActivity : MainActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        setContentView(R.layout.activity_favorites)
        super.onCreate(savedInstanceState)

        nav_view.menu.getItem(3).isChecked = true
    }
}
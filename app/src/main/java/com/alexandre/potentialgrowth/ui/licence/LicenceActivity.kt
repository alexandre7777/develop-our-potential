package com.alexandre.potentialgrowth.ui.licence

import android.os.Bundle
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.ui.MainActivity
import kotlinx.android.synthetic.main.activity_home.*

class LicenceActivity : MainActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        setContentView(R.layout.activity_licence)
        super.onCreate(savedInstanceState)

        nav_view.menu.getItem(4).isChecked = true
    }
}
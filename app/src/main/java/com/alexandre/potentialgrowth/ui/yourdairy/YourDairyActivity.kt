package com.alexandre.potentialgrowth.ui.yourdairy

import android.os.Bundle
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.ui.MainActivity
import kotlinx.android.synthetic.main.activity_home.*

class YourDairyActivity : MainActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        setContentView(R.layout.activity_your_dairy)
        super.onCreate(savedInstanceState)

        nav_view.menu.getItem(2).isChecked = true
    }
}
package com.alexandre.potentialgrowth.ui.instruction

import android.os.Bundle
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.ui.MainActivity
import kotlinx.android.synthetic.main.activity_home.*

class InstructionActivity : MainActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        setContentView(R.layout.activity_instruction)
        super.onCreate(savedInstanceState)

        nav_view.menu.getItem(1).isChecked = true
    }
}
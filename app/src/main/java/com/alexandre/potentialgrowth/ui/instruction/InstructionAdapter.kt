package com.alexandre.potentialgrowth.ui.instruction


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class InstructionAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private val NUM_PAGES = 5

    override fun getItem(position: Int): Fragment {
        return InstructionFragment().newInstance(position)
    }

    override fun getCount(): Int {
        return NUM_PAGES
    }
}
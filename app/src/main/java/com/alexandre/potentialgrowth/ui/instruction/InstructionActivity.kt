package com.alexandre.potentialgrowth.ui.instruction

import android.os.Bundle
import android.support.v4.view.ViewPager
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.ui.MainActivity
import kotlinx.android.synthetic.main.activity_instruction.*

class InstructionActivity : MainActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        setContentView(R.layout.activity_instruction)
        super.onCreate(savedInstanceState)

        nav_view.menu.getItem(1).isChecked = true


        val pagerAdapter = InstructionAdapter(getSupportFragmentManager());
        pager.adapter = pagerAdapter

        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        indicator1.setImageDrawable(getDrawable(R.drawable.ic_black_round))
                        indicator2.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator3.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator4.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator5.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                    }
                    1 -> {
                        indicator1.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator2.setImageDrawable(getDrawable(R.drawable.ic_black_round))
                        indicator3.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator4.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator5.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                    }
                    2 -> {
                        indicator1.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator2.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator3.setImageDrawable(getDrawable(R.drawable.ic_black_round))
                        indicator4.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator5.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                    }
                    3 -> {
                        indicator1.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator2.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator3.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator4.setImageDrawable(getDrawable(R.drawable.ic_black_round))
                        indicator5.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                    }
                    4 -> {
                        indicator1.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator2.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator3.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator4.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator5.setImageDrawable(getDrawable(R.drawable.ic_black_round))
                    }
                }
            }

        })
    }
}
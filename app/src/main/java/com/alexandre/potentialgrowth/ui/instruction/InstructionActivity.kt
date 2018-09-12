package com.alexandre.potentialgrowth.ui.instruction

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.ui.home.HomeActivity
import kotlinx.android.synthetic.main.activity_instruction.*
import com.alexandre.potentialgrowth.ui.mainactivity.MainActivity

class InstructionActivity : MainActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        setContentView(R.layout.activity_instruction)
        super.onCreate(savedInstanceState)

        nav_view.menu.getItem(1).isChecked = true

        buttonSkip.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

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
                        buttonSkip.text = getString(R.string.skip)
                        buttonSkip.background = getDrawable(R.drawable.ripple_white)
                        buttonSkip.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
                    }
                    1 -> {
                        indicator1.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator2.setImageDrawable(getDrawable(R.drawable.ic_black_round))
                        indicator3.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator4.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator5.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        buttonSkip.text = getString(R.string.skip)
                        buttonSkip.background = getDrawable(R.drawable.ripple_white)
                        buttonSkip.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
                    }
                    2 -> {
                        indicator1.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator2.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator3.setImageDrawable(getDrawable(R.drawable.ic_black_round))
                        indicator4.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator5.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        buttonSkip.text = getString(R.string.skip)
                        buttonSkip.background = getDrawable(R.drawable.ripple_white)
                        buttonSkip.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
                    }
                    3 -> {
                        indicator1.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator2.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator3.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator4.setImageDrawable(getDrawable(R.drawable.ic_black_round))
                        indicator5.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        buttonSkip.text = getString(R.string.skip)
                        buttonSkip.background = getDrawable(R.drawable.ripple_white)
                        buttonSkip.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
                    }
                    4 -> {
                        indicator1.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator2.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator3.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator4.setImageDrawable(getDrawable(R.drawable.ic_grey_round))
                        indicator5.setImageDrawable(getDrawable(R.drawable.ic_black_round))
                        buttonSkip.text = getString(R.string.done)
                        buttonSkip.background = getDrawable(R.drawable.ripple_opposite_white)
                        buttonSkip.setTextColor(ContextCompat.getColor(applicationContext, R.color.white))
                    }
                }
            }
        })
    }
}
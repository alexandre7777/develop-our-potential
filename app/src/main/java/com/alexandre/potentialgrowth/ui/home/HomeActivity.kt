package com.alexandre.potentialgrowth.ui.home

import android.os.Bundle
import android.support.v4.app.Fragment
import com.alexandre.potentialgrowth.R
import kotlinx.android.synthetic.main.activity_home.*
import android.support.v4.view.ViewPager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentManager
import com.alexandre.potentialgrowth.ui.mainactivity.MainActivity
import com.alexandre.potentialgrowth.ui.home.dashboard.DashBoardFragment
import com.alexandre.potentialgrowth.ui.home.knowledge.KnowledgeFragment
import com.alexandre.potentialgrowth.ui.home.reward.RewardFragment

/**
 * First activity with 3 tabs
 */
class HomeActivity : MainActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        setContentView(R.layout.activity_home)
        super.onCreate(savedInstanceState)

        setupViewPager(viewPager)
        tabs.setupWithViewPager(viewPager)
        nav_view.menu.getItem(0).isChecked = true
    }



    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(DashBoardFragment(), "DASHBOARD")
        adapter.addFragment(KnowledgeFragment(), "KNOWLEDGE")
        adapter.addFragment(RewardFragment(), "REWARDS")
        viewPager.adapter = adapter
    }

    internal inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
        private val mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<String>()

        override fun getItem(position: Int): Fragment {
            return mFragmentList.get(position)
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mFragmentTitleList.get(position)
        }
    }
}
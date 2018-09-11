package com.alexandre.potentialgrowth.ui.yourdairy

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.alexandre.potentialgrowth.Injection
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.model.Dairy
import com.alexandre.potentialgrowth.ui.mainactivity.MainActivity
import kotlinx.android.synthetic.main.activity_your_dairy.*
import android.support.v7.widget.RecyclerView

class YourDairyActivity : MainActivity() {

    private lateinit var viewModelYourDairy: YourDairyActivyViewModel

    private val adapter = DairyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {

        setContentView(R.layout.activity_your_dairy)
        super.onCreate(savedInstanceState)

        viewModelYourDairy = ViewModelProviders.of(this, Injection.provideViewModelFactoryYourDairy(this))
                .get(YourDairyActivyViewModel::class.java)

        nav_view.menu.getItem(2).isChecked = true

        initFAB()

        initAdapter()
    }

    private fun initFAB() {
        fab.setOnClickListener({
            val addDialogFragment = AddDialogFragment()
            addDialogFragment.show(supportFragmentManager, "Add")

        })
    }

    private fun initAdapter(){
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter

        viewModelYourDairy.dairyList.observe(this, Observer<List<Dairy>> {
            adapter.submitList(it)
            list.layoutManager.smoothScrollToPosition(list, RecyclerView.State(), 0)
        })
    }
}
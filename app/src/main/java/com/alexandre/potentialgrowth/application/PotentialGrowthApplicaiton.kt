package com.alexandre.potentialgrowth.application

import android.app.Application

class PotentialGrowthApplicaiton : Application() {

    override fun onCreate() {
        super.onCreate()
        InitializeDebug().init(this)
    }
}
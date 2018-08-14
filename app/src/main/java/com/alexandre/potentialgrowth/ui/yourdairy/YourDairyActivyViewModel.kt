package com.alexandre.potentialgrowth.ui.yourdairy

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.alexandre.potentialgrowth.data.DairyRepo
import com.alexandre.potentialgrowth.model.Dairy

class YourDairyActivyViewModel(private val dairyRepo: DairyRepo) : ViewModel() {

    public var dairyList : LiveData<List<Dairy>> = dairyRepo.getAllDairy()
}
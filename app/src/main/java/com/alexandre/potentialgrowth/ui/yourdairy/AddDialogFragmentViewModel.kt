package com.alexandre.potentialgrowth.ui.yourdairy

import android.arch.lifecycle.ViewModel
import com.alexandre.potentialgrowth.data.DairyRepo
import com.alexandre.potentialgrowth.model.Dairy

/**
 * View Model to add new dairy entry
 */
class AddDialogFragmentViewModel(private val dairyRepo: DairyRepo) : ViewModel() {

    public fun insertDairy(text : String, type : Int) {
        val dairy = Dairy(idDairy = 0, idType = type, dairyText = text)
        dairyRepo.insert(dairy)
    }
}
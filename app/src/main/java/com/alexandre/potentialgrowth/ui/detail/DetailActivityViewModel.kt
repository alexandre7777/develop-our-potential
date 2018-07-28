package com.alexandre.potentialgrowth.ui.detail

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.alexandre.potentialgrowth.data.ContributionRepo
import com.alexandre.potentialgrowth.data.LearnItemRepo
import com.alexandre.potentialgrowth.model.Contribution
import com.alexandre.potentialgrowth.model.LearnItem
import java.util.*

class DetailActivityViewModel(private val learnItemRepo: LearnItemRepo, private val contributionRepo: ContributionRepo, idLearnItem: Long) : ViewModel() {

    public var learnItem : LiveData<LearnItem> = learnItemRepo.getLearnItemById(idLearnItem)

    public fun insertContribution(idLearnItem: Long?) {
        if (idLearnItem != null) {
            contributionRepo.insert(Contribution(idLearnItem = idLearnItem, idType = 1, time = Date(), result = "", idContribution = 0))
        }
    }
}
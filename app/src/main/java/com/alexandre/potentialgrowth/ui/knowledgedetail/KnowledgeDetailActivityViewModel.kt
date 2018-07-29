package com.alexandre.potentialgrowth.ui.knowledgedetail

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.alexandre.potentialgrowth.data.ContributionRepo
import com.alexandre.potentialgrowth.data.LearnItemRepo
import com.alexandre.potentialgrowth.model.Contribution
import com.alexandre.potentialgrowth.model.LearnItem
import java.util.*

class KnowledgeDetailActivityViewModel(private val learnItemRepo: LearnItemRepo, private val contributionRepo: ContributionRepo, idLearnItem: Long) : ViewModel() {

    public var learnItem : LiveData<LearnItem> = learnItemRepo.getLearnItemById(idLearnItem)

    public var doneItNum : LiveData<Int> = contributionRepo.countHaveDoneforDate(idLearnItem, Date())

    public fun insertContribution(idLearnItem: Long?) {
        if (idLearnItem != null) {
            contributionRepo.insert(Contribution(idLearnItem = idLearnItem, idType = 1, time = Date(), result = "", idContribution = 0))
        }
    }

    public fun commentContribution(idLearnItem: Long?, text: String) {
        if (idLearnItem != null) {
            contributionRepo.insert(Contribution(idLearnItem = idLearnItem, idType = 2, time = Date(), result = text, idContribution = 0))
        }
    }
}
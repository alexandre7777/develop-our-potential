package com.alexandre.potentialgrowth.ui.knowledgedetail

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.alexandre.potentialgrowth.data.ContributionRepo
import com.alexandre.potentialgrowth.data.LearnItemRepo
import com.alexandre.potentialgrowth.model.Contribution
import com.alexandre.potentialgrowth.model.LearnItem
import java.util.*

/**
 * View Model for displaying the detail of an item to learn
 */
class KnowledgeDetailActivityViewModel(private val learnItemRepo: LearnItemRepo, private val contributionRepo: ContributionRepo, idLearnItem: Long) : ViewModel() {

    public var learnItem : LiveData<LearnItem> = learnItemRepo.getLearnItemById(idLearnItem)

    public var doneItNum : LiveData<Int> = contributionRepo.countHaveDoneforDate(idLearnItem, Date())

    public var commentList : LiveData<List<Contribution>> = contributionRepo.getContributionForLearnItem(idLearnItem)

    /**
     * store a new "I have done it"
     */
    public fun updateFav(learnItem: LearnItem?) {
        if (learnItem != null)
            learnItemRepo.updateFav(learnItem.idLearnItem, !learnItem.isFavorite)
    }

    /**
     * store a new "I have done it"
     */
    public fun insertContribution(idLearnItem: Long?) {
        if (idLearnItem != null) {
            contributionRepo.insert(Contribution(idLearnItem = idLearnItem, idType = 1, time = Date(), result = "", idContribution = 0))
        }
    }

    /**
     * store a new comment
     */
    public fun commentContribution(idLearnItem: Long?, text: String) {
        if (idLearnItem != null) {
            contributionRepo.insert(Contribution(idLearnItem = idLearnItem, idType = 2, time = Date(), result = text, idContribution = 0))
        }
    }
}
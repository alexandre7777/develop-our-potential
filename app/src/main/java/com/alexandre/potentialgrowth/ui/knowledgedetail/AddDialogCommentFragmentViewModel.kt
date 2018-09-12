package com.alexandre.potentialgrowth.ui.knowledgedetail

import android.arch.lifecycle.ViewModel
import com.alexandre.potentialgrowth.data.ContributionRepo
import com.alexandre.potentialgrowth.data.DairyRepo
import com.alexandre.potentialgrowth.model.Contribution
import com.alexandre.potentialgrowth.model.Converters
import com.alexandre.potentialgrowth.model.Dairy
import java.util.*

/**
 * View Model to add new dairy entry
 */
class AddDialogCommentFragmentViewModel(private val contributionRepo: ContributionRepo) : ViewModel() {

    fun commentContribution(idLearnItem: Long?, text: String) {
        if (idLearnItem != null) {
            contributionRepo.insert(Contribution(idLearnItem = idLearnItem, idType = 2, time = Date(), result = text, idContribution = 0))
        }
    }
}
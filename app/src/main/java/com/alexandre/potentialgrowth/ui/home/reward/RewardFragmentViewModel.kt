package com.alexandre.potentialgrowth.ui.home.reward

import android.arch.lifecycle.ViewModel
import com.alexandre.potentialgrowth.data.ContributionRepo

class RewardFragmentViewModel(private val repository: ContributionRepo) : ViewModel() {

    var isBronzeDone = repository.isBronzeDone()

    var isSilverDone = repository.isSilverDone()

    var isGoldDone = repository.isGoldDone()

    var isBronzeComment = repository.isBronzeComment()

    var isSilverComment = repository.isSilverComment()

    var isGoldComment = repository.isGoldComment()
}
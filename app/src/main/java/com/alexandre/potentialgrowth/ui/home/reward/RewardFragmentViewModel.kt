package com.alexandre.potentialgrowth.ui.home.reward

import android.arch.lifecycle.ViewModel
import com.alexandre.potentialgrowth.data.ContributionRepo

/**
 * View Model for the reward tab, contains lavel of reward for each categories ("I have done it" and comment)
 */
class RewardFragmentViewModel(private val repository: ContributionRepo) : ViewModel() {

    var isBronzeDone = repository.isBronzeDone()

    var isSilverDone = repository.isSilverDone()

    var isGoldDone = repository.isGoldDone()

    var isBronzeComment = repository.isBronzeComment()

    var isSilverComment = repository.isSilverComment()

    var isGoldComment = repository.isGoldComment()
}
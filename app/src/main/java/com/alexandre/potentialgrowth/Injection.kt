package com.alexandre.potentialgrowth

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.alexandre.potentialgrowth.data.ContributionRepo
import com.alexandre.potentialgrowth.data.LearnItemRepo
import com.alexandre.potentialgrowth.db.LearnItemDatabase
import com.alexandre.potentialgrowth.ui.knowledgedetail.ViewModelFactoryKnowledgeDetail
import com.alexandre.potentialgrowth.ui.home.knowledge.ViewModelFactoryKnowledge
import java.util.concurrent.Executors

object Injection{

    /**
     * Creates an instance of [GithubRepository] based on the [GithubService] and a
     * [GithubLocalCache]
     */
    private fun provideLearnItemRepo(context: Context): LearnItemRepo {
        val database = LearnItemDatabase.getInstance(context)
        return LearnItemRepo(database.learnItemDao(), Executors.newSingleThreadExecutor())
    }

    private fun provideContributionRepo(context: Context): ContributionRepo {
        val database = LearnItemDatabase.getInstance(context)
        return ContributionRepo(database.contributionDao(), Executors.newSingleThreadExecutor())
    }

    /**
     * Provides the [ViewModelProvider.Factory] that is then used to get a reference to
     * [ViewModel] objects.
     */
    fun provideViewModelFactoryHome(context: Context): ViewModelProvider.Factory {
        return ViewModelFactoryKnowledge(provideLearnItemRepo(context))
    }

    /**
     * Provides the [ViewModelProvider.Factory] that is then used to get a reference to
     * [ViewModel] objects.
     */
    fun provideViewModelFactoryDetail(context: Context, idLearnItem: Long): ViewModelProvider.Factory {
        return ViewModelFactoryKnowledgeDetail(provideLearnItemRepo(context), provideContributionRepo(context), idLearnItem)
    }
}
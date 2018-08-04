package com.alexandre.potentialgrowth

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.alexandre.potentialgrowth.data.ContributionRepo
import com.alexandre.potentialgrowth.data.LearnItemRepo
import com.alexandre.potentialgrowth.db.LearnItemDatabase
import com.alexandre.potentialgrowth.ui.dashboarddetail.ViewModelFactoryDashboardDetail
import com.alexandre.potentialgrowth.ui.home.dashboard.ViewModelFactoryDashboard
import com.alexandre.potentialgrowth.ui.knowledgedetail.ViewModelFactoryKnowledgeDetail
import com.alexandre.potentialgrowth.ui.home.knowledge.ViewModelFactoryKnowledge
import java.util.concurrent.Executors

object Injection{

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

    fun provideViewModelFactoryDashboard(context: Context): ViewModelProvider.Factory {
        return ViewModelFactoryDashboard(provideContributionRepo(context))
    }

    fun provideViewModelFactoryDashboardDetail(context: Context, idTypeLearnItem: Int): ViewModelProvider.Factory {
        return ViewModelFactoryDashboardDetail(provideContributionRepo(context), idTypeLearnItem)
    }
}
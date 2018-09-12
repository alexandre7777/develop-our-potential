package com.alexandre.potentialgrowth

import android.app.Application
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.alexandre.potentialgrowth.data.ContributionRepo
import com.alexandre.potentialgrowth.data.DairyRepo
import com.alexandre.potentialgrowth.data.LearnItemRepo
import com.alexandre.potentialgrowth.data.QuoteRepo
import com.alexandre.potentialgrowth.db.LearnItemDatabase
import com.alexandre.potentialgrowth.ui.dashboarddetail.ViewModelFactoryDashboardDetail
import com.alexandre.potentialgrowth.ui.favorites.ViewModelFactoryFavoritesActivity
import com.alexandre.potentialgrowth.ui.home.dashboard.ViewModelFactoryDashboard
import com.alexandre.potentialgrowth.ui.knowledgedetail.ViewModelFactoryKnowledgeDetail
import com.alexandre.potentialgrowth.ui.home.knowledge.ViewModelFactoryKnowledge
import com.alexandre.potentialgrowth.ui.home.reward.ViewModelFactoryReward
import com.alexandre.potentialgrowth.ui.knowledgedetail.ViewModelFactoryAddDialogComment
import com.alexandre.potentialgrowth.ui.mainactivity.ViewModelFactoryMainActivity
import com.alexandre.potentialgrowth.ui.yourdairy.ViewModelFactoryAddDialog
import com.alexandre.potentialgrowth.ui.yourdairy.ViewModelFactoryYourDairy
import com.alexandre.potentialgrowth.webservice.QuoteService
import java.util.concurrent.Executors

object Injection{

    /**
     * Provides the [LearnItemRepo] that is then used to get a reference to
     * [ViewModelProvider.Factory] objects.
     */
    private fun provideLearnItemRepo(context: Context): LearnItemRepo {
        val database = LearnItemDatabase.getInstance(context)
        return LearnItemRepo(database.learnItemDao(), Executors.newSingleThreadExecutor())
    }

    /**
     * Provides the [ContributionRepo] that is then used to get a reference to
     * [ViewModelProvider.Factory] objects.
     */
    private fun provideContributionRepo(context: Context): ContributionRepo {
        val database = LearnItemDatabase.getInstance(context)
        return ContributionRepo(database.contributionDao(), Executors.newSingleThreadExecutor())
    }

    /**
     * Provides the [DairyRepo] that is then used to get a reference to
     * [ViewModelProvider.Factory] objects.
     */
    private fun provideDairyRepo(context: Context): DairyRepo {
        val database = LearnItemDatabase.getInstance(context)
        return DairyRepo(database.dairyDao(), Executors.newSingleThreadExecutor())
    }

    /**
     * Provides the [QuoteRepo] that is then used to get a reference to
     * [ViewModelProvider.Factory] objects.
     */
    private fun provideQuoteRepo(context: Context): QuoteRepo {
        val database = LearnItemDatabase.getInstance(context)
        return QuoteRepo(QuoteService.create(), database.quoteDao(), Executors.newSingleThreadExecutor())
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

    /**
     * Provides the [ViewModelProvider.Factory] that is then used to get a reference to
     * [ViewModel] objects.
     */
    fun provideViewModelFactoryDashboard(context: Context): ViewModelProvider.Factory {
        return ViewModelFactoryDashboard(provideContributionRepo(context))
    }

    /**
     * Provides the [ViewModelProvider.Factory] that is then used to get a reference to
     * [ViewModel] objects.
     */
    fun provideViewModelFactoryDashboardDetail(context: Context, idTypeLearnItem: Int): ViewModelProvider.Factory {
        return ViewModelFactoryDashboardDetail(provideContributionRepo(context), idTypeLearnItem)
    }

    /**
     * Provides the [ViewModelProvider.Factory] that is then used to get a reference to
     * [ViewModel] objects.
     */
    fun provideViewModelFactoryReward(context: Context): ViewModelProvider.Factory {
        return ViewModelFactoryReward(provideContributionRepo(context))
    }

    /**
     * Provides the [ViewModelProvider.Factory] that is then used to get a reference to
     * [ViewModel] objects.
     */
    fun provideViewModelFactoryAddDialog(context: Context): ViewModelProvider.Factory {
        return ViewModelFactoryAddDialog(provideDairyRepo(context))
    }

    /**
     * Provides the [ViewModelProvider.Factory] that is then used to get a reference to
     * [ViewModel] objects.
     */
    fun provideViewModelFactoryYourDairy(context: Context): ViewModelProvider.Factory {
        return ViewModelFactoryYourDairy(provideDairyRepo(context))
    }

    /**
     * Provides the [ViewModelProvider.Factory] that is then used to get a reference to
     * [ViewModel] objects.
     */
    fun provideViewModelFactoryFavorites(context: Context): ViewModelProvider.Factory {
        return ViewModelFactoryFavoritesActivity(provideLearnItemRepo(context))
    }

    /**
     * Provides the [ViewModelProvider.Factory] that is then used to get a reference to
     * [ViewModel] objects.
     */
    fun provideViewModelFactoryAddDialogComment(context: Context): ViewModelProvider.Factory {
        return ViewModelFactoryAddDialogComment(provideContributionRepo(context))
    }

    /**
     * Provides the [ViewModelProvider.Factory] that is then used to get a reference to
     * [ViewModel] objects.
     */
    fun provideViewModelFactoryMainActivity(context: Context, application: Application): ViewModelProvider.Factory {
        return ViewModelFactoryMainActivity(provideQuoteRepo(context), application)
    }
}
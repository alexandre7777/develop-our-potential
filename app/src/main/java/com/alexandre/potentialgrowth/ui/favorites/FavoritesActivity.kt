package com.alexandre.potentialgrowth.ui.favorites

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v4.util.Pair
import android.view.View
import com.alexandre.potentialgrowth.Injection
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.ui.MainActivity
import com.alexandre.potentialgrowth.ui.commonlearnitemlist.LearnItemAdapter
import com.alexandre.potentialgrowth.ui.knowledgedetail.KnowledgeDetailActivity
import kotlinx.android.synthetic.main.activity_favorites.*
import android.support.design.widget.Snackbar
import com.alexandre.potentialgrowth.model.LearnItemWithContribution

/**
 * Activity to display a list of favorites
 */
class FavoritesActivity : MainActivity() {

    private lateinit var viewModelFavorites: FavoritesActivityViewModel

    public val INTENT_DETAIL_EXTRA = "intentdetailextrakey"

    private var adapter = LearnItemAdapter({ view: View?, learnItem: LearnItemWithContribution ->
        val intent = Intent(this, KnowledgeDetailActivity::class.java).apply {
            putExtra(INTENT_DETAIL_EXTRA, learnItem.idLearnItem)
        }

        val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                // Now we provide a list of Pair items which contain the view we can transitioning
                // from, and the name of the view it is transitioning to, in the launched activity
                Pair<View, String>(view?.findViewById(R.id.img),
                        KnowledgeDetailActivity().VIEW_NAME_TYPE_IMAGE),
                Pair<View, String>(view?.findViewById(R.id.container),
                        KnowledgeDetailActivity().VIEW_NAME_CONTAINER_BACKGROUND),
                Pair<View, String>(view?.findViewById(R.id.name),
                        KnowledgeDetailActivity().VIEW_NAME_TEXT_TITLE),
                Pair<View, String>(findViewById(R.id.appBarLayout),
                        KnowledgeDetailActivity().VIEW_NAME_APPBARLAYOUT),
                Pair<View, String>(view?.findViewById(R.id.description),
                        KnowledgeDetailActivity().VIEW_NAME_TEXT_DESCRIPTION))


        ActivityCompat.startActivity(this, intent, activityOptions.toBundle())

    }, { view: View?, learnItem: LearnItemWithContribution ->
        viewModelFavorites.updateFav(learnItem)

        val snackbar = Snackbar
                .make(list, resources.getString(R.string.favorite_deleted), Snackbar.LENGTH_LONG)
                .setAction(resources.getString(R.string.undo)) {
                    viewModelFavorites.cancelDeleteFav()
                }

        snackbar.show()
    })


    override fun onCreate(savedInstanceState: Bundle?) {

        setContentView(R.layout.activity_favorites)

        super.onCreate(savedInstanceState)

        nav_view.menu.getItem(3).isChecked = true

        viewModelFavorites = ViewModelProviders.of(this, Injection.provideViewModelFactoryFavorites(this))
                .get(FavoritesActivityViewModel::class.java)

        initAdapter()
    }

    /**
     * adapter initialisation with a grid layout and data to observe
     */
    private fun initAdapter(){
        list.layoutManager = LinearLayoutManager(applicationContext)
        list.adapter = adapter


        viewModelFavorites.mFavLearnItem.observe(this, Observer<List<LearnItemWithContribution>> {
            adapter.submitList(it)
        })
    }
}
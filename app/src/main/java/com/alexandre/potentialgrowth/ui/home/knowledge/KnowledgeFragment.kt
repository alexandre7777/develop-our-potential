package com.alexandre.potentialgrowth.ui.home.knowledge

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v4.app.Fragment;
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.widget.GridLayoutManager
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.alexandre.potentialgrowth.Injection
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.model.LearnItem
import com.alexandre.potentialgrowth.ui.commonlearnitemlist.LearnItemAdapter
import com.alexandre.potentialgrowth.ui.knowledgedetail.KnowledgeDetailActivity
import kotlinx.android.synthetic.main.fragment_knowledge.*

/**
 * This fragment display the list of item to learn
 */
class KnowledgeFragment : Fragment(){

    public val INTENT_DETAIL_EXTRA = "intentdetailextrakey"

    private lateinit var viewModel: KnowledgeFragmentViewModel

    private val adapter = LearnItemAdapter( { view: View?, learnItem: LearnItem ->
        val intent = Intent(activity, KnowledgeDetailActivity::class.java).apply {
            putExtra(INTENT_DETAIL_EXTRA, learnItem.idLearnItem)
        }

        val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                activity as Activity,

                // Now we provide a list of Pair items which contain the view we can transitioning
                // from, and the name of the view it is transitioning to, in the launched activity
                Pair<View, String>(view?.findViewById(R.id.img),
                        KnowledgeDetailActivity().VIEW_NAME_TYPE_IMAGE),
                Pair<View, String>(view?.findViewById(R.id.container),
                        KnowledgeDetailActivity().VIEW_NAME_CONTAINER_BACKGROUND),
                Pair<View, String>(view?.findViewById(R.id.name),
                        KnowledgeDetailActivity().VIEW_NAME_TEXT_TITLE),
                Pair<View, String>(activity?.findViewById(R.id.appBarLayout),
                        KnowledgeDetailActivity().VIEW_NAME_APPBARLAYOUT),
                Pair<View, String>(view?.findViewById(R.id.description),
                        KnowledgeDetailActivity().VIEW_NAME_TEXT_DESCRIPTION))



        ActivityCompat.startActivity(activity as Activity, intent, activityOptions.toBundle())
    }, {
        view: View?, learnItem: LearnItem ->
        viewModel.updateFav(learnItem)
    })

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_knowledge, container, false)

        // get the view model
        viewModel = ViewModelProviders.of(this, Injection.provideViewModelFactoryHome(activity!!))
                .get(KnowledgeFragmentViewModel::class.java)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initAdapter()
    }


    /**
     * adapter initialisation with a grid layout and data to observe
     */
    private fun initAdapter(){
        list.layoutManager = GridLayoutManager(activity?.applicationContext, 2)
        list.adapter = adapter


        viewModel.mLearnItem.observe(this, Observer<List<LearnItem>> {
            adapter.submitList(it)
        })
    }
}
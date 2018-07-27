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
import android.util.Log
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.alexandre.potentialgrowth.Injection
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.model.LearnItem
import com.alexandre.potentialgrowth.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_knowledge.*


class KnowledgeFragment : Fragment(){

    public val INTENT_DETAIL_EXTRA = "intentdetailextrakey"

    private lateinit var viewModel: KnowledgeFragmentViewModel

    private val adapter = LearnItemAdapter() { view: View?, learnItem: LearnItem ->
        val intent = Intent(activity, DetailActivity::class.java).apply {
            putExtra(INTENT_DETAIL_EXTRA, learnItem.idLearnItem)
        }

        val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                activity as Activity,

                // Now we provide a list of Pair items which contain the view we can transitioning
                // from, and the name of the view it is transitioning to, in the launched activity
                Pair<View, String>(view?.findViewById(R.id.img),
                        DetailActivity().VIEW_NAME_TYPE_IMAGE),
                Pair<View, String>(view?.findViewById(R.id.container),
                        DetailActivity().VIEW_NAME_CONTAINER_BACKGROUND),
                Pair<View, String>(view?.findViewById(R.id.name),
                        DetailActivity().VIEW_NAME_TEXT_TITLE),
                Pair<View, String>(activity?.findViewById(R.id.appBarLayout),
                        DetailActivity().VIEW_NAME_APPBARLAYOUT),
                Pair<View, String>(view?.findViewById(R.id.description),
                        DetailActivity().VIEW_NAME_TEXT_DESCRIPTION))



        ActivityCompat.startActivity(activity as Activity, intent, activityOptions.toBundle())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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


    private fun initAdapter(){
        list.layoutManager = GridLayoutManager(activity?.applicationContext, 2)
        list.adapter = adapter


        viewModel.mLearnItem.observe(this, Observer<List<LearnItem>> {
            Log.d("Activity", "list: ${it?.size}")
            adapter.submitList(it)
        })
    }
}
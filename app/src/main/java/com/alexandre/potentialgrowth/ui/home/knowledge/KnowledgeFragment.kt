package com.alexandre.potentialgrowth.ui.home.knowledge

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v4.app.Fragment;
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
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

    private val adapter = LearnItemAdapter() {
        val intent = Intent(activity, DetailActivity::class.java).apply {
            putExtra(INTENT_DETAIL_EXTRA, it.idLearnItem)
        }
        startActivity(intent)
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
        list.layoutManager = LinearLayoutManager(activity?.applicationContext)
        list.adapter = adapter


        viewModel.mLearnItem.observe(this, Observer<List<LearnItem>> {
            Log.d("Activity", "list: ${it?.size}")
            adapter.submitList(it)
        })
    }
}
package com.alexandre.potentialgrowth.ui.home.reward

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alexandre.potentialgrowth.Injection
import com.alexandre.potentialgrowth.R
import kotlinx.android.synthetic.main.fragment_reward.*

class RewardFragment : Fragment(){

    private lateinit var viewModelReward: RewardFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        viewModelReward = ViewModelProviders.of(this, Injection.provideViewModelFactoryReward(activity!!))
                .get(RewardFragmentViewModel::class.java)


        viewModelReward.isBronzeDone.observe(this, Observer<Boolean> {it ->
            if(it != null && it){
                doneBronze.setImageDrawable(resources.getDrawable(R.drawable.done_bronze, null))
            }
            else
            {
                doneBronze.setImageDrawable(resources.getDrawable(R.drawable.done_disable, null))
            }
        })

        viewModelReward.isSilverDone.observe(this, Observer<Boolean> {it ->
            if(it != null && it){
                doneSilver.setImageDrawable(resources.getDrawable(R.drawable.done_silver, null))
            }
            else
            {
                doneSilver.setImageDrawable(resources.getDrawable(R.drawable.done_disable, null))
            }
        })

        viewModelReward.isGoldDone.observe(this, Observer<Boolean> {it ->
            if(it != null && it){
                doneGold.setImageDrawable(resources.getDrawable(R.drawable.done_gold, null))
            }
            else
            {
                doneGold.setImageDrawable(resources.getDrawable(R.drawable.done_disable, null))
            }
        })

        viewModelReward.isBronzeComment.observe(this, Observer<Boolean> {it ->
            if(it != null && it){
                commentBronze.setImageDrawable(resources.getDrawable(R.drawable.comment_bronze, null))
            }
            else
            {
                commentBronze.setImageDrawable(resources.getDrawable(R.drawable.comment_disable, null))
            }
        })

        viewModelReward.isSilverComment.observe(this, Observer<Boolean> {it ->
            if(it != null && it){
                commentSilver.setImageDrawable(resources.getDrawable(R.drawable.comment_silver, null))
            }
            else
            {
                commentSilver.setImageDrawable(resources.getDrawable(R.drawable.comment_disable, null))
            }
        })

        viewModelReward.isGoldComment.observe(this, Observer<Boolean> {it ->
            if(it != null && it){
                commentGold.setImageDrawable(resources.getDrawable(R.drawable.comment_gold, null))
            }
            else
            {
                commentGold.setImageDrawable(resources.getDrawable(R.drawable.comment_disable, null))
            }
        })

        return inflater.inflate(R.layout.fragment_reward, container, false)
    }
}
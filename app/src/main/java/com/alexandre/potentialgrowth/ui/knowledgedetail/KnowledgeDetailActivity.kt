package com.alexandre.potentialgrowth.ui.knowledgedetail

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.alexandre.potentialgrowth.Injection
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.model.Contribution
import com.alexandre.potentialgrowth.model.LearnItem
import com.alexandre.potentialgrowth.ui.home.knowledge.KnowledgeFragment
import kotlinx.android.synthetic.main.activity_knowledge_detail.*

class KnowledgeDetailActivity : AppCompatActivity() {

    private lateinit var viewModelKnowledge: KnowledgeDetailActivityViewModel

    public val VIEW_NAME_TYPE_IMAGE = "detail:type:image"

    public val VIEW_NAME_CONTAINER_BACKGROUND = "detail:container:backgound"

    public val VIEW_NAME_TEXT_TITLE = "detail:text:title"

    public val VIEW_NAME_TEXT_DESCRIPTION = "detail:text:description"

    public val VIEW_NAME_APPBARLAYOUT = "detail:nav:appbarlayout"

    private val adapter = CommentAdapter() { view: View?, learnItem: Contribution -> }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_knowledge_detail)

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        ViewCompat.setTransitionName(name, VIEW_NAME_TEXT_TITLE)
        ViewCompat.setTransitionName(description, VIEW_NAME_TEXT_DESCRIPTION)
        ViewCompat.setTransitionName(img, VIEW_NAME_TYPE_IMAGE)
        ViewCompat.setTransitionName(container, VIEW_NAME_CONTAINER_BACKGROUND)
        ViewCompat.setTransitionName(appBarLayout, VIEW_NAME_APPBARLAYOUT)

        val id = intent.getLongExtra(KnowledgeFragment().INTENT_DETAIL_EXTRA, 1)

        viewModelKnowledge = ViewModelProviders.of(this, Injection.provideViewModelFactoryDetail(this, id))
                .get(KnowledgeDetailActivityViewModel::class.java)


        viewModelKnowledge.learnItem.observe(this, Observer<LearnItem> {
            name.text = viewModelKnowledge.learnItem.value?.name

            description.text = viewModelKnowledge.learnItem.value?.description

            img.setImageDrawable(viewModelKnowledge.learnItem.value?.getDrawable(img.context))

            viewModelKnowledge.learnItem.value?.getColor(container.context)?.let { color ->
                container.setBackgroundColor(color)
                nestedScroll.setBackgroundColor(color)
                doneBtn.setTextColor(color)
            }

            viewModelKnowledge.learnItem.value?.getTextColor(container.context)?.let { textColor ->
                name.setTextColor(textColor)
                description.setTextColor(textColor)
                congratulationTxt.setTextColor(textColor)
            }

            viewModelKnowledge.learnItem.value?.getOppositeColor(container.context)?.let { color ->
                doneBtn.setBackgroundColor(color)
            }

            doneBtn.setOnClickListener({
                viewModelKnowledge.insertContribution(viewModelKnowledge.learnItem.value?.idLearnItem)
            })

            commentBtn.setOnClickListener({
                viewModelKnowledge.commentContribution(viewModelKnowledge.learnItem.value?.idLearnItem, commentEd.text.toString())
            })
        })

        viewModelKnowledge.doneItNum.observe(this, Observer<Int> {
            if (it == 0) {
                doneBtn.visibility = View.VISIBLE
                congratulationTxt.visibility = View.GONE
            } else {
                doneBtn.visibility = View.GONE
                congratulationTxt.visibility = View.VISIBLE
            }
        })

        initAdapter()
    }

    private fun initAdapter() {
        commentRl.layoutManager = LinearLayoutManager(applicationContext)
        commentRl.adapter = adapter

        viewModelKnowledge.commentList.observe(this, Observer<List<Contribution>> {
            adapter.submitList(it)
        })
    }
}
package com.alexandre.potentialgrowth.ui.knowledgedetail

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.res.ColorStateList
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.text.Html
import android.view.View
import com.alexandre.potentialgrowth.Injection
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.model.Contribution
import com.alexandre.potentialgrowth.model.LearnItem
import com.alexandre.potentialgrowth.ui.home.knowledge.KnowledgeFragment
import kotlinx.android.synthetic.main.activity_knowledge_detail.*

/**
 * Activity to display detail of a specific item to learn
 */
class KnowledgeDetailActivity : AppCompatActivity() {

    private lateinit var viewModelKnowledge: KnowledgeDetailActivityViewModel

    val VIEW_NAME_TYPE_IMAGE = "detail:type:image"

    val VIEW_NAME_CONTAINER_BACKGROUND = "detail:container:backgound"

    val VIEW_NAME_TEXT_TITLE = "detail:text:title"

    val VIEW_NAME_TEXT_DESCRIPTION = "detail:text:description"

    val VIEW_NAME_APPBARLAYOUT = "detail:nav:appbarlayout"

    private val adapter = CommentAdapter() { view: View?, learnItem: Contribution -> }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_knowledge_detail)

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val id = intent.getLongExtra(KnowledgeFragment().INTENT_DETAIL_EXTRA, 1)

        viewModelKnowledge = ViewModelProviders.of(this, Injection.provideViewModelFactoryDetail(this, id))
                .get(KnowledgeDetailActivityViewModel::class.java)

        viewModelKnowledge.learnItem.observe(this, Observer<LearnItem> {
            name.text = viewModelKnowledge.learnItem.value?.name

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                description.text = Html.fromHtml(viewModelKnowledge.learnItem.value?.description, Html.FROM_HTML_MODE_LEGACY)
            }
            else
            {
                description.text = Html.fromHtml(viewModelKnowledge.learnItem.value?.description)
            }

            img.setImageDrawable(viewModelKnowledge.learnItem.value?.getDrawable(img.context))

            imgFav.setImageDrawable(viewModelKnowledge.learnItem.value?.getFavDrawable(img.context))

            viewModelKnowledge.learnItem.value?.getColor(container.context)?.let { color ->
                container.setBackgroundColor(color)
                nestedScroll.setBackgroundColor(color)
            }

            viewModelKnowledge.learnItem.value?.getTextColor(container.context)?.let { textColor ->
                name.setTextColor(textColor)
                description.setTextColor(textColor)
                congratulationTxt.setTextColor(textColor)
                adapter.color = textColor
                initAdapter()
            }

            viewModelKnowledge.learnItem.value?.getOppositeColor(container.context)?.let { color ->
                doneBtn.setBackgroundColor(color)
                fab.backgroundTintList = ColorStateList.valueOf(color)
            }

            doneBtn.setOnClickListener{
                viewModelKnowledge.insertContribution(viewModelKnowledge.learnItem.value?.idLearnItem)
            }

            imgFav.setOnClickListener {
                viewModelKnowledge.updateFav(viewModelKnowledge.learnItem.value)
            }

            initFAB(viewModelKnowledge.learnItem.value)
        })

        viewModelKnowledge.doneItNum.observe(this, Observer<Int> {
            if (it == 0) {
                doneBtn.visibility = View.VISIBLE
                congratulationTxt.visibility = View.GONE
            } else {
                doneBtn.visibility = View.INVISIBLE
                congratulationTxt.visibility = View.VISIBLE
            }
        })
    }

    /**
     * List of comment adapter initialisation
     */
    private fun initAdapter() {
        commentRl.layoutManager = LinearLayoutManager(applicationContext)
        commentRl.adapter = adapter

        viewModelKnowledge.commentList.observe(this, Observer<List<Contribution>> {
            adapter.submitList(it)
        })
    }

    private fun initFAB(learnItem: LearnItem?) {
        fab.setOnClickListener{
            val addDialogFragment = learnItem?.let { it1 -> AddDialogCommentFragment().newInstance(it1) }
            addDialogFragment?.show(supportFragmentManager, "Add")
        }
    }
}
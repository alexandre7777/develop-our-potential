package com.alexandre.potentialgrowth.ui.knowledgedetail

import android.app.AlertDialog
import android.support.v4.app.DialogFragment
import android.app.Dialog
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.widget.*
import com.alexandre.potentialgrowth.Injection
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.model.LearnItem
import com.alexandre.potentialgrowth.model.UtilLearnItem

/**
 * Dialog fragment to create one comment
 */
class AddDialogCommentFragment : DialogFragment() {

    private lateinit var viewModelAddDialog: AddDialogCommentFragmentViewModel

    private val DESCRIBABLE_KEY = "describable_key"
    private lateinit var learnItem: LearnItem

    fun newInstance(learnItem: LearnItem): AddDialogCommentFragment {
        val fragment = AddDialogCommentFragment()
        val bundle = Bundle()
        bundle.putSerializable(DESCRIBABLE_KEY, learnItem)
        fragment.arguments = bundle

        return fragment
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        learnItem = arguments?.getSerializable(DESCRIBABLE_KEY) as LearnItem

        viewModelAddDialog = ViewModelProviders.of(this, Injection.provideViewModelFactoryAddDialogComment(activity!!))
                .get(AddDialogCommentFragmentViewModel::class.java)

        // Use the Builder class for convenient dialog construction
        val builder = AlertDialog.Builder(activity)

        // Get the layout inflater
        val inflater = activity?.layoutInflater

        val dialogView = inflater?.inflate(R.layout.dialog_add_comment, null)

        val backgroundDialog : ConstraintLayout? = dialogView?.findViewById(R.id.backgroundDialog)

        val textView : TextView? = dialogView?.findViewById(R.id.textView)

        val editText : EditText? = dialogView?.findViewById(R.id.editText)

        val addBtn : Button? = dialogView?.findViewById(R.id.addBtn)

        addBtn?.setOnClickListener {
            viewModelAddDialog.commentContribution(learnItem.idLearnItem, editText?.text.toString())
            dismiss()
        }

        context?.let { UtilLearnItem.getColor(it, learnItem.idType) }?.let { backgroundDialog?.setBackgroundColor(it) }

        context?.let { UtilLearnItem.getTextColor(it, learnItem.idType) }?.let { textView?.setTextColor(it) }

        context?.let { UtilLearnItem.getOppositeColor(it, learnItem.idType) }?.let { addBtn?.setBackgroundColor(it) }

        builder.setView(dialogView)
        // Create the AlertDialog object and return it
        return builder.create()
    }
}
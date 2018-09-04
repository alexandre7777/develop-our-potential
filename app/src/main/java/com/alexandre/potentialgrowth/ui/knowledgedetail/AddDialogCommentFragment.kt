package com.alexandre.potentialgrowth.ui.knowledgedetail

import android.app.AlertDialog
import android.support.v4.app.DialogFragment
import android.app.Dialog
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.widget.*
import com.alexandre.potentialgrowth.Injection
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.model.LearnItem

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

        val editText : EditText? = dialogView?.findViewById(R.id.editText)

        val addBtn : Button? = dialogView?.findViewById(R.id.addBtn)

        addBtn?.setOnClickListener {
            viewModelAddDialog.commentContribution(learnItem.idLearnItem, editText?.text.toString())
            dismiss()
        }

        builder.setView(dialogView)
        // Create the AlertDialog object and return it
        return builder.create()
    }
}
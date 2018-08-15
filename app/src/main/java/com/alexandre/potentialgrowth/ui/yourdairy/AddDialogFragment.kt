package com.alexandre.potentialgrowth.ui.yourdairy

import android.app.AlertDialog
import android.support.v4.app.DialogFragment
import android.app.Dialog
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.widget.*
import com.alexandre.potentialgrowth.Injection
import com.alexandre.potentialgrowth.R

/**
 * Dialog fragment to create one dairy entry
 */
class AddDialogFragment : DialogFragment() {

    private lateinit var viewModelAddDialog: AddDialogFragmentViewModel

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        viewModelAddDialog = ViewModelProviders.of(this, Injection.provideViewModelFactoryAddDialog(activity!!))
                .get(AddDialogFragmentViewModel::class.java)

        // Use the Builder class for convenient dialog construction
        val builder = AlertDialog.Builder(activity)

        // Get the layout inflater
        val inflater = activity?.layoutInflater


        val dialogView = inflater?.inflate(R.layout.dialog_add, null)

        val editText : EditText? = dialogView?.findViewById(R.id.editText)
        val typeRadioGroup : RadioGroup? = dialogView?.findViewById(R.id.typeRadioGroup)

        val addBtn : Button? = dialogView?.findViewById(R.id.addBtn)

        addBtn?.setOnClickListener() {
            if(typeRadioGroup != null) {
                val radioButton : RadioButton? = dialogView?.findViewById(typeRadioGroup.checkedRadioButtonId)

                val id = when(radioButton?.text.toString())
                {
                    resources.getString(R.string.goals) -> 1
                    resources.getString(R.string.stories) -> 2
                    resources.getString(R.string.ideas) -> 3
                    else -> 0
                }

                if(id == 0)
                {
                    val toast = Toast.makeText(context?.applicationContext,
                            resources.getString(R.string.error_dairy_topic), Toast.LENGTH_LONG)
                    toast.show()
                }
                else if(editText?.text.toString().isEmpty())
                {
                    val toast = Toast.makeText(context?.applicationContext,
                            resources.getString(R.string.error_dairy_empty_text), Toast.LENGTH_LONG)
                    toast.show()
                }
                else
                {
                    viewModelAddDialog.insertDairy(editText?.text.toString(), id)
                    dismiss()
                }
            }
        }

        builder.setView(dialogView)
        // Create the AlertDialog object and return it
        return builder.create()
    }
}
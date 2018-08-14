package com.alexandre.potentialgrowth.ui.yourdairy

import android.app.AlertDialog
import android.support.v4.app.DialogFragment
import android.content.DialogInterface
import android.app.Dialog
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import com.alexandre.potentialgrowth.Injection
import com.alexandre.potentialgrowth.R
import kotlinx.android.synthetic.main.dialog_add.*
import android.widget.RadioButton




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

        builder.setView(dialogView)
                .setPositiveButton(R.string.add, DialogInterface.OnClickListener { dialog, id ->

                    if(typeRadioGroup != null) {
                        val radioButton = dialogView.findViewById(typeRadioGroup.checkedRadioButtonId) as RadioButton

                        val id = when(radioButton.text.toString())
                        {
                            resources.getString(R.string.goals) -> 1
                            resources.getString(R.string.stories) -> 2
                            resources.getString(R.string.ideas) -> 3
                            else -> 0
                        }

                        viewModelAddDialog.insertDairy(editText?.text.toString(), id)
                    }
                })
                .setNegativeButton(R.string.cancel, DialogInterface.OnClickListener { dialog, id ->

                })
        // Create the AlertDialog object and return it
        return builder.create()
    }
}
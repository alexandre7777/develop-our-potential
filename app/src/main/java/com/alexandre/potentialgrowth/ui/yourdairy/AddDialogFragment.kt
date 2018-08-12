package com.alexandre.potentialgrowth.ui.yourdairy

import android.app.AlertDialog
import android.support.v4.app.DialogFragment
import android.content.DialogInterface
import android.app.Dialog
import android.os.Bundle
import com.alexandre.potentialgrowth.R


class AddDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Use the Builder class for convenient dialog construction
        val builder = AlertDialog.Builder(activity)

        // Get the layout inflater
        val inflater = activity?.layoutInflater

        builder.setView(inflater?.inflate(R.layout.dialog_add, null))
                .setPositiveButton(R.string.add, DialogInterface.OnClickListener { dialog, id ->

                })
                .setNegativeButton(R.string.cancel, DialogInterface.OnClickListener { dialog, id ->

                })
        // Create the AlertDialog object and return it
        return builder.create()
    }
}
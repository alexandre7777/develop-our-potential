package com.alexandre.potentialgrowth.ui.instruction

import android.view.ViewGroup
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import com.alexandre.potentialgrowth.R


class InstructionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(
                R.layout.fragment_instruction, container, false) as ViewGroup
    }
}
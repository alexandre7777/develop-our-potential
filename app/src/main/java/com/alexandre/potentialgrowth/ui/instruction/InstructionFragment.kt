package com.alexandre.potentialgrowth.ui.instruction

import android.view.ViewGroup
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.alexandre.potentialgrowth.R


class InstructionFragment : Fragment() {

    fun newInstance(position: Int): InstructionFragment {
        val instructionFragment = InstructionFragment()

        val args = Bundle()
        args.putInt("position", position)
        instructionFragment.arguments = args

        return instructionFragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(
                R.layout.fragment_instruction, container, false) as ViewGroup

        val imgTuto: ImageView = view.findViewById(R.id.imgTuto)
        val textTuto: TextView = view.findViewById(R.id.textTuto)

        val position = arguments?.getInt("position", 0)

        when(position){
            0-> {
                imgTuto.setImageDrawable(context?.getDrawable(R.drawable.tuto1))
                textTuto.text = context?.getText(R.string.tuto1)
            }
            1-> {
                imgTuto.setImageDrawable(context?.getDrawable(R.drawable.tuto2))
                textTuto.text = context?.getText(R.string.tuto2)
            }
            2-> {
                imgTuto.setImageDrawable(context?.getDrawable(R.drawable.tuto3))
                textTuto.text = context?.getText(R.string.tuto3)
            }
            3-> {
                imgTuto.setImageDrawable(context?.getDrawable(R.drawable.tuto4))
                textTuto.text = context?.getText(R.string.tuto4)
            }
            4-> {
                imgTuto.setImageDrawable(context?.getDrawable(R.drawable.tuto5))
                textTuto.text = context?.getText(R.string.tuto5)
            }
        }
        return view
    }
}
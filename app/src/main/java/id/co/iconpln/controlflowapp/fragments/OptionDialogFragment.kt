package id.co.iconpln.controlflowapp.fragments


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.fragment_option_dialog.*

/**
 * A simple [Fragment] subclass.
 */
class OptionDialogFragment : DialogFragment(), View.OnClickListener {

    companion object {
        val TAG: String = OptionDialogFragment::class.java.simpleName
    }

    private var optionsDialogListener: OnOptionsDialogListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnDialogChoose.setOnClickListener(this)
        btnDialogClose.setOnClickListener(this)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val parentFragment = parentFragment
        if (parentFragment is LastFragment) {
            val lastFragment = parentFragment
            this.optionsDialogListener = lastFragment.optionDialogListener
        }
    }

    override fun onDetach() {
        super.onDetach()
        this.optionsDialogListener = null
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.btnDialogChoose -> {
                val checkedRadioButtonId = rgDialogOptions.checkedRadioButtonId
                if (checkedRadioButtonId != -1) {
                    var favColor = ""
                    when (checkedRadioButtonId) {
                        R.id.rbDialogBlue -> {
                            favColor = rbDialogBlue.text.toString().trim()
                        }
                        R.id.rbDialogRed -> {
                            favColor = rbDialogRed.text.toString().trim()
                        }
                        R.id.rbDialogPurple -> {
                            favColor = rbDialogPurple.text.toString().trim()
                        }
                        R.id.rbDialogGreen -> {
                            favColor = rbDialogGreen.text.toString().trim()
                        }
                    }
                    Log.d(TAG, "color $favColor")
                    if (optionsDialogListener != null) {
                        optionsDialogListener?.onOptionChosen(favColor)
                    }
                    dialog?.dismiss()
                }
            }
            R.id.btnDialogClose -> {
                dialog?.cancel()
            }
        }
    }

    interface OnOptionsDialogListener {
        fun onOptionChosen(text: String)
    }

}

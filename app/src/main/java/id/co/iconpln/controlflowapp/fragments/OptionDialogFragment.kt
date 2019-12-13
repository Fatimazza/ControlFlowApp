package id.co.iconpln.controlflowapp.fragments


import android.os.Bundle
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

    override fun onClick(view: View) {
        when(view.id) {
            R.id.btnDialogChoose -> {

            }
            R.id.btnDialogClose -> {
                dialog.cancel()
            }
        }
    }

}

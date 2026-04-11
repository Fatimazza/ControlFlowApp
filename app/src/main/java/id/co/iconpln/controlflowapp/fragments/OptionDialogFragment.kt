package id.co.iconpln.controlflowapp.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import id.co.iconpln.controlflowapp.databinding.FragmentOptionDialogBinding

/**
 * A simple [Fragment] subclass.
 */
class OptionDialogFragment : DialogFragment(), View.OnClickListener {

    private var _binding: FragmentOptionDialogBinding? = null
    private val binding get() = _binding!!

    companion object {
        val TAG: String = OptionDialogFragment::class.java.simpleName
    }

    private var optionsDialogListener: OnOptionsDialogListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOptionDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnDialogChoose.setOnClickListener(this)
        binding.btnDialogClose.setOnClickListener(this)
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
        when (view) {
            binding.btnDialogChoose -> {
                val checkedRadioButtonId = binding.rgDialogOptions.checkedRadioButtonId
                if (checkedRadioButtonId != -1) {
                    var favColor = ""
                    when (checkedRadioButtonId) {
                        binding.rbDialogBlue.id -> {
                            favColor = binding.rbDialogBlue.text.toString().trim()
                        }

                        binding.rbDialogRed.id -> {
                            favColor = binding.rbDialogRed.text.toString().trim()
                        }

                        binding.rbDialogPurple.id -> {
                            favColor = binding.rbDialogPurple.text.toString().trim()
                        }

                        binding.rbDialogGreen.id -> {
                            favColor = binding.rbDialogGreen.text.toString().trim()
                        }
                    }
                    Log.d(TAG, "color $favColor")
                    if (optionsDialogListener != null) {
                        optionsDialogListener?.onOptionChosen(favColor)
                    }
                    dialog?.dismiss()
                }
            }

            binding.btnDialogClose -> {
                dialog?.cancel()
            }
        }
    }

    interface OnOptionsDialogListener {
        fun onOptionChosen(text: String)
    }
}

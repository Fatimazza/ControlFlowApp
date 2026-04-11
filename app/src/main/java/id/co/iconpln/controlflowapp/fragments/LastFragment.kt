package id.co.iconpln.controlflowapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import id.co.iconpln.controlflowapp.StyleActivity
import id.co.iconpln.controlflowapp.databinding.FragmentLastBinding

/**
 * A simple [Fragment] subclass.
 */
class LastFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentLastBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val EXTRA_NAME_FRAGMENT = "extra_name_fragment"
        var message: String = ""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLastBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnOtherActivity.setOnClickListener(this)
        binding.btnShowDialog.setOnClickListener(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val name = arguments?.getString(EXTRA_NAME_FRAGMENT)
        binding.tvLastName.text = name
        binding.tvLastMessage.text = message
    }

    override fun onClick(view: View) {
        when (view) {
            binding.btnOtherActivity -> {
                val styleActivity = Intent(requireContext(), StyleActivity::class.java)
                startActivity(styleActivity)
            }

            binding.btnShowDialog -> {
                val fragmentManager = childFragmentManager
                val optionDialogFragment = OptionDialogFragment()

                optionDialogFragment.show(
                    fragmentManager, OptionDialogFragment::class.java.simpleName
                )
            }
        }
    }

    var optionDialogListener: OptionDialogFragment.OnOptionsDialogListener =
        object : OptionDialogFragment.OnOptionsDialogListener {
            override fun onOptionChosen(text: String) {
                Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
            }
        }

    // Clean up binding to prevent memory leaks
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

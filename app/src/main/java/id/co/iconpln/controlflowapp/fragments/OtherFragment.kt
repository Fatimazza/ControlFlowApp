package id.co.iconpln.controlflowapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.databinding.FragmentOtherBinding
import id.co.iconpln.controlflowapp.fragments.LastFragment.Companion.message

/**
 * A simple [Fragment] subclass.
 */
class OtherFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentOtherBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOtherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLastFragment.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnLastFragment -> {
                val fragmentManager = fragmentManager
                val fragmentTransaction = fragmentManager?.beginTransaction()

                val fragment = LastFragment()

                val bundle = Bundle()
                bundle.putString(LastFragment.EXTRA_NAME_FRAGMENT, "Hi, Izza!")
                val hiddenMessage = "My Message: This is Last Message"

                fragment.apply {
                    arguments = bundle
                    message = hiddenMessage
                }

                fragmentTransaction?.replace(R.id.flContainer, fragment)
                fragmentTransaction?.addToBackStack(null)
                fragmentTransaction?.commit()
            }
        }
    }

    // Clean up binding to prevent memory leaks
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

package id.co.iconpln.controlflowapp.fragmentsNavComponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import id.co.iconpln.controlflowapp.databinding.FragmentOtherNavBinding

class OtherNavFragment : Fragment() {

    private var _binding: FragmentOtherNavBinding? = null
    private val binding get() = _binding!!

    companion object {
        val EXTRA_NAME = "extra_name"
        val EXTRA_DESC = "extra_desc"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOtherNavBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLastFragment.setOnClickListener { view ->
            val toLastNavFragment = OtherNavFragmentDirections.actionOtherNavFragmentToLastNavFragment()
            toLastNavFragment.name = "Hi, Izza"
            toLastNavFragment.desc = 33
            view.findNavController().navigate(toLastNavFragment)
        }
    }

    // Clean up binding to prevent memory leaks
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

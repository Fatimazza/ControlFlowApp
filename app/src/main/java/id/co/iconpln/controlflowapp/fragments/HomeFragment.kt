package id.co.iconpln.controlflowapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnOtherFragment.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view) {
            binding.btnOtherFragment -> {
                val fragmentManager = parentFragmentManager
                val fragment = OtherFragment()
                fragmentManager.commit {
                    addToBackStack(null)
                    replace(R.id.flContainer, fragment, OtherFragment::class.java.simpleName)
                }
            }
        }
    }
    
    // Clean up binding to prevent memory leaks
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

package id.co.iconpln.controlflowapp.fragmentsNavComponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.databinding.FragmentHomeNavBinding


class HomeNavFragment : Fragment() {

    private var _binding: FragmentHomeNavBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeNavBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnOtherFragment.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.action_homeFragment_to_otherNavFragment
            )
        )
        binding.btnOtherActivity.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_homeFragment_to_styleActivity)
        }
    }

    // Clean up binding to prevent memory leaks
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

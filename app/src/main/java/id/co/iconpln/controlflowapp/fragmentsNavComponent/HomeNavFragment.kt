package id.co.iconpln.controlflowapp.fragmentsNavComponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    // Clean up binding to prevent memory leaks
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

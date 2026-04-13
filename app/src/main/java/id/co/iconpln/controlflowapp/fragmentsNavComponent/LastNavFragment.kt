package id.co.iconpln.controlflowapp.fragmentsNavComponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.iconpln.controlflowapp.databinding.FragmentLastNavBinding

class LastNavFragment : Fragment() {

    private var _binding: FragmentLastNavBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLastNavBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataName = LastNavFragmentArgs.fromBundle(arguments as Bundle).name
        val dataDescription = LastNavFragmentArgs.fromBundle(arguments as Bundle).desc

        binding.tvLastName.text = dataName
        binding.tvLastDescription.text = "Age: $dataDescription"
    }

    // Clean up binding to prevent memory leaks
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

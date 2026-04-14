package id.co.iconpln.controlflowapp.fragmentTab


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.databinding.FragmentTabBinding


class TabFragment : Fragment() {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.menu_list_hero,
            R.string.tab_text_2
        )
    }

    private var _binding: FragmentTabBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTabBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupTab()

        (activity as AppCompatActivity).supportActionBar?.elevation = 0f
    }

    private fun setupTab() {
        val sectionsPagerAdapter = SectionsPagerAdapter(requireActivity() as AppCompatActivity)
        binding.vpTabFragment.adapter = sectionsPagerAdapter
        TabLayoutMediator(
            binding.tabFragment, binding.vpTabFragment
        )
        { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

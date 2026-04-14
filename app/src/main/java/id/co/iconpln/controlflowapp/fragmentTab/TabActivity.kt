package id.co.iconpln.controlflowapp.fragmentTab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import com.google.android.material.tabs.TabLayoutMediator
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.databinding.ActivityTabBinding

class TabActivity : AppCompatActivity() {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.menu_list_hero,
            R.string.tab_text_2
        )
    }

    private lateinit var binding: ActivityTabBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTabBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupTab()
    }

    private fun setupTab() {
        val sectionsPagerAdapter = SectionsPagerAdapter(this)

        binding.vpTab.adapter = sectionsPagerAdapter
        TabLayoutMediator(
            binding.tab, binding.vpTab
        )
        { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        supportActionBar?.elevation = 0f
    }
}

package id.co.iconpln.controlflowapp.contactFragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import com.google.android.material.tabs.TabLayoutMediator
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.databinding.ActivityContactTabBinding

class ContactTabActivity : AppCompatActivity() {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_contact,
            R.string.tab_text_2
        )
    }

    private lateinit var binding: ActivityContactTabBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContactTabBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupTab()
    }

    private fun setupTab() {
        val sectionsPagerAdapter = ContactSectionsPagerAdapter(this)

        binding.vpTabContact.adapter = sectionsPagerAdapter
        TabLayoutMediator(
            binding.tabContact, binding.vpTabContact
        )
        { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        supportActionBar?.elevation = 0f
    }
}

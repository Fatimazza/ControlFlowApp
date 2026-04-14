package id.co.iconpln.controlflowapp.contactFragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.iconpln.controlflowapp.databinding.ActivityContactTabBinding

class ContactTabActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactTabBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContactTabBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupTab()
    }

    private fun setupTab() {
        val tabPagerAdapter = ContactTabPagerAdapter(this, supportFragmentManager)
        binding.vpTabContact.adapter = tabPagerAdapter
        binding.tabContact.setupWithViewPager(binding.vpTabContact)

        supportActionBar?.elevation = 0f
    }
}

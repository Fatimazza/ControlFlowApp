package id.co.iconpln.controlflowapp.fragmentTab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.iconpln.controlflowapp.databinding.ActivityTabBinding

class TabActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTabBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTabBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupTab()
    }

    private fun setupTab() {
        val tabPagerAdapter = TabPagerAdapter(this, supportFragmentManager)
        binding.vpTab.adapter = tabPagerAdapter
        binding.tab.setupWithViewPager(binding.vpTab)

        supportActionBar?.elevation = 0f
    }
}

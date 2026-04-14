package id.co.iconpln.controlflowapp.fragmentViewPager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import id.co.iconpln.controlflowapp.databinding.ActivityScrollBinding

class ScrollActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSlideViewPager()
    }

    private fun setupSlideViewPager() {
        val pagerAdapter = ScrollSectionsPagerAdapter(this)
        binding.vpScroll.adapter = pagerAdapter
        TabLayoutMediator(
            binding.tabScrollDots, binding.vpScroll
        ) { tab, position -> }.attach()

        // Using Library
        // pageIndicatorScroll.setViewPager(vpScroll)
    }

    override fun onBackPressed() {
        if (binding.vpScroll.currentItem == 0) {
            super.onBackPressed()
        } else {
            binding.vpScroll.currentItem = binding.vpScroll.currentItem - 1
        }
    }
}

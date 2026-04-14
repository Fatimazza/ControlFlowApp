package id.co.iconpln.controlflowapp.fragmentViewPager

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import id.co.iconpln.controlflowapp.databinding.ActivityScrollBinding

class ScrollActivity : FragmentActivity() {

    private lateinit var binding: ActivityScrollBinding

    private lateinit var pagerAdapter: ScrollPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSlideViewPager()
    }

    private fun setupSlideViewPager() {
        pagerAdapter = ScrollPagerAdapter(supportFragmentManager)
        binding.vpScroll.adapter = pagerAdapter
        binding.tabScrollDots.setupWithViewPager(binding.vpScroll)

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

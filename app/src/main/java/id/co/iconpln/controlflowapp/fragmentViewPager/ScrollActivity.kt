package id.co.iconpln.controlflowapp.fragmentViewPager

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_scroll.*

class ScrollActivity : FragmentActivity() {

    private lateinit var pagerAdapter: ScrollPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll)

        setupSlideViewPager()
    }

    private fun setupSlideViewPager() {
        pagerAdapter = ScrollPagerAdapter(supportFragmentManager)
        vpScroll.adapter = pagerAdapter
        tabScrollDots.setupWithViewPager(vpScroll)
    }

    override fun onBackPressed() {
        if (vpScroll.currentItem == 0) {
            super.onBackPressed()
        } else {
            vpScroll.currentItem = vpScroll.currentItem - 1
        }
    }
}

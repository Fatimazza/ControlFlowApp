package id.co.iconpln.controlflowapp.fragmentViewPager

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_scroll.*

class ScrollActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll)

        setupSlideViewPager()
    }

    private fun setupSlideViewPager() {
        val pagerAdapter = ScrollPagerAdapter(supportFragmentManager)
        vpScroll.adapter = pagerAdapter
    }
}

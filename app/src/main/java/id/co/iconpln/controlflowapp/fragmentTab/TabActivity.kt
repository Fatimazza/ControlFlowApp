package id.co.iconpln.controlflowapp.fragmentTab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_tab.*

class TabActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)

        setupTab()
    }

    private fun setupTab() {
        val tabPagerAdapter = TabPagerAdapter(this, supportFragmentManager)
        vpTab.adapter = tabPagerAdapter
        tab.setupWithViewPager(vpTab)

        supportActionBar?.elevation = 0f
    }
}

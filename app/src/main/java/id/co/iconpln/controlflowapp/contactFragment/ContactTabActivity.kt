package id.co.iconpln.controlflowapp.contactFragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_contact_tab.*

class ContactTabActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_tab)

        setupTab()
    }

    private fun setupTab() {
        val tabPagerAdapter = ContactTabPagerAdapter(this, supportFragmentManager)
        vpTabContact.adapter = tabPagerAdapter
        tabContact.setupWithViewPager(vpTabContact)

        supportActionBar?.elevation = 0f
    }
}

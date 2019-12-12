package id.co.iconpln.controlflowapp.tab

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import id.co.iconpln.controlflowapp.fragments.HomeFragment
import id.co.iconpln.controlflowapp.fragments.OtherFragment

class TabPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm) {
    
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = HomeFragment()
            1 -> fragment = OtherFragment()
        }
        return fragment as Fragment
    }

    override fun getCount(): Int {
        return 2
    }

}

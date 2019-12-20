package id.co.iconpln.controlflowapp.fragmentViewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import id.co.iconpln.controlflowapp.fragmentTab.FirstFragment
import id.co.iconpln.controlflowapp.fragmentTab.SecondFragment

class ScrollPagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm) {

    companion object {
        private const val NUM_PAGES = 3
    }

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = FirstFragment()
            1 -> fragment = SecondFragment()
            2 -> fragment = ScrollFragment()
        }
        return fragment as Fragment
    }

    override fun getCount(): Int {
        return NUM_PAGES
    }

}

package id.co.iconpln.controlflowapp.fragmentViewPager

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import id.co.iconpln.controlflowapp.fragmentTab.FirstFragment
import id.co.iconpln.controlflowapp.fragmentTab.SecondFragment

class ScrollSectionsPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    companion object {
        private const val NUM_PAGES = 3
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = FirstFragment()
            1 -> fragment = SecondFragment()
            2 -> fragment = ScrollFragment()
        }
        return fragment as Fragment
    }

    override fun getItemCount(): Int {
        return NUM_PAGES
    }
}

package id.co.iconpln.controlflowapp.fragmentTab

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import id.co.iconpln.controlflowapp.hero.ListHeroFragment

class SectionsPagerAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {
    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = ListHeroFragment()
            1 -> fragment = SecondFragment()
        }
        return fragment as Fragment
    }

    override fun getItemCount(): Int {
        return 2
    }
}

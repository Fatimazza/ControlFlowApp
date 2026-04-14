package id.co.iconpln.controlflowapp.contactFragment

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import id.co.iconpln.controlflowapp.fragmentTab.SecondFragment
import id.co.iconpln.controlflowapp.hero.ListHeroFragment

class ContactSectionsPagerAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {
    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = ContactFragment()
            1 -> fragment = SecondFragment()
        }
        return fragment as Fragment
    }

    override fun getItemCount(): Int {
        return 2
    }
}

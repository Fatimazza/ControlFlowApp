package id.co.iconpln.controlflowapp.fragmentBottomNav

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.databinding.ActivityBottomNavBinding
import id.co.iconpln.controlflowapp.fragmentTab.FirstFragment
import id.co.iconpln.controlflowapp.fragmentTab.TabFragment
import id.co.iconpln.controlflowapp.hero.ListHeroFragment

class BottomNavActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNav()
        binding.navView.selectedItemId = R.id.navigation_first
    }

    private fun setupBottomNav() {
        binding.navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_first -> {
                    loadFragment(FirstFragment())
                    true
                }
                R.id.navigation_second -> {
                    loadFragment(ListHeroFragment())
                    true
                }
                R.id.navigation_third -> {
                    loadFragment(TabFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.flNavContainer, fragment, fragment::class.java.simpleName)
            .commit()
    }
}

package id.co.iconpln.controlflowapp.fragmentBottomNav

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
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
        binding.navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    private val onNavigationItemSelectedListener =
        object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.navigation_first -> {
                        loadFragment(FirstFragment())
                        return true
                    }

                    R.id.navigation_second -> {
                        loadFragment(ListHeroFragment())
                        return true
                    }

                    R.id.navigation_third -> {
                        loadFragment(TabFragment())
                        return true
                    }
                }
                return false
            }
        }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.flNavContainer, fragment, fragment::class.java.simpleName)
            .commit()
    }
}

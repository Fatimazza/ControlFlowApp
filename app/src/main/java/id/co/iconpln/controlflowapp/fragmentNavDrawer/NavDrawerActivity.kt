package id.co.iconpln.controlflowapp.fragmentNavDrawer

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.forEach
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.StyleActivity
import id.co.iconpln.controlflowapp.databinding.ActivityNavDrawerBinding
import id.co.iconpln.controlflowapp.fragmentTab.FirstFragment
import id.co.iconpln.controlflowapp.fragmentTab.SecondFragment
import id.co.iconpln.controlflowapp.hero.ListHeroFragment

class NavDrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityNavDrawerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupActionBar()
        binding.navViewDrawer.setNavigationItemSelectedListener(this)
        selectFirstNavigationMenu()
    }

    private fun selectFirstNavigationMenu() {
        binding.navViewDrawer.menu.performIdentifierAction(R.id.nav_home, 0)
    }

    private fun setupActionBar() {
        val toolbar = binding.appBarMain.toolbar
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, binding.dlDrawerLayout, toolbar, R.string.app_name, 0
        )
        binding.dlDrawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                loadFragment(FirstFragment())
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_profile -> {
                loadFragment(ListHeroFragment())
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_gallery -> {
                Toast.makeText(this, "Gallery", Toast.LENGTH_SHORT).show()
                val openActivityIntent = Intent(this, StyleActivity::class.java)
                startActivity(openActivityIntent)
            }

            R.id.nav_update -> {
                loadFragment(SecondFragment())
            }

            R.id.nav_logout -> {
                finish()
            }
        }

        uncheckItemMenu()
        item.isChecked = true

        title = item.title
        binding.dlDrawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun uncheckItemMenu() {
        val menu = binding.navViewDrawer.menu
        menu.forEach { item ->
            item.isChecked = false

            item.subMenu?.forEach { subItem ->
                subItem.isChecked = false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.flDrawerContent, fragment, fragment::class.java.simpleName)
            .commit()
    }
}

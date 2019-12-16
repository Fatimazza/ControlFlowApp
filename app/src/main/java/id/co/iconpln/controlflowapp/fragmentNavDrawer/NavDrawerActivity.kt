package id.co.iconpln.controlflowapp.fragmentNavDrawer

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.StyleActivity
import id.co.iconpln.controlflowapp.fragmentTab.FirstFragment
import id.co.iconpln.controlflowapp.fragmentTab.SecondFragment
import kotlinx.android.synthetic.main.activity_nav_drawer.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class NavDrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_drawer)

        setupActionBar()
        navViewDrawer.setNavigationItemSelectedListener(this)
    }

    private fun setupActionBar() {
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, dlDrawerLayout, toolbar, R.string.app_name, 0
        )
        dlDrawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_home -> {
                loadFragment(FirstFragment())
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_profile -> {
                loadFragment(SecondFragment())
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_gallery -> {
                Toast.makeText(this, "Gallery", Toast.LENGTH_SHORT).show()
                val openActivityIntent = Intent(this, StyleActivity::class.java)
                startActivity(openActivityIntent)
            }
        }

        uncheckItemMenu()
        item.isChecked = true

        title = item.title
        dlDrawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun uncheckItemMenu() {
        for (countMenu in 0 until navViewDrawer.menu.size()) {
            navViewDrawer.menu.getItem(countMenu).isChecked = false

            if (navViewDrawer.menu.getItem(countMenu).hasSubMenu()) {
                for (countSubmenu in 0 until navViewDrawer.menu.getItem(countMenu).subMenu.size()) {
                    navViewDrawer.menu.getItem(countMenu).subMenu.getItem(countSubmenu).isChecked = false
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.flDrawerContent, fragment, fragment::class.java.simpleName)
            .commit()
    }
}

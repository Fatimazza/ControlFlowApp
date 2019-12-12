package id.co.iconpln.controlflowapp.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.iconpln.controlflowapp.R

class DemoFragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_fragment)

        initFragment()
    }

    private fun initFragment() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val fragment = HomeFragment()
        fragmentTransaction.add(R.id.flContainer, fragment)
        fragmentTransaction.commit()
    }
}

package id.co.iconpln.controlflowapp.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.iconpln.controlflowapp.databinding.ActivityDemoFragmentBinding

class DemoFragmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDemoFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDemoFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initFragment()
    }

    private fun initFragment() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val fragment = HomeFragment()
        fragmentTransaction.add(binding.flContainer.id, fragment)
        fragmentTransaction.commit()
    }
}

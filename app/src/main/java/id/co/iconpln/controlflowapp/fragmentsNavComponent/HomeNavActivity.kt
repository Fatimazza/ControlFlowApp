package id.co.iconpln.controlflowapp.fragmentsNavComponent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.co.iconpln.controlflowapp.databinding.ActivityHomeNavBinding

class HomeNavActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initFragment()
    }

    private fun initFragment() {
        val fragment = HomeNavFragment()
        supportFragmentManager.beginTransaction()
            .add(binding.flContainer.id, fragment)
            .commit()
    }
}

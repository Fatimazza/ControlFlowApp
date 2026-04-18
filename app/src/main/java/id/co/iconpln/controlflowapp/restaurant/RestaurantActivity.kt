package id.co.iconpln.controlflowapp.restaurant

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.co.iconpln.controlflowapp.databinding.ActivityRestaurantBinding

class RestaurantActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRestaurantBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}

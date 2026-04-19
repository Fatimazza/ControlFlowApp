package id.co.iconpln.controlflowapp.restaurant

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.iconpln.controlflowapp.databinding.ActivityRestaurantBinding

class RestaurantActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRestaurantBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        setupReviewRecyclerView()
    }

    private fun setupReviewRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        binding.rvReview.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvReview.addItemDecoration(itemDecoration)
    }
}

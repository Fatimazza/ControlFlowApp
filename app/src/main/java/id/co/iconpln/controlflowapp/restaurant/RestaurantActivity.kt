package id.co.iconpln.controlflowapp.restaurant

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.iconpln.controlflowapp.databinding.ActivityRestaurantBinding
import id.co.iconpln.controlflowapp.network.NetworkConfig
import id.co.iconpln.controlflowapp.restaurant.data.response.RestaurantResponse
import retrofit2.Callback

class RestaurantActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRestaurantBinding

    companion object {
        private const val TAG = "MainActivity"
        private const val RESTAURANT_ID = "uewq1zg2zlskfw1e867"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        setupReviewRecyclerView()
        findRestaurant()
    }

    private fun setupReviewRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        binding.rvReview.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvReview.addItemDecoration(itemDecoration)
    }

    private fun findRestaurant() {
        showLoading(true)

        val client = NetworkConfig.restaurantApi().getRestaurant(RESTAURANT_ID)
        client.enqueue(object : Callback<RestaurantResponse>{

        })
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}

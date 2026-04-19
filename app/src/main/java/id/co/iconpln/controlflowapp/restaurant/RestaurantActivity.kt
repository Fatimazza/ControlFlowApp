package id.co.iconpln.controlflowapp.restaurant

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import id.co.iconpln.controlflowapp.databinding.ActivityRestaurantBinding
import id.co.iconpln.controlflowapp.network.NetworkConfig
import id.co.iconpln.controlflowapp.restaurant.data.response.CustomerReviewsItem
import id.co.iconpln.controlflowapp.restaurant.data.response.Restaurant
import id.co.iconpln.controlflowapp.restaurant.data.response.RestaurantResponse
import id.co.iconpln.controlflowapp.restaurant.ui.RestaurantReviewAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestaurantActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRestaurantBinding

    companion object {
        private const val TAG = "RestaurantActivity"
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
        client.enqueue(object : Callback<RestaurantResponse> {

            override fun onResponse(
                call: Call<RestaurantResponse?>,
                response: Response<RestaurantResponse?>
            ) {
                showLoading(false)
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        setRestaurantData(responseBody.restaurant)
                        setReviewData(responseBody.restaurant.customerReviews)
                    }
                }
                else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(
                call: Call<RestaurantResponse?>,
                t: Throwable
            ) {
                showLoading(false)
                Log.e(TAG, "onFailure: ${t.message}")
            }
            
        })
    }

    private fun setRestaurantData(restaurant: Restaurant) {
        binding.tvTitle.text = restaurant.name
        binding.tvDescription.text = restaurant.description
        Glide.with(this)
            .load("https://restaurant-api.dicoding.dev/images/large/${restaurant.pictureId}")
            .into(binding.ivPicture)
    }
    private fun setReviewData(consumerReviews: List<CustomerReviewsItem>) {
        val adapter = RestaurantReviewAdapter()
        adapter.submitList(consumerReviews)
        binding.rvReview.adapter = adapter
        binding.edReview.setText("")
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}

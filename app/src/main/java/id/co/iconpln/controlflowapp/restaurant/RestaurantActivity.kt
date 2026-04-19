package id.co.iconpln.controlflowapp.restaurant

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import id.co.iconpln.controlflowapp.databinding.ActivityRestaurantBinding
import id.co.iconpln.controlflowapp.network.NetworkConfig
import id.co.iconpln.controlflowapp.restaurant.data.response.CustomerReviewsItem
import id.co.iconpln.controlflowapp.restaurant.data.response.PostReviewResponse
import id.co.iconpln.controlflowapp.restaurant.data.response.Restaurant
import id.co.iconpln.controlflowapp.restaurant.ui.RestaurantReviewAdapter
import id.co.iconpln.controlflowapp.restaurant.ui.RestaurantViewModel
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

        val restaurantViewModel = ViewModelProvider(
            this, ViewModelProvider.NewInstanceFactory()).get(RestaurantViewModel::class.java)
        restaurantViewModel.restaurant.observe(this) { restaurant ->
            setRestaurantData(restaurant)
        }

        binding.btnSend.setOnClickListener { view ->
            postReview(binding.edReview.text.toString())
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    private fun setupReviewRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        binding.rvReview.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvReview.addItemDecoration(itemDecoration)
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

    private fun postReview(review: String) {
        showLoading(true)

        val client = NetworkConfig.restaurantApi().postReview(RESTAURANT_ID, "Dico.ding", review)
        client.enqueue(object : Callback<PostReviewResponse> {

            override fun onResponse(
                call: Call<PostReviewResponse?>,
                response: Response<PostReviewResponse?>
            ) {
                showLoading(false)
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    setReviewData(responseBody.customerReviews)
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(
                call: Call<PostReviewResponse?>,
                t: Throwable
            ) {
                showLoading(false)
                Log.e(TAG, "onFailure: ${t.message}")
            }
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

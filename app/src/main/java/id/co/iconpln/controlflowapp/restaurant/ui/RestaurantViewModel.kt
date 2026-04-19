package id.co.iconpln.controlflowapp.restaurant.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.co.iconpln.controlflowapp.network.NetworkConfig
import id.co.iconpln.controlflowapp.restaurant.data.response.CustomerReviewsItem
import id.co.iconpln.controlflowapp.restaurant.data.response.Restaurant
import id.co.iconpln.controlflowapp.restaurant.data.response.RestaurantResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestaurantViewModel : ViewModel() {

    companion object {
        private const val TAG = "RestaurantViewModel"
        private const val RESTAURANT_ID = "uewq1zg2zlskfw1e867"
    }

    private val _restaurant = MutableLiveData<Restaurant>()
    val restaurant: LiveData<Restaurant> = _restaurant

    private val _listReview = MutableLiveData<List<CustomerReviewsItem>>()
    val listReview: LiveData<List<CustomerReviewsItem>> = _listReview

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        findRestaurant()
    }

    private fun findRestaurant() {
        _isLoading.value = true

        val client = NetworkConfig.restaurantApi().getRestaurant(RESTAURANT_ID)
        client.enqueue(object : Callback<RestaurantResponse> {

            override fun onResponse(
                call: Call<RestaurantResponse?>,
                response: Response<RestaurantResponse?>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        _restaurant.value = responseBody?.restaurant
                        _listReview.value = responseBody?.restaurant?.customerReviews
                    }
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(
                call: Call<RestaurantResponse?>,
                t: Throwable
            ) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }
}

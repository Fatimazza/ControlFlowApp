package id.co.iconpln.controlflowapp.restaurant.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.co.iconpln.controlflowapp.restaurant.data.response.CustomerReviewsItem
import id.co.iconpln.controlflowapp.restaurant.data.response.Restaurant

class RestaurantViewModel: ViewModel() {

    companion object{
        private const val TAG = "RestaurantViewModel"
        private const val RESTAURANT_ID = "uewq1zg2zlskfw1e867"
    }

    private val _restaurant = MutableLiveData<Restaurant>()
    val restaurant: LiveData<Restaurant> = _restaurant

    private val _listReview = MutableLiveData<List<CustomerReviewsItem>>()
    val listReview: LiveData<List<CustomerReviewsItem>> = _listReview

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
}

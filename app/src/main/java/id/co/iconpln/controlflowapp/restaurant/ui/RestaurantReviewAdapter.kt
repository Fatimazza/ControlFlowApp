package id.co.iconpln.controlflowapp.restaurant.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import id.co.iconpln.controlflowapp.databinding.ItemReviewBinding
import id.co.iconpln.controlflowapp.restaurant.data.response.CustomerReviewsItem

class RestaurantReviewAdapter(diffCallback: DiffUtil.ItemCallback<CustomerReviewsItem>) :
    ListAdapter<CustomerReviewsItem, RestaurantReviewAdapter.ReviewViewHolder>(diffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReviewViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(
        holder: ReviewViewHolder,
        position: Int
    ) {
        TODO("Not yet implemented")
    }

    class ReviewViewHolder(val binding: ItemReviewBinding): RecyclerView.ViewHolder(binding.root) {

    }
}

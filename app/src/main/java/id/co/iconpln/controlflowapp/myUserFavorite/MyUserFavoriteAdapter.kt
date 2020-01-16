package id.co.iconpln.controlflowapp.myUserFavorite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.database.FavoriteUser
import kotlinx.android.synthetic.main.item_list_contact.view.*

class MyUserFavoriteAdapter : RecyclerView.Adapter<MyUserFavoriteAdapter.MyUserViewHolder>() {

    private var userData = emptyList<FavoriteUser>()

    private lateinit var onItemClickCallback: OnItemClickCallback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyUserViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_contact, parent, false)
        return MyUserViewHolder(mView)
    }

    override fun getItemCount(): Int {
        return userData.size
    }

    override fun onBindViewHolder(holder: MyUserViewHolder, position: Int) {
        holder.bind(userData[position])
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClick(userData[holder.adapterPosition])
        }
    }

    fun setData(userItems: List<FavoriteUser>) {
        val listFavMovie = ArrayList<FavoriteUser>()
        for (i in 0 until userItems.size) {
            listFavMovie.add(userItems[i])
        }
        userData = listFavMovie
        notifyDataSetChanged()
    }

    inner class MyUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(userItem: FavoriteUser) {
            itemView.tvContactName.text = userItem.userName
            itemView.tvContactEmail.text = userItem.userAddress
            itemView.tvContactMobile.text = userItem.userPhone
        }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClick(myUser: FavoriteUser)
    }

}

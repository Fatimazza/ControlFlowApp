package id.co.iconpln.controlflowapp.myUser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.item_list_contact.view.*

class MyUserAdapter : RecyclerView.Adapter<MyUserAdapter.MyUserViewHolder>() {

    private val userData = ArrayList<MyUser>()

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

    fun setData(userItems: ArrayList<MyUser>) {
        userData.clear()
        userData.addAll(userItems)
        notifyDataSetChanged()
    }

    inner class MyUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(userItem: MyUser) {
            itemView.tvContactName.text = userItem.name
            itemView.tvContactEmail.text = userItem.address
            itemView.tvContactMobile.text = userItem.phone
        }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClick(myUser: MyUser)
    }

}

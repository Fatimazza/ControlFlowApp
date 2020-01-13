package id.co.iconpln.controlflowapp.myContact

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.contact.Contact
import kotlinx.android.synthetic.main.item_list_contact.view.*

class MyContactAdapter : RecyclerView.Adapter<MyContactAdapter.MyContactViewHolder>() {

    private val contactData = ArrayList<Contact>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyContactViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_contact, parent, false)
        return MyContactViewHolder(mView)
    }

    override fun getItemCount(): Int {
        return contactData.size
    }

    override fun onBindViewHolder(holder: MyContactViewHolder, position: Int) {
        holder.bind(contactData[position])
    }

    fun setData(contactItems: ArrayList<Contact>) {
        contactData.clear()
        contactData.addAll(contactItems)
        notifyDataSetChanged()
    }

    inner class MyContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(contactItem: Contact) {
            itemView.tvContactName.text = contactItem.name
            itemView.tvContactEmail.text = contactItem.email
            itemView.tvContactMobile.text = contactItem.mobile
        }
    }

}

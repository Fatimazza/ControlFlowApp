package id.co.iconpln.controlflowapp.contact

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.co.iconpln.controlflowapp.databinding.ItemListContactBinding

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    private val contactData = ArrayList<Contact>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = ItemListContactBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ContactViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return contactData.size
    }

    fun setData(contactItems: ArrayList<Contact>) {
        contactData.clear()
        contactData.addAll(contactItems)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val (id, name, email, mobile) = contactData[position]
        holder.binding.tvContactName.text = name
        holder.binding.tvContactEmail.text = email
        holder.binding.tvContactMobile.text = mobile
    }

    class ContactViewHolder(var binding: ItemListContactBinding) :
        RecyclerView.ViewHolder(binding.root)
}

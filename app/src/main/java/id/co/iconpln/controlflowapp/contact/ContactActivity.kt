package id.co.iconpln.controlflowapp.contact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.iconpln.controlflowapp.databinding.ActivityContactBinding

class ContactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactBinding

    private lateinit var adapter: ContactAdapter

    private lateinit var contactViewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        showListContact()
        contactViewModel.setContact()
        fetchContactData()
    }

    private fun initViewModel() {
        contactViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(ContactViewModel::class.java)
    }

    private fun fetchContactData() {
        //get value from View Model's Live Data
        contactViewModel.getContact().observe(this, Observer { contactItem ->
            if (contactItem != null) {
                adapter.setData(contactItem)
                // showLoading(false)
            }
        })
    }

    private fun showListContact() {
        adapter = ContactAdapter()
        adapter.notifyDataSetChanged()

        binding.rvContactList.layoutManager = LinearLayoutManager(this)
        binding.rvContactList.adapter = adapter
    }
}

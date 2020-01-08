package id.co.iconpln.controlflowapp.contact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_contact.*

class ContactActivity : AppCompatActivity() {

    private lateinit var adapter: ContactAdapter

    private lateinit var contactViewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        initViewModel()
        showListContact()
    }

    private fun initViewModel() {
        contactViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(ContactViewModel::class.java)
    }

    private fun showListContact() {
        adapter = ContactAdapter()
        adapter.notifyDataSetChanged()

        rvContactList.layoutManager = LinearLayoutManager(this)
        rvContactList.adapter = adapter
    }
}

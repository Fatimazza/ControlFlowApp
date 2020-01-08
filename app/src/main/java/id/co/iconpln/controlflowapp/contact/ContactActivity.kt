package id.co.iconpln.controlflowapp.contact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_contact.*

class ContactActivity : AppCompatActivity() {

    private lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        showListContact()
    }

    private fun showListContact() {
        adapter = ContactAdapter()
        adapter.notifyDataSetChanged()

        rvContactList.layoutManager = LinearLayoutManager(this)
        rvContactList.adapter = adapter
    }
}

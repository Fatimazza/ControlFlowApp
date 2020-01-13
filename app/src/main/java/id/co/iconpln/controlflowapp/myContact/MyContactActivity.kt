package id.co.iconpln.controlflowapp.myContact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_my_contact.*

class MyContactActivity : AppCompatActivity() {

    private lateinit var adapter: MyContactAdapter

    private lateinit var viewModel: MyContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_contact)

        initViewModel()
        showListContact()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(MyContactViewModel::class.java)
    }

    private fun showListContact() {
        adapter = MyContactAdapter()
        adapter.notifyDataSetChanged()

        rvMyContactList.layoutManager = LinearLayoutManager(this)
        rvMyContactList.adapter = adapter
    }
}

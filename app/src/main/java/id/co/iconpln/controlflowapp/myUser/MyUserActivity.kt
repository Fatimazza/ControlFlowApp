package id.co.iconpln.controlflowapp.myUser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.model.myUser.UserDataResponse
import kotlinx.android.synthetic.main.activity_my_user.*

class MyUserActivity : AppCompatActivity() {

    private lateinit var viewModel: MyUserViewModel

    private lateinit var adapter: MyUserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_user)

        initViewModel()
        showListUser()
        addListClickListener()

        fetchUserData()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(MyUserViewModel::class.java)
    }

    private fun showListUser() {
        adapter = MyUserAdapter()
        adapter.notifyDataSetChanged()

        rvMyUserList.layoutManager = LinearLayoutManager(this)
        rvMyUserList.adapter = adapter
    }

    private fun fetchUserData() {
        //get value from View Model's Live Data
        viewModel.getListUsers().observe(this, Observer { contactItem ->
            if (contactItem != null) {
                adapter.setData(contactItem)
                // showLoading(false)
            }
        })
    }

    private fun addListClickListener() {
        adapter.setOnItemClickCallback(object : MyUserAdapter.OnItemClickCallback {
            override fun onItemClick(myUser: UserDataResponse) {
                Toast.makeText(this@MyUserActivity, "You choose ${myUser.name}", Toast.LENGTH_SHORT).show()
                openUserForm(myUser)
            }
        })
    }

    private fun openUserForm(myUser: UserDataResponse) {
        val userFormIntent = Intent(this, MyUserFormActivity::class.java)
        userFormIntent.putExtra(MyUserFormActivity.EXTRA_USER, myUser)
        userFormIntent.putExtra(MyUserFormActivity.EXTRA_USER_ADD, false)
        startActivity(userFormIntent)
    }
}

package id.co.iconpln.controlflowapp.myUser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_my_user.*

private lateinit var adapter: MyUserAdapter

class MyUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_user)

        showListUser()
        addListClickListener()
    }

    private fun showListUser() {
        adapter = MyUserAdapter()
        adapter.notifyDataSetChanged()

        rvMyUserList.layoutManager = LinearLayoutManager(this)
        rvMyUserList.adapter = adapter
    }

    private fun addListClickListener() {
        adapter.setOnItemClickCallback(object : MyUserAdapter.OnItemClickCallback {
            override fun onItemClick(myUser: MyUser) {
                Toast.makeText(this@MyUserActivity, "You choose ${myUser.name}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

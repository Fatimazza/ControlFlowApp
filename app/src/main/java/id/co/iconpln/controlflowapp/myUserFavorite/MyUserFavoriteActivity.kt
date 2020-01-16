package id.co.iconpln.controlflowapp.myUserFavorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.myUser.MyUserAdapter
import kotlinx.android.synthetic.main.activity_my_user_favorite.*

class MyUserFavoriteActivity : AppCompatActivity() {

    private lateinit var adapter: MyUserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_user_favorite)

        setActionBarTitle()
        showListUser()
    }

    private fun setActionBarTitle() {
        supportActionBar?.title = "List Favorite User"
    }

    private fun showListUser() {
        adapter = MyUserAdapter()
        adapter.notifyDataSetChanged()

        rvMyUserFavList.layoutManager = LinearLayoutManager(this)
        rvMyUserFavList.adapter = adapter
    }
}

package id.co.iconpln.controlflowapp.myUserFavorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.database.FavoriteUser
import id.co.iconpln.controlflowapp.database.FavoriteViewModel
import id.co.iconpln.controlflowapp.myUserForm.MyUserFormActivity
import kotlinx.android.synthetic.main.activity_my_user_favorite.*

class MyUserFavoriteActivity : AppCompatActivity() {

    private lateinit var adapter: MyUserFavoriteAdapter

    private lateinit var favoriteViewModel: FavoriteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_user_favorite)

        initViewModel()
        setupActionBar()
        showListUser()
        addListClickListener()
        fetchFavoriteUserData()
    }

    override fun onResume() {
        super.onResume()
        favoriteViewModel.getAllFavoriteUsers()
    }

    private fun setupActionBar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "List Favorite User"
    }

    private fun initViewModel() {
        favoriteViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application))
            .get(FavoriteViewModel::class.java)
    }

    private fun showListUser() {
        adapter = MyUserFavoriteAdapter()
        adapter.notifyDataSetChanged()

        rvMyUserFavList.layoutManager = LinearLayoutManager(this)
        rvMyUserFavList.adapter = adapter
    }

    private fun fetchFavoriteUserData() {
        favoriteViewModel.getAllFavoriteUsers().observe(this, Observer { listFavUser ->
            adapter.setData(listFavUser)
        })
    }

    private fun addListClickListener() {
        adapter.setOnItemClickCallback(object : MyUserFavoriteAdapter.OnItemClickCallback {
            override fun onItemClick(myUser: FavoriteUser) {
                openUserForm(myUser)
            }
        })
    }

    private fun openUserForm(myUser: FavoriteUser) {
        val userFormIntent = Intent(this, MyUserFormActivity::class.java)
        userFormIntent.putExtra(MyUserFormActivity.EXTRA_USER_ID, myUser.userId.toInt())
        userFormIntent.putExtra(MyUserFormActivity.EXTRA_USER_EDIT, true)
        startActivity(userFormIntent)
    }

}

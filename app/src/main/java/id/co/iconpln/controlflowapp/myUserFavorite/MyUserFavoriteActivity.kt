package id.co.iconpln.controlflowapp.myUserFavorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.database.FavoriteViewModel
import kotlinx.android.synthetic.main.activity_my_user_favorite.*

class MyUserFavoriteActivity : AppCompatActivity() {

    private lateinit var adapter: MyUserFavoriteAdapter

    private lateinit var favoriteViewModel: FavoriteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_user_favorite)

        initViewModel()
        setActionBarTitle()
        showListUser()
        fetchFavoriteMovieData()
    }

    private fun setActionBarTitle() {
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

    private fun fetchFavoriteMovieData() {
        favoriteViewModel.getAllFavoriteUsers().observe(this, Observer { listFavUser ->
            if (listFavUser.isNotEmpty()) {
                adapter.setData(listFavUser)
            }
        })
    }

}

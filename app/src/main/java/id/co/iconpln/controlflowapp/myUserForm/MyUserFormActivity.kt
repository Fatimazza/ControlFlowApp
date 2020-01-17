package id.co.iconpln.controlflowapp.myUserForm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.database.FavoriteUser
import id.co.iconpln.controlflowapp.database.FavoriteViewModel
import id.co.iconpln.controlflowapp.model.myUser.UserDataResponse
import kotlinx.android.synthetic.main.activity_my_user_form.*

class MyUserFormActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_USER_EDIT = "extra_user_edit"
        const val EXTRA_USER_ID = "extra_user_id"
    }
    
    private lateinit var viewModel: MyUserFormViewModel

    private lateinit var favoriteViewModel: FavoriteViewModel

    private var userId: Int? = null

    private var isEditUser = false

    private var menuItem: Menu? = null

    private var isFavorite: Boolean = false

    private var favoriteUserId: Long? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_user_form)

        initViewModel()
        initIntentExtra()
        setClickListener()
        checkForm(isEditUser)
    }

    private fun fetchUserData() {
        pbMyUserFormLoading.visibility = View.VISIBLE
        llMyUserFormContent.visibility = View.GONE
        getUser(userId as Int)
    }

    private fun checkForm(editUser: Boolean) {
        if (editUser) {
            fetchUserData()
        } else {
            btnUserFormSave.visibility = View.GONE
            btnUserFormDelete.visibility = View.GONE
            btnUserFormAdd.visibility = View.VISIBLE
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(MyUserFormViewModel::class.java)
        favoriteViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application))
            .get(FavoriteViewModel::class.java)
    }

    private fun setClickListener() {
        btnUserFormSave.setOnClickListener(this)
        btnUserFormDelete.setOnClickListener(this)
        btnUserFormAdd.setOnClickListener(this)
    }

    private fun initIntentExtra() {
        userId = intent.getIntExtra(EXTRA_USER_ID, 0)
        isEditUser = intent.getBooleanExtra(EXTRA_USER_EDIT, false)
    }

    private fun populateFormData(user: UserDataResponse) {
        etUserFormName.setText(user.name)
        etUserFormAddress.setText(user.address)
        etUserFormHp.setText(user.phone)
        btnUserFormSave.visibility = View.VISIBLE
        btnUserFormDelete.visibility = View.VISIBLE
        btnUserFormAdd.visibility = View.GONE
    }

    private fun getUser(userId: Int) {
        viewModel.getUser(userId).observe(this, Observer { userDataResponse ->
            if (userDataResponse != null) {
                Toast.makeText(this, "User loaded Successfully!", Toast.LENGTH_SHORT).show()
                populateFormData(userDataResponse)
                pbMyUserFormLoading.visibility = View.GONE
                llMyUserFormContent.visibility = View.VISIBLE
                setFavorite()
            } else {
                Toast.makeText(this, "Failed to load User", Toast.LENGTH_SHORT).show()
                pbMyUserFormLoading.visibility = View.GONE
            }
        })
    }

    private fun setFavorite() {
        if (userId != null) {
            favoriteViewModel.getUser(userId as Int).observe(this, Observer { favoriteUser ->
                Log.d("Izza", "getUser $favoriteUser")
                isFavorite = favoriteUser != null
                setFavoriteIcon()

                if (favoriteUser != null) {
                    favoriteUserId = favoriteUser.favUserId
                }
            })
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnUserFormSave -> {
                if (userId != null) {
                    val updateUserData = UserDataResponse(
                        etUserFormAddress.text.toString(),
                        userId ?: 0,
                        etUserFormName.text.toString(),
                        etUserFormHp.text.toString()
                    )
                    updateUser(userId as Int, updateUserData)
                }
            }
            R.id.btnUserFormDelete -> {
                if (userId != null) {
                    deleteUser(userId as Int)
                }
            }
            R.id.btnUserFormAdd -> {
                val addUserData = UserDataResponse(
                    etUserFormAddress.text.toString(),
                    userId ?: 0,
                    etUserFormName.text.toString(),
                    etUserFormHp.text.toString()
                )
                addUser(addUserData)
            }
        }
    }

    private fun updateUser(id: Int, userData: UserDataResponse) {
        //get result from View Model's Live Data
        viewModel.updateUser(id, userData).observe(this, Observer { userDataResponse ->
            if (userDataResponse != null) {
                Toast.makeText(this, "User Updated Successfully!", Toast.LENGTH_SHORT).show()
                updateFavoriteUser(userData)
                finish()
            } else {
                Toast.makeText(this, "Failed to update User", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun updateFavoriteUser(userData: UserDataResponse) {
        if (favoriteUserId != null) {
            favoriteViewModel.updateUser(
                FavoriteUser(
                    favoriteUserId as Long,
                    userData.address,
                    userData.id.toString(),
                    userData.name,
                    userData.phone
                )
            )
        }
    }

    private fun deleteUser(id: Int) {
        viewModel.deleteUser(id).observe(this, Observer {userDataResponse ->
            if (userDataResponse != null) {
                Toast.makeText(this, "User Deleted Successfully!", Toast.LENGTH_SHORT).show()
                if (isFavorite) removeFromFavorite()
                finish()
            } else {
                Toast.makeText(this, "Failed to delete User", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun addUser(userData: UserDataResponse) {
        viewModel.createUser(userData).observe(this, Observer { userDataResponse ->
            if (userDataResponse != null) {
                Toast.makeText(this, "User Added Successfully!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Failed to add User", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_myuser_form, menu)
        menuItem = menu
        setFavoriteIcon()

        if (!isEditUser) {
            menu.findItem(R.id.action_favorite).isVisible = false
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_favorite -> {
                if (llMyUserFormContent.visibility == View.GONE) {
                    Toast.makeText(this, "Can't add to Favorite", Toast.LENGTH_SHORT)
                        .show()
                    return false
                }
                isFavorite = !isFavorite
                setFavoriteIcon()
                addOrRemoveFavorite()
                true
            }
            else -> true
        }
    }

    private fun setFavoriteIcon() {
        if (isFavorite)
            menuItem?.getItem(0)?.icon =
                ContextCompat.getDrawable(this, R.drawable.ic_favorite)
        else
            menuItem?.getItem(0)?.icon =
                ContextCompat.getDrawable(this, R.drawable.ic_unfavorite)
    }

    private fun addOrRemoveFavorite() {
        if (isFavorite) {
            addToFavorite()
        } else {
            removeFromFavorite()
        }

        favoriteViewModel.getAllFavoriteUsers().observe(this, Observer { listFavUser ->
            if (listFavUser.isNotEmpty()) {
                for (i in 0 until listFavUser.size) {
                    Log.d("Izza", "" + listFavUser[i].favUserId + listFavUser[i].userName)
                }
            }
        })
    }

    private fun addToFavorite() {
        Toast.makeText(this, "Add to Favorite", Toast.LENGTH_SHORT).show()
        favoriteViewModel.insertUser(
            FavoriteUser(
                0,
                etUserFormAddress.text.toString(),
                userId.toString(),
                etUserFormName.text.toString(),
                etUserFormHp.text.toString()
            )
        )
    }

    private fun removeFromFavorite() {
        if (userId != null) {
            favoriteViewModel.deleteUser(
                userId as Int
            )
        }
        favoriteUserId = null
    }

}

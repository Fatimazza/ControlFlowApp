package id.co.iconpln.controlflowapp.myUserForm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.model.myUser.UserDataResponse
import kotlinx.android.synthetic.main.activity_my_user_form.*

class MyUserFormActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_USER_EDIT = "extra_user_edit"
        const val EXTRA_USER_ID = "extra_user_id"
    }
    
    private lateinit var viewModel: MyUserFormViewModel

    private var userId: Int? = null

    private var isEditUser = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_user_form)

        initViewModel()
        initIntentExtra()
        setClickListener()
        checkForm(isEditUser)
    }

    private fun checkForm(editUser: Boolean) {
        if (editUser) {
            populateFormData(userId as Int)
            btnUserFormSave.visibility = View.VISIBLE
            btnUserFormDelete.visibility = View.VISIBLE
            btnUserFormAdd.visibility = View.GONE
        } else {
            btnUserFormSave.visibility = View.GONE
            btnUserFormDelete.visibility = View.GONE
            btnUserFormAdd.visibility = View.VISIBLE
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(MyUserFormViewModel::class.java)
    }

    private fun setClickListener() {
        btnUserFormSave.setOnClickListener(this)
        btnUserFormDelete.setOnClickListener(this)
        btnUserFormAdd.setOnClickListener(this)
    }

    private fun initIntentExtra() {
        if (intent.hasExtra(EXTRA_USER_ID)) {
            userId = intent.getParcelableExtra(EXTRA_USER_ID)
        } else {
            userId = 0
        }
        isEditUser = intent.getBooleanExtra(EXTRA_USER_EDIT, false)
    }

    private fun populateFormData(userId: Int) {
        /*etUserFormName.setText(user.name)
        etUserFormAddress.setText(user.address)
        etUserFormHp.setText(user.phone)
        userId = user.id*/
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
            } else {
                Toast.makeText(this, "Failed to update User", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun deleteUser(id: Int) {
        viewModel.deleteUser(id).observe(this, Observer {userDataResponse ->
            if (userDataResponse != null) {
                Toast.makeText(this, "User Deleted Successfully!", Toast.LENGTH_SHORT).show()
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
}

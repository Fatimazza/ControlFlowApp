package id.co.iconpln.controlflowapp.myUser

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
        const val EXTRA_USER = "extra_user"
    }

    private lateinit var user: UserDataResponse

    private lateinit var viewModel: MyUserFormViewModel

    private var userId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_user_form)

        initViewModel()
        initIntentExtra()
        setClickListener()
        populateFormData(user)
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(MyUserFormViewModel::class.java)
    }

    private fun setClickListener() {
        btnUserFormSave.setOnClickListener(this)
    }

    private fun initIntentExtra() {
        user = intent.getParcelableExtra(EXTRA_USER)
    }

    private fun populateFormData(user: UserDataResponse) {
        etUserFormName.setText(user.name)
        etUserFormAddress.setText(user.address)
        etUserFormHp.setText(user.phone)
        userId = user.id
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnUserFormSave -> {
                if (userId != null) {
                    updateUser(userId as Int)
                }
            }
        }
    }

    private fun updateUser(id: Int) {
        //get result from View Model's Live Data
        viewModel.updateUser(id).observe(this, Observer { userData ->
            if (userData != null) {
                Toast.makeText(this, "User Updated Successfully!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Failed to update User", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

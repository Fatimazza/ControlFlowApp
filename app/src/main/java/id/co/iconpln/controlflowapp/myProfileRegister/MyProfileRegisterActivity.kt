package id.co.iconpln.controlflowapp.myProfileRegister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.model.myProfile.ProfileRegisterUser

class MyProfileRegisterActivity : AppCompatActivity() {

    private lateinit var viewModel: MyProfileRegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile_register)

        initViewModel()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(MyProfileRegisterViewModel::class.java)
    }

    private fun fetchUserData(profileRegisterUser: ProfileRegisterUser) {
        viewModel.register(profileRegisterUser).observe(this, Observer { registerResponse ->
            if (registerResponse != null) {
                Toast.makeText(
                    this, "Success register ${registerResponse.email}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

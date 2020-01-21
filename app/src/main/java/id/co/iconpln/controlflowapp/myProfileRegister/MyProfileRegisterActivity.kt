package id.co.iconpln.controlflowapp.myProfileRegister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.model.myProfile.ProfileRegisterUser
import kotlinx.android.synthetic.main.activity_my_profile_register.*

class MyProfileRegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewModel: MyProfileRegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile_register)

        initViewModel()

        btnProfileReg.setOnClickListener(this)
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(MyProfileRegisterViewModel::class.java)
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.btnProfileReg -> {
                fetchUserData(
                    ProfileRegisterUser(
                        etProfileRegEmail.text.toString(),
                        etProfileRegPassword.text.toString(),
                        etProfileRegName.text.toString(),
                        etProfileRegHp.text.toString()
                    )
                )
            }
        }
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

package id.co.iconpln.controlflowapp.myProfileLogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.co.iconpln.controlflowapp.MyProfile.MyProfileActivity
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.model.myProfile.ProfileLoginResponse
import id.co.iconpln.controlflowapp.model.myProfile.ProfileLoginUser
import id.co.iconpln.controlflowapp.myProfileRegister.MyProfileRegisterActivity
import kotlinx.android.synthetic.main.activity_my_profile_login.*

class MyProfileLoginActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_PROFILE_RESULT = "extra_profile_result"
        const val RESULT_CODE = 201
    }

    private lateinit var viewModel: MyProfileLoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile_login)

        initViewModel()
        setupActionBar()
        btnProfileLogin.setOnClickListener(this)
        tvProfileLoginReg.setOnClickListener(this)
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(MyProfileLoginViewModel::class.java)
    }

    private fun setupActionBar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "My Profile Login"
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.btnProfileLogin -> {
                fetchUserData(
                    ProfileLoginUser(
                        etProfileLoginEmail.text.toString(),
                        etProfileLoginPassword.text.toString()
                    )
                )
            }
            R.id.tvProfileLoginReg -> {
                val registerIntent = Intent(this, MyProfileRegisterActivity::class.java)
                startActivity(registerIntent)
            }
        }
    }

    private fun fetchUserData(profileLoginUser: ProfileLoginUser) {
        viewModel.login(profileLoginUser).observe(this, Observer { loginResponse ->
            if (loginResponse != null) {
                Toast.makeText(this, "Success login ${loginResponse.customer.email}", Toast.LENGTH_SHORT).show()
                openProfilePage(loginResponse)
            }
        })
    }

    private fun openProfilePage(profileLoginResponse: ProfileLoginResponse) {
        val resultIntent = Intent().putExtra(EXTRA_PROFILE_RESULT, profileLoginResponse)
        setResult(RESULT_CODE, resultIntent)
        finish()
    }
}

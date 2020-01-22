package id.co.iconpln.controlflowapp.MyProfile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.model.myProfile.ProfileLoginResponse
import id.co.iconpln.controlflowapp.model.myProfile.ProfileUser
import id.co.iconpln.controlflowapp.myProfileLogin.MyProfileLoginActivity
import kotlinx.android.synthetic.main.activity_my_profile.*

class MyProfileActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        private const val REQUEST_CODE = 200
    }

    private var profileLoginResponse: ProfileLoginResponse? = null

    private lateinit var profileUserPreference: ProfileUserPreference
    private lateinit var profileUser: ProfileUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        setupActionBar()
        setClickListener()
        showExistingPreference()
    }

    private fun setClickListener() {
        btnProfileToLogin.setOnClickListener(this)
    }

    private fun setupActionBar() {
        supportActionBar?.title = "My Profile"
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnProfileToLogin -> {
                val loginIntent = Intent(this, MyProfileLoginActivity::class.java)
                startActivityForResult(loginIntent, REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == MyProfileLoginActivity.RESULT_CODE) {
                profileLoginResponse = data?.getParcelableExtra(
                    MyProfileLoginActivity.EXTRA_PROFILE_RESULT
                ) as ProfileLoginResponse
                saveProfileUserPreference()
            }
        }
    }

    private fun saveProfileUserPreference() {
        if (profileLoginResponse != null) {
            profileUser.userToken = profileLoginResponse?.token
            profileUserPreference.setProfileUser(profileUser)
            Toast.makeText(this, "Token saved!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showExistingPreference() {
        profileUserPreference = ProfileUserPreference(this)
        profileUser = profileUserPreference.getProfileUser()
    }
}

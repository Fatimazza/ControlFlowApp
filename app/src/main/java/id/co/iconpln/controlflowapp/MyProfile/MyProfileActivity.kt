package id.co.iconpln.controlflowapp.MyProfile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.model.myProfile.ProfileLoginResponse
import id.co.iconpln.controlflowapp.myProfileLogin.MyProfileLoginActivity
import kotlinx.android.synthetic.main.activity_my_profile.*

class MyProfileActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        private const val REQUEST_CODE = 200
    }

    private var profileLoginResponse: ProfileLoginResponse? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        setupActionBar()
        setClickListener()
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
}

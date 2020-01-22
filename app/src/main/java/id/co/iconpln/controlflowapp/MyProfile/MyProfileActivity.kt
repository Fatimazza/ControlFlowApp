package id.co.iconpln.controlflowapp.MyProfile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.model.myProfile.ProfileLoginResponse
import id.co.iconpln.controlflowapp.myProfileLogin.MyProfileLoginActivity
import kotlinx.android.synthetic.main.activity_my_profile.*
import kotlinx.android.synthetic.main.activity_my_profile_login.*

class MyProfileActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_PROFILE = "extra_profile"
    }

    private var profileLoginResponse: ProfileLoginResponse? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        setupActionBar()
        initIntentExtra()
        setClickListener()
    }

    private fun setClickListener() {
        btnProfileToLogin.setOnClickListener(this)
    }

    private fun setupActionBar() {
        supportActionBar?.title = "My Profile"
    }

    private fun initIntentExtra() {
        if (intent.hasExtra(EXTRA_PROFILE)) {
            profileLoginResponse = intent.getParcelableExtra(EXTRA_PROFILE)
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnProfileToLogin -> {
                val loginIntent = Intent(this, MyProfileLoginActivity::class.java)
                startActivity(loginIntent)
            }
        }
    }
}

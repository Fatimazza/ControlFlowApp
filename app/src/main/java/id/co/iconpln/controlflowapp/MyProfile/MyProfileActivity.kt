package id.co.iconpln.controlflowapp.MyProfile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.model.myProfile.ProfileLoginResponse

class MyProfileActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PROFILE = "extra_profile"
    }

    private var profileLoginResponse: ProfileLoginResponse? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        setupActionBar()
        initIntentExtra()
    }

    private fun setupActionBar() {
        supportActionBar?.title = "My Profile"
    }

    private fun initIntentExtra() {
        if (intent.hasExtra(EXTRA_PROFILE)) {
            profileLoginResponse = intent.getParcelableExtra(EXTRA_PROFILE)
        }
    }
}

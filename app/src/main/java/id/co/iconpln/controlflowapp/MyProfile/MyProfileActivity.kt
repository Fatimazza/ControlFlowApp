package id.co.iconpln.controlflowapp.MyProfile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.model.myProfile.ProfileLoginResponse

class MyProfileActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PROFILE = "extra_profile"
    }

    private var profile: ProfileLoginResponse? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        initIntentExtra()
    }

    private fun initIntentExtra() {
        if (intent.hasExtra(EXTRA_PROFILE)) {
            profile = intent.getParcelableExtra(EXTRA_PROFILE)
        }
    }
}

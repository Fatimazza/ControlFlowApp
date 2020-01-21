package id.co.iconpln.controlflowapp.MyProfile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.iconpln.controlflowapp.R

class MyProfileActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PROFILE = "extra_profile"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)
    }
}

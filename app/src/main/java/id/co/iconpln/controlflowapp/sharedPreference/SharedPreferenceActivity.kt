package id.co.iconpln.controlflowapp.sharedPreference

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_shared_preference.*

class SharedPreferenceActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var userPreference: UserPreference
    
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)

        btnPrefSave.setOnClickListener(this)

        supportActionBar?.title = "My User Preference"
        userPreference = UserPreference(this)
        showExistingPreference()
    }

    private fun showExistingPreference() {
        user = userPreference.getUser()
    }


    override fun onClick(view: View) {
        if (view.id == R.id.btnPrefSave) {
            val sharedPrefFormintent = Intent(this, SharedPreferenceFormActivity::class.java)
            startActivity(sharedPrefFormintent)
        }
    }
}

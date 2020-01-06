package id.co.iconpln.controlflowapp.sharedPreference

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_shared_preference.*

class SharedPreferenceActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var userPreference: UserPreference

    private var isPreferenceEmpty = false
    
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
        populateView(user)
        checkForm(user)
    }

    private fun populateView(user: User) {
        tvPrefName.text = if (user.name.toString().isEmpty())
            "Tidak Ada" else user.name
        tvPrefAge.text = if (user.age.toString().isEmpty())
            "Tidak Ada" else user.age.toString()
        tvPrefEmail.text = if (user.email.toString().isEmpty())
            "Tidak Ada" else user.email
        tvPrefHandphone.text = if (user.handphone.toString().isEmpty())
            "Tidak Ada" else user.handphone
        tvPrefHobby.text = if (!user.hasReadingHobby)
            "Tidak Membaca" else "Membaca"
    }

    private fun checkForm(user: User) {
        when {
            user.name.toString().isNotEmpty() -> {
                btnPrefSave.text = resources.getText(R.string.sp_change)
                isPreferenceEmpty = false
            }
            else -> {
                btnPrefSave.text = resources.getString(R.string.sp_save)
                isPreferenceEmpty = true
            }
        }
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btnPrefSave) {
            val sharedPrefFormintent = Intent(this, SharedPreferenceFormActivity::class.java)
            startActivity(sharedPrefFormintent)
        }
    }
}

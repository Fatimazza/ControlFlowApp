package id.co.iconpln.controlflowapp.sharedPreference

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_shared_preference_form.*

class SharedPreferenceFormActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_TYPE_FORM = "extra_type_form"
        const val EXTRA_RESULT = "extra_result"
        const val RESULT_CODE = 101
        const val TYPE_ADD = 1
        const val TYPE_EDIT = 2
    }

    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference_form)

        btnPrefFormSave.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btnPrefFormSave) {
            val name = etPrefFormName.text.toString().trim()
            val email = etPrefFormEmail.text.toString().trim()
            val age = etPrefFormAge.text.toString().trim()
            val handphone = etPrefFormHp.text.toString().trim()
            val hasReadingHobby = rgPrefFormHobby.checkedRadioButtonId == R.id.rbPrefFormReading

            if (name.isEmpty()) {
                etPrefFormName.error = resources.getString(R.string.sp_field_required)
                return
            }
            if (email.isEmpty()) {
                etPrefFormEmail.error = resources.getString(R.string.sp_field_required)
                return
            }
            if (!isValidEmail(email)) {
                etPrefFormEmail.error = resources.getString(R.string.sp_field_email_not_valid)
                return
            }
            if (age.isEmpty()) {
                etPrefFormAge.error = resources.getString(R.string.sp_field_required)
                return
            }
            if (handphone.isEmpty()) {
                etPrefFormHp.error = resources.getString(R.string.sp_field_required)
                return
            }
            if (!handphone.isDigitsOnly()) {
                etPrefFormHp.error = resources.getString(R.string.sp_field_digit_only)
                return
            }
        }
    }

    private fun isValidEmail(email: CharSequence): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun saveUser(
        name: String, email: String, age: String, handphone: String, hasReadingHobby: Boolean
    ) {
        val userPreference = UserPreference(this)
        user.name = name
        user.email = email
        user.age = Integer.parseInt(age)
        user.handphone = handphone
        user.hasReadingHobby = hasReadingHobby
        userPreference.setUser(user)
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()
    }

}

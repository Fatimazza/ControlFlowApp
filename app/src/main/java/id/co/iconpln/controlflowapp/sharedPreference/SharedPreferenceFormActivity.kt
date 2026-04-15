package id.co.iconpln.controlflowapp.sharedPreference

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.databinding.ActivitySharedPreferenceFormBinding

class SharedPreferenceFormActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_TYPE_FORM = "extra_type_form"
        const val EXTRA_RESULT = "extra_result"
        const val RESULT_CODE = 101
        const val TYPE_ADD = 1
        const val TYPE_EDIT = 2
    }

    private lateinit var binding: ActivitySharedPreferenceFormBinding

    private lateinit var user: User
    private var formType: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySharedPreferenceFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getIntentExtra()
        binding.btnPrefFormSave.setOnClickListener(this)
        setupForm("", "")
        setupFormType()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun getIntentExtra() {
        user = intent.getParcelableExtra<User>("USER") as User
        formType = intent.getIntExtra(EXTRA_TYPE_FORM, 0)
    }

    private fun setupForm(actionBarTitle: String, btnTitle: String) {
        supportActionBar?.title = actionBarTitle
        binding.btnPrefFormSave.text = btnTitle
    }

    private fun setupFormType() {
        when (formType) {
            TYPE_ADD -> {
                setupForm("Tambah Baru", "Simpan")
            }

            TYPE_EDIT -> {
                setupForm("Ubah", "Update")
                showPreferenceInForm()
            }
        }
    }

    private fun showPreferenceInForm() {
        binding.etPrefFormName.setText(user.name)
        binding.etPrefFormEmail.setText(user.email)
        binding.etPrefFormAge.setText(user.age.toString())
        binding.etPrefFormHp.setText(user.handphone)
        binding.rbPrefFormReading.isChecked = user.hasReadingHobby
        binding.rbPrefFormNotReading.isChecked = !user.hasReadingHobby
    }

    override fun onClick(view: View) {
        if (view.id == binding.btnPrefFormSave.id) {
            val name = binding.etPrefFormName.text.toString().trim()
            val email = binding.etPrefFormEmail.text.toString().trim()
            val age = binding.etPrefFormAge.text.toString().trim()
            val handphone = binding.etPrefFormHp.text.toString().trim()
            val hasReadingHobby =
                binding.rgPrefFormHobby.checkedRadioButtonId == binding.rbPrefFormReading.id

            if (name.isEmpty()) {
                binding.etPrefFormName.error = resources.getString(R.string.sp_field_required)
                return
            }
            if (email.isEmpty()) {
                binding.etPrefFormEmail.error = resources.getString(R.string.sp_field_required)
                return
            }
            if (!isValidEmail(email)) {
                binding.etPrefFormEmail.error =
                    resources.getString(R.string.sp_field_email_not_valid)
                return
            }
            if (age.isEmpty()) {
                binding.etPrefFormAge.error = resources.getString(R.string.sp_field_required)
                return
            }
            if (handphone.isEmpty()) {
                binding.etPrefFormHp.error = resources.getString(R.string.sp_field_required)
                return
            }
            if (!handphone.isDigitsOnly()) {
                binding.etPrefFormHp.error = resources.getString(R.string.sp_field_digit_only)
                return
            }

            saveUser(name, email, age, handphone, hasReadingHobby)
            val resultIntent = Intent().putExtra(EXTRA_RESULT, user)
            setResult(RESULT_CODE, resultIntent)
            finish()
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }
}

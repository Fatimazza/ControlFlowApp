package id.co.iconpln.controlflowapp.sharedPreference

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.databinding.ActivitySharedPreferenceBinding

class SharedPreferenceActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivitySharedPreferenceBinding

    private lateinit var userPreference: UserPreference

    private var isPreferenceEmpty = false
    
    private lateinit var user: User

    companion object {
        private const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySharedPreferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPrefSave.setOnClickListener(this)

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
        binding.tvPrefName.text = if (user.name.toString().isEmpty())
            "Tidak Ada" else user.name
        binding.tvPrefAge.text = if (user.age.toString().isEmpty())
            "Tidak Ada" else user.age.toString()
        binding.tvPrefEmail.text = if (user.email.toString().isEmpty())
            "Tidak Ada" else user.email
        binding.tvPrefHandphone.text = if (user.handphone.toString().isEmpty())
            "Tidak Ada" else user.handphone
        binding.tvPrefHobby.text = if (!user.hasReadingHobby)
            "Tidak Membaca" else "Membaca"
    }

    private fun checkForm(user: User) {
        when {
            user.name.toString().isNotEmpty() -> {
                binding.btnPrefSave.text = resources.getText(R.string.sp_change)
                isPreferenceEmpty = false
            }

            else -> {
                binding.btnPrefSave.text = resources.getString(R.string.sp_save)
                isPreferenceEmpty = true
            }
        }
    }

    override fun onClick(view: View) {
        if (view.id == binding.btnPrefSave.id) {
            val sharedPrefFormintent = Intent(this, SharedPreferenceFormActivity::class.java)
            when {
                isPreferenceEmpty -> {
                    sharedPrefFormintent.putExtra(
                        SharedPreferenceFormActivity.EXTRA_TYPE_FORM,
                        SharedPreferenceFormActivity.TYPE_ADD
                    )
                }

                else -> {
                    sharedPrefFormintent.putExtra(
                        SharedPreferenceFormActivity.EXTRA_TYPE_FORM,
                        SharedPreferenceFormActivity.TYPE_EDIT
                    )
                }
            }
            sharedPrefFormintent.putExtra("USER", user)
            resultLauncher.launch(sharedPrefFormintent)
        }
    }

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.data != null
            && result.resultCode == SharedPreferenceFormActivity.RESULT_CODE
        ) {
            user = result.data?.getParcelableExtra<User>(
                SharedPreferenceFormActivity.EXTRA_RESULT
            ) as User
            populateView(user)
            checkForm(user)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == SharedPreferenceFormActivity.RESULT_CODE) {
                user = data?.getParcelableExtra<User>(
                    SharedPreferenceFormActivity.EXTRA_RESULT
                ) as User
                populateView(user)
                checkForm(user)
            }
        }
    }
}

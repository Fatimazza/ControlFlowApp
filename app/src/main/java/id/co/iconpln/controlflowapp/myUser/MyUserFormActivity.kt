package id.co.iconpln.controlflowapp.myUser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.model.myUser.UserDataResponse
import kotlinx.android.synthetic.main.activity_my_user_form.*

class MyUserFormActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    private lateinit var user: UserDataResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_user_form)

        initIntentExtra()
        populateFormData(user)
    }

    private fun initIntentExtra() {
        user = intent.getParcelableExtra(EXTRA_USER)
    }

    private fun populateFormData(user: UserDataResponse) {
        etUserFormName.setText(user.name)
        etUserFormAddress.setText(user.address)
        etUserFormHp.setText(user.phone)
    }
}

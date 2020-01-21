package id.co.iconpln.controlflowapp.myProfileLogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_my_profile_login.*

class MyProfileLoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewModel: MyProfileLoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile_login)

        initViewModel()

        supportActionBar?.title = "My Profile Login"
        btnProfileLogin.setOnClickListener(this)
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(MyProfileLoginViewModel::class.java)
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.btnProfileLogin -> {

            }
        }
    }
}

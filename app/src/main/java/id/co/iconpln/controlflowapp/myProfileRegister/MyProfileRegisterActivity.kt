package id.co.iconpln.controlflowapp.myProfileRegister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import id.co.iconpln.controlflowapp.R

class MyProfileRegisterActivity : AppCompatActivity() {

    private lateinit var viewModel: MyProfileRegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile_register)

        initViewModel()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(MyProfileRegisterViewModel::class.java)
    }
}

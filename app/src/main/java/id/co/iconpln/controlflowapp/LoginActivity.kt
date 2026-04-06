package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import id.co.iconpln.controlflowapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            checkBlankLoginField()
        }

        // TODO 1: Username & Password tidak boleh empty
        // TODO 2: Password minimal 7 digit
        // TODO 3: akan sukses jika login: user@mail.com, password
        // TODO 4: username formatnya email (dicek bener / salah)

    }

    private fun checkBlankLoginField() {
        binding.tvLoginStatus.text = resources.getString(R.string.status_login_title)
        when {
            binding.etLoginUsername.text.isBlank()
                -> binding.etLoginUsername.error = "Tidak boleh kosong"

            binding.etLoginPassword.text.isBlank()
                -> binding.etLoginPassword.error = "Tidak boleh kosong"

            binding.etLoginPassword.text.length < 7
                -> binding.etLoginPassword.error = "Minimal 7 karakter"

            !Patterns.EMAIL_ADDRESS.matcher(binding.etLoginUsername.text)
                .matches() -> binding.etLoginUsername.error = "Format email salah"

            else -> {
                doLogin(
                    binding.etLoginUsername.text.toString(),
                    binding.etLoginPassword.text.toString()
                )
            }
        }
    }

    private fun doLogin(username: String, password: String) {
        var loginStatus = ""
        if (username.equals("user@mail.com", false)
            && password.equals("password", false)
        ) {
            loginStatus = "Status Login: Berhasil"
        } else {
            loginStatus = "Status Login: Gagal"
        }
        binding.tvLoginStatus.text = loginStatus
    }
}

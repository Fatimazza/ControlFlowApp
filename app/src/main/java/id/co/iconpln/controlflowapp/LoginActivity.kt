package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            checkBlankLoginField()
        }

        // TODO 1: Username & Password tidak boleh empty
        // TODO 2: Password minimal 7 digit
        // TODO 3: akan sukses jika login: user@mail.com, password
        // TODO 4: username formatnya email (dicek bener / salah)

    }

    private fun checkBlankLoginField() {
        tvLoginStatus.text = resources.getString(R.string.status_login_title)
        when {
            etLoginUsername.text.isBlank() -> etLoginUsername.error = "Tidak boleh kosong"
            etLoginPassword.text.isBlank() -> etLoginPassword.error = "Tidak boleh kosong"
            etLoginPassword.text.length < 7 -> etLoginPassword.error = "Minimal 7 karakter"
            !Patterns.EMAIL_ADDRESS.matcher(
                etLoginUsername.text).matches() -> etLoginUsername.error = "Format email salah"
            else -> {
                doLogin(etLoginUsername.text.toString(), etLoginPassword.text.toString())
            }
        }
    }

    private fun doLogin(username: String, password: String) {
        var loginStatus = ""
        if (username.equals("user@mail.com", false)
            && password.equals("password", false)) {
            loginStatus = "Status Login: Berhasil"
        } else {
            loginStatus = "Status Login: Gagal"
        }
        tvLoginStatus.text = loginStatus
    }
}

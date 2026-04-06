package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.iconpln.controlflowapp.databinding.ActivityIntentMoveDataBinding

class IntentMoveDataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntentMoveDataBinding

    companion object {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }

    private var name: String = ""
    private var age: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIntentMoveDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getIntentExtras()
        showData()
    }

    private fun getIntentExtras() {
        name = intent.getStringExtra(EXTRA_NAME) ?: ""
        age = intent.getIntExtra(EXTRA_AGE, 0)
    }

    private fun showData() {
        val text = "Nama : $name, Age : $age"
        binding.tvDataReceived.text = text
    }
}

package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intent_move_data.*

class IntentMoveDataActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }

    private var name: String = ""
    private var age: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_move_data)

        getIntentExtras()
        showData()
    }

    private fun getIntentExtras() {
        name = intent.getStringExtra(EXTRA_NAME) ?: ""
        age = intent.getIntExtra(EXTRA_AGE, 0)
    }

    private fun showData() {
        val text = "Nama : $name, Age : $age"
        tvDataReceived.text = text
    }
}

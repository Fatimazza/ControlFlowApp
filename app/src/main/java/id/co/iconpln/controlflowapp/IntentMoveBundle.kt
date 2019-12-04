package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intent_move_bundle.*

class IntentMoveBundle : AppCompatActivity() {

    companion object {
        const val EXTRA_BUNDLE_AGE = "extra_age"
        const val EXTRA_BUNDLE_NAME = "extra_name"
    }

    private var name: String = ""
    private var age: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_move_bundle)

        getIntentExtras()
        showData()
    }

    private fun getIntentExtras() {
        name = intent.extras?.getString(EXTRA_BUNDLE_NAME)?:""
        age = intent.extras?.getInt(EXTRA_BUNDLE_AGE, 0)?:0
    }

    private fun showData() {
        val text = "Nama : $name, Age : $age"
        tvBundleReceived.text = text
    }
}

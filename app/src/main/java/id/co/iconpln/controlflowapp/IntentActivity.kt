package id.co.iconpln.controlflowapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_intent.*

class IntentActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        btnMoveActivity.setOnClickListener(this)
        btnMoveActivityData.setOnClickListener(this)
        btnMoveActivityObject.setOnClickListener(this)
        btnDialNumber.setOnClickListener(this)
        btnMoveForResult.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.btnMoveActivity -> {
                val moveIntent = Intent(this, StyleActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btnMoveActivityData -> {
                val moveIntentWithData = Intent(this, IntentMoveDataActivity::class.java)
                moveIntentWithData.putExtra(IntentMoveDataActivity.EXTRA_NAME, "Fatimazza")
                moveIntentWithData.putExtra(IntentMoveDataActivity.EXTRA_AGE, 17)
                startActivity(moveIntentWithData)
            }
            R.id.btnMoveActivityObject -> {

            }
            R.id.btnDialNumber -> {

            }
            R.id.btnMoveForResult -> {

            }
        }
    }
}

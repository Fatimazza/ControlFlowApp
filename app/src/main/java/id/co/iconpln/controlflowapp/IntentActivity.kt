package id.co.iconpln.controlflowapp

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

            }
            R.id.btnMoveActivityData -> {

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

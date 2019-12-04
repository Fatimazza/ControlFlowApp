package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_intent_move_result.*

class IntentMoveResultActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_move_result)

        btnResultChoose.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btnResultChoose) {
            if (rgNumber.checkedRadioButtonId != 0) {
                var value = 0
                when (rgNumber.checkedRadioButtonId) {
                    R.id.rb50 -> value = 50
                    R.id.rb100 -> value = 100
                    R.id.rb150 -> value = 150
                    R.id.rb200 -> value = 200
                }
            }
        }
    }
}

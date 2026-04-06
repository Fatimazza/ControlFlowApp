package id.co.iconpln.controlflowapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.co.iconpln.controlflowapp.databinding.ActivityIntentMoveResultBinding

class IntentMoveResultActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityIntentMoveResultBinding

    companion object {
        const val EXTRA_VALUE = "extra_value"
        const val RESULT_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIntentMoveResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnResultChoose.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btnResultChoose) {
            if (binding.rgNumber.checkedRadioButtonId != 0) {
                var value = 0
                when (binding.rgNumber.checkedRadioButtonId) {
                    R.id.rb50 -> value = 50
                    R.id.rb100 -> value = 100
                    R.id.rb150 -> value = 150
                    R.id.rb200 -> value = 200
                }

                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_VALUE, value)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }
        }
    }
}

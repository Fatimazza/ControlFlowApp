package id.co.iconpln.controlflowapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setClickListener()
    }

    private fun setClickListener() {
        btnCalculation.setOnClickListener(this)
        btnClassification.setOnClickListener(this)
        btnLogin.setOnClickListener(this)
        btnOperation.setOnClickListener(this)
        btnStyle.setOnClickListener(this)
        btnActivity.setOnClickListener(this)
        btnVolumeActivity.setOnClickListener(this)
        btnIntent.setOnClickListener(this)
        btnConstraint.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnCalculation -> {
                val calculationIntent = Intent(this, MainActivity::class.java)
                startActivity(calculationIntent)
            }
            R.id.btnClassification -> {
                val classificationIntent = Intent(this, ClassificationActivity::class.java)
                startActivity(classificationIntent)
            }
            R.id.btnLogin -> {
                val loginIntent = Intent(this, LoginActivity::class.java)
                startActivity(loginIntent)
            }
            R.id.btnOperation -> {
                val operationIntent = Intent(this, OperationActivity::class.java)
                startActivity(operationIntent)
            }
            R.id.btnStyle -> {
                val styleIntent = Intent(this, StyleActivity::class.java)
                startActivity(styleIntent)
            }
            R.id.btnActivity -> {
                val demoIntent = Intent(this, DemoActivity::class.java)
                startActivity(demoIntent)
            }
            R.id.btnVolumeActivity -> {
                val volumeIntent = Intent(this, VolumeActivity::class.java)
                startActivity(volumeIntent)
            }
            R.id.btnIntent -> {
                val intent = Intent(this, IntentActivity::class.java)
                startActivity(intent)
            }
            R.id.btnConstraint -> {
                val constraintIntent = Intent(this, ConstraintActivity::class.java)
                startActivity(constraintIntent)
            }
        }
    }
}

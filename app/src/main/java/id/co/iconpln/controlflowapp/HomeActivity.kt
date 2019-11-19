package id.co.iconpln.controlflowapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnCalculation.setOnClickListener {
            val calculationIntent = Intent(this, MainActivity::class.java)
            startActivity(calculationIntent)
        }

        btnClassification.setOnClickListener {
            Toast.makeText(this, "Classification", Toast.LENGTH_SHORT).show()
        }
    }
}

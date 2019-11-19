package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNilai.setText("0")
        btnShow.setOnClickListener {
            val angka = etNilai.text.toString().toInt()
            val hitungPangkat = angka * angka
            Toast.makeText(this, hitungPangkat.toString(), Toast.LENGTH_LONG).show()
        }
    }
}

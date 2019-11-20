package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_classification.*

class ClassificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classification)

        etClassificationNilai.setText("0")
        btnClassificationShow.setOnClickListener {
            doClassification(etClassificationNilai.text.toString().toInt())
        }
    }

    fun doClassification(nilai: Int) {
        tvClassificationHasil.text = "Hasilnya: Anda Lulus"
    }
}

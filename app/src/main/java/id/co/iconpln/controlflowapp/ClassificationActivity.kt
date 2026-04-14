package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import id.co.iconpln.controlflowapp.databinding.ActivityClassificationBinding

class ClassificationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityClassificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClassificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etClassificationNilai.setText("0")
        binding.btnClassificationShow.setOnClickListener {
            checkField()
        }
    }

    fun checkField() {
        if (binding.etClassificationNilai.text.isNullOrEmpty()) {
            Toast.makeText(this, "Nilai tidak boleh kosong", Toast.LENGTH_SHORT).show()
        } else if (binding.etClassificationNilai.text.toString().toInt() > 1000) {
            Toast.makeText(this, "Nilai tidak boleh lebih dari 1000", Toast.LENGTH_SHORT).show()
        } else {
            doClassification(binding.etClassificationNilai.text.toString().toInt())
        }
    }

    fun doClassification(nilai: Int) {
        var hasil = ""
        when (nilai) {
            in 0..70 -> {
                hasil = "Hasilnya: Anda Belum Lulus"
            }

            in 71..80 -> {
                hasil = "Hasilnya: Anda Lulus Aja"
            }

            in 81..100 -> {
                hasil = "Hasilnya: Anda Lulus Banget"
            }

            !in 0..100 -> {
                hasil = "Hasilnya: Nilai Error"
            }
        }
        binding.tvClassificationHasil.text = hasil
    }
}

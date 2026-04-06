package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.iconpln.controlflowapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvHasil.text = getString(R.string.hasilnya).format(0)
        binding.btnShow.setOnClickListener {
            if (binding.etNilai.text.isNotEmpty()) {
                val angka = binding.etNilai.text.toString().toInt()
                hitungPangkat(angka)
            }
        }
    }

    fun hitungPangkat(angka: Int) {
        val hitungPangkat = angka * angka
        binding.tvHasil.text = getString(R.string.hasilnya).format(hitungPangkat)
    }
}

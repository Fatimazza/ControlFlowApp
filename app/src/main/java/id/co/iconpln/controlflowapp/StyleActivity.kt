package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.iconpln.controlflowapp.databinding.ActivityStyleBinding

class StyleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStyleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStyleBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}

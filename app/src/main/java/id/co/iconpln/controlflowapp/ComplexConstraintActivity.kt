package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.iconpln.controlflowapp.databinding.ActivityComplexConstraintBinding

class ComplexConstraintActivity : AppCompatActivity() {

    private lateinit var binding: ActivityComplexConstraintBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityComplexConstraintBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}

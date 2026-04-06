package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import id.co.iconpln.controlflowapp.databinding.ActivityVolumeBinding

class VolumeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVolumeBinding

    private lateinit var volumeViewModel: VolumeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVolumeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        displayResult()
        setClickListener()
    }

    private fun initViewModel() {
        volumeViewModel = ViewModelProviders.of(this).get(VolumeViewModel::class.java)
    }

    private fun displayResult() {
        binding.tvResult.text = volumeViewModel.volumeResult.toString()
    }

    private fun setClickListener() {
        binding.btnCalculate.setOnClickListener {
            val length = binding.edtLength.text.toString()
            val width = binding.edtWidth.text.toString()
            val height = binding.edtHeight.text.toString()

            when {
                length.isEmpty() -> binding.edtLength.error = "Empty Field"
                width.isEmpty() -> binding.edtWidth.error = "Empty Field"
                height.isEmpty() -> binding.edtHeight.error = "Empty Field"
                else -> {
                    volumeViewModel.calculate(length, width, height)
                    displayResult()
                }
            }
        }
    }
}

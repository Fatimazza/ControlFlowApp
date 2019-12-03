package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_volume.*

class VolumeActivity : AppCompatActivity() {

    private val tvResult: TextView
        get() = tv_result

    private val btnCalculate: Button
        get() = btn_calculate

    private val etLength: EditText
        get() = edt_length

    private val etWidth: EditText
        get() = edt_width

    private val etHeight: EditText
        get() = edt_height

    private var volumeResult: Int = 0

    private lateinit var volumeViewModel: VolumeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volume)

        initViewModel()
        displayResult()
        setClickListener()
    }

    private fun initViewModel() {
        volumeViewModel = ViewModelProviders.of(this).get(VolumeViewModel::class.java)
    }

    private fun displayResult() {
        tvResult.text = volumeResult.toString()
    }

    private fun setClickListener() {
        btnCalculate.setOnClickListener {
            val length = etLength.text.toString()
            val width = etWidth.text.toString()
            val height = etHeight.text.toString()

            when {
                length.isEmpty() -> etLength.error = "Empty Field"
                width.isEmpty() -> etWidth.error = "Empty Field"
                height.isEmpty() -> etHeight.error = "Empty Field"
                else -> {
                    calculate(length, width, height)
                    displayResult()
                }
            }
        }
    }

    fun calculate(length: String, width: String, height: String) {
        volumeResult = Integer.parseInt(length) * Integer.parseInt(width) * Integer.parseInt(height)
    }
}

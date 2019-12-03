package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volume)
    }

    fun calculate(length: String, width: String, height: String) {
        volumeResult = Integer.parseInt(length) * Integer.parseInt(width) * Integer.parseInt(height)
    }
}

package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_operation.*

class OperationActivity : AppCompatActivity(), View.OnClickListener {

    private var inputX: Long = 0
    private var inputY: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operation)

        setButtonClickListener()
        getInputNumbers()
    }

    private fun setButtonClickListener() {
        btnOpAdd.setOnClickListener(this)
        btnOpSubstract.setOnClickListener(this)
        btnOpMultiply.setOnClickListener(this)
        btnOpDivide.setOnClickListener(this)
        btnOpOperation.setOnClickListener(this)
    }

    private fun getInputNumbers() {
        inputX = etBilanganX.text.toString().toLong()
        inputY = etBilanganY.text.toString().toLong()
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnOpAdd -> {

            }
            R.id.btnOpSubstract -> {

            }
            R.id.btnOpMultiply -> {

            }
            R.id.btnOpDivide -> {

            }
            R.id.btnOpOperation -> {

            }
        }
    }

    private fun execute(x: Long, operation: Operation) :Long {
        return when (operation) {
            is Operation.Add -> operation.value + x
            is Operation.Divide -> operation.value / x
            is Operation.Multiply -> operation.value * x
            is Operation.Substract -> operation.value - x
        }
    }
}

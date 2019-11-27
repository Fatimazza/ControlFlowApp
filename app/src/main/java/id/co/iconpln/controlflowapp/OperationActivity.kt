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
    }

    private fun setButtonClickListener() {
        btnOpAdd.setOnClickListener(this)
        btnOpSubstract.setOnClickListener(this)
        btnOpMultiply.setOnClickListener(this)
        btnOpDivide.setOnClickListener(this)
        btnOpReset.setOnClickListener(this)
    }

    private fun getInputNumbers() {
        if (etBilanganX.text?.isNotEmpty() == true || etBilanganY.text?.isNotEmpty() == true) {
            inputX = etBilanganX.text.toString().toLong()
            inputY = etBilanganY.text.toString().toLong()
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnOpAdd -> {
                tvOperator.text = resources.getString(R.string.operation_add)
                getInputNumbers()
                val add = Operation.Add(inputY)
                val addResult = execute(inputX, add)
                tvOperationResult.text = addResult.toString()
            }
            R.id.btnOpSubstract -> {
                tvOperator.text = resources.getString(R.string.operation_substract)
                getInputNumbers()
                val substract = Operation.Substract(inputY)
                val substractResult = execute(inputX, substract)
                tvOperationResult.text = substractResult.toString()
            }
            R.id.btnOpMultiply -> {
                tvOperator.text = resources.getString(R.string.operation_multiply)
                getInputNumbers()
                val multiply = Operation.Multiply(inputY)
                val multiplyResult = execute(inputX, multiply)
                tvOperationResult.text = multiplyResult.toString()
            }
            R.id.btnOpDivide -> {
                tvOperator.text = resources.getString(R.string.operation_divide)
                getInputNumbers()
                val divide = Operation.Divide(inputY)
                val divideResult = execute(inputX, divide)
                tvOperationResult.text = divideResult.toString()
            }
            R.id.btnOpReset -> {
                tvOperator.text = ""
                etBilanganX.setText("0")
                etBilanganY.setText("0")
                tvOperationResult.text = "0"
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

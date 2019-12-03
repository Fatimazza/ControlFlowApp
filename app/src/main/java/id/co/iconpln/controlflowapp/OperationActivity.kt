package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_operation.*

class OperationActivity : AppCompatActivity(), View.OnClickListener {

    private var inputX: Long = 0
    private var inputY: Long = 0

    private var operationResult: Long = 0

    lateinit var operationViewModel: OperationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operation)

        initViewModel()
        displayResult()
        setButtonClickListener()
    }

    private fun initViewModel() {
        operationViewModel = ViewModelProviders.of(this).get(OperationViewModel::class.java)
    }

    private fun displayResult() {
        tvOperationResult.text = operationResult.toString()
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
                val add = Operation.Add(inputX)
                operationResult = execute(inputY, add)
                tvOperationResult.text = operationResult.toString()
            }
            R.id.btnOpSubstract -> {
                tvOperator.text = resources.getString(R.string.operation_substract)
                getInputNumbers()
                val substract = Operation.Substract(inputX)
                operationResult = execute(inputY, substract)
                tvOperationResult.text = operationResult.toString()
            }
            R.id.btnOpMultiply -> {
                tvOperator.text = resources.getString(R.string.operation_multiply)
                getInputNumbers()
                val multiply = Operation.Multiply(inputX)
                operationResult = execute(inputY, multiply)
                tvOperationResult.text = operationResult.toString()
            }
            R.id.btnOpDivide -> {
                tvOperator.text = resources.getString(R.string.operation_divide)
                getInputNumbers()
                val divide = Operation.Divide(inputX)
                operationResult = execute(inputY, divide)
                tvOperationResult.text = operationResult.toString()
            }
            R.id.btnOpReset -> {
                tvOperator.text = ""
                etBilanganX.setText("0")
                etBilanganY.setText("0")
                operationResult = 0
                tvOperationResult.text = operationResult.toString()
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

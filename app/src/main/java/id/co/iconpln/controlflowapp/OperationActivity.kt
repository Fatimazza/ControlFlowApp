package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_operation.*

class OperationActivity : AppCompatActivity(), View.OnClickListener {

    private var inputX: Long = 0
    private var inputY: Long = 0

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
        tvOperator.text = operationViewModel.operation
        tvOperationResult.text = operationViewModel.operationResult.toString()
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
                operationViewModel.operation = resources.getString(R.string.operation_add)
                getInputNumbers()
                val add = Operation.Add(inputX)
                operationViewModel.execute(inputY, add)
                displayResult()
            }
            R.id.btnOpSubstract -> {
                operationViewModel.operation = resources.getString(R.string.operation_substract)
                getInputNumbers()
                val substract = Operation.Substract(inputX)
                operationViewModel.execute(inputY, substract)
                displayResult()
            }
            R.id.btnOpMultiply -> {
                operationViewModel.operation = resources.getString(R.string.operation_multiply)
                getInputNumbers()
                val multiply = Operation.Multiply(inputX)
                operationViewModel.execute(inputY, multiply)
                displayResult()
            }
            R.id.btnOpDivide -> {
                operationViewModel.operation = resources.getString(R.string.operation_divide)
                getInputNumbers()
                val divide = Operation.Divide(inputX)
                operationViewModel.execute(inputY, divide)
                displayResult()
            }
            R.id.btnOpReset -> {
                operationViewModel.operation = ""
                etBilanganX.setText("0")
                etBilanganY.setText("0")
                operationViewModel.operationResult = 0
                displayResult()
            }
        }
    }
}

package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import id.co.iconpln.controlflowapp.databinding.ActivityOperationBinding

class OperationActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityOperationBinding

    private var inputX: Long = 0
    private var inputY: Long = 0

    lateinit var operationViewModel: OperationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOperationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        displayResult()
        setButtonClickListener()
    }

    private fun initViewModel() {
        operationViewModel = ViewModelProvider(this).get(OperationViewModel::class.java)
    }

    private fun displayResult() {
        binding.tvOperator.text = operationViewModel.operation
        binding.tvOperationResult.text = operationViewModel.operationResult.toString()
    }

    private fun setButtonClickListener() {
        binding.btnOpAdd.setOnClickListener(this)
        binding.btnOpSubstract.setOnClickListener(this)
        binding.btnOpMultiply.setOnClickListener(this)
        binding.btnOpDivide.setOnClickListener(this)
        binding.btnOpReset.setOnClickListener(this)
    }

    private fun getInputNumbers() {
        if (binding.etBilanganX.text?.isNotEmpty() == true
            || binding.etBilanganY.text?.isNotEmpty() == true
        ) {
            inputX = binding.etBilanganX.text.toString().toLong()
            inputY = binding.etBilanganY.text.toString().toLong()
        }
    }

    override fun onClick(view: View) {
        when (view) {
            binding.btnOpAdd -> {
                operationViewModel.operation = resources.getString(R.string.operation_add)
                getInputNumbers()
                val add = Operation.Add(inputX)
                operationViewModel.execute(inputY, add)
                displayResult()
            }

            binding.btnOpSubstract -> {
                operationViewModel.operation = resources.getString(R.string.operation_substract)
                getInputNumbers()
                val substract = Operation.Substract(inputX)
                operationViewModel.execute(inputY, substract)
                displayResult()
            }

            binding.btnOpMultiply -> {
                operationViewModel.operation = resources.getString(R.string.operation_multiply)
                getInputNumbers()
                val multiply = Operation.Multiply(inputX)
                operationViewModel.execute(inputY, multiply)
                displayResult()
            }

            binding.btnOpDivide -> {
                operationViewModel.operation = resources.getString(R.string.operation_divide)
                getInputNumbers()
                val divide = Operation.Divide(inputX)
                operationViewModel.execute(inputY, divide)
                displayResult()
            }

            binding.btnOpReset -> {
                operationViewModel.operation = ""
                binding.etBilanganX.setText("0")
                binding.etBilanganY.setText("0")
                operationViewModel.operationResult = 0
                displayResult()
            }
        }
    }
}

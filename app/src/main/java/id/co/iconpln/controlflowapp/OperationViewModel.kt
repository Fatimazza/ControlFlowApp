package id.co.iconpln.controlflowapp

import androidx.lifecycle.ViewModel

class OperationViewModel: ViewModel() {

    var operation: String = ""

    var operationResult: Long = 0

    fun execute(x: Long, operation: Operation) {
        when (operation) {
            is Operation.Add -> operationResult = operation.value + x
            is Operation.Divide -> operationResult = operation.value / x
            is Operation.Multiply -> operationResult = operation.value * x
            is Operation.Substract -> operationResult = operation.value - x
        }
    }
}

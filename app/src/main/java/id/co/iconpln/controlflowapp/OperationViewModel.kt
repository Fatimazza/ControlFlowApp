package id.co.iconpln.controlflowapp

import androidx.lifecycle.ViewModel

class OperationViewModel: ViewModel() {

    var operationResult: Long = 0

    fun execute(x: Long, operation: Operation) :Long {
        return when (operation) {
            is Operation.Add -> operation.value + x
            is Operation.Divide -> operation.value / x
            is Operation.Multiply -> operation.value * x
            is Operation.Substract -> operation.value - x
        }
    }
    
}

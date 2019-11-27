package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class OperationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operation)
    }

    private fun execute(x: Int, operation: Operation) :Int {
        return when (operation) {
            is Operation.Add -> operation.value + x
            is Operation.Divide -> operation.value / x
            is Operation.Multiply -> operation.value * x
            is Operation.Substract -> operation.value - x
        }
    }
}

package id.co.iconpln.controlflowapp

sealed class Operation {
    class Add(val value: Int) : Operation()
    class Divide(val value: Int) : Operation()
    class Multiply(val value: Int) : Operation()
    class Substract(val value: Int) : Operation()
}

package id.co.iconpln.controlflowapp

sealed class Operation {
    class Add(val value: Long) : Operation()
    class Divide(val value: Long) : Operation()
    class Multiply(val value: Long) : Operation()
    class Substract(val value: Long) : Operation()
}

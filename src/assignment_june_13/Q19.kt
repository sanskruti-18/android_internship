package assignment_june_13

fun main() {
    try {
        val num = 10/0
    } catch (e: ArithmeticException) {
        println("Cannot divide by zero")
    }
}
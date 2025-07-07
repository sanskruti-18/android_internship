package assignment_june_13

fun main() {
    val factorial = (1..5).reduce { acc, i -> acc * i }
    println(factorial)
}
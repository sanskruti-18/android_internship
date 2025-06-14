package assignment_june_13

fun main() {
    try {
        val num = "abcd".toInt()
    } catch (e: NumberFormatException) {
        println("Cannot be converted to int")
    }
}
package assignment_june_13

fun main() {
    val items = mapOf("Laptop" to 1000, "Mouse" to 300, "Monitor" to 700)
    val obj = items.filter { it.value > 500 }.keys
    println(obj)
}
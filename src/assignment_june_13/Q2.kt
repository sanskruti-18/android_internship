package assignment_june_13

fun main() {
    val fruits = mutableListOf("Mango", "Banana", "Apple", "Mapple")
    fruits.removeAll { it.startsWith("M") }
    println(fruits)
}
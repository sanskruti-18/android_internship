package assignment_june_8

fun main () {
    val names = mutableListOf("Alice", "Bob", "Aron", "Charlie", "Ava")
    names.removeAll { it.startsWith("A") }
    println(names)
}
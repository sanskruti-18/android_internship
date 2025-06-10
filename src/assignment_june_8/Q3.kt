package assignment_june_8

fun main() {
    val marks = mapOf("Alice" to 87, "Mark" to 67, "Charlie" to 98)
    val top = marks.filter { it.value > 75}.keys // this will only print the names of the student not the value
    println(top)
}
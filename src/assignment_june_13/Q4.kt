package assignment_june_13

fun main() {
    val names = listOf("Samantha", "John", "Elizabeth", "Mike")
    val count = names.count { it.length > 5 }
    println(count)
}
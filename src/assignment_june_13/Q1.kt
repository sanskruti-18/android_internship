package assignment_june_13

fun main() {
    val num = (1..20).toList()
    val even = num.filter { it%2 == 0 }
    println(even)
}
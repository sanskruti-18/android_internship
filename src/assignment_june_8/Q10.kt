package assignment_june_8

fun main() {
    val words = listOf<String>("apple", "banana", "mango")
    println(longest(words))
}

fun longest(list: List<String>) : String {
    return list.maxBy { it.length }
}
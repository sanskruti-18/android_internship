package assignment_june_8

fun main() {
    val numStr: String? = "123"
    val num = numStr?.toIntOrNull()?.let { it * 2 }
    println(num)
    // toIntOrNull converts string to int and if it cant it will return null
    // if the result is not null then it will multiply with 2
}
package assignment_june_8

fun main() {
    val num: Int? = 21
    val result = num?.let { "The value is $it" } ?: {"The value is missing"}
    println(result)
}
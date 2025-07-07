package assignment_june_8

fun main() {
    val str: String? = "Hello"
// !! throws exception if null
    println(str!!.length)

// ?. safe call
    println(str?.length)

// ?: Elvis operator
    println(str?.length ?: 0)
}
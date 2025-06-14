package assignment_june_13

fun main() {
    val set = setOf(1, 2, 3)
    val element = 2
    if (element in set)
        println("Exists")
    else
        println("Does not exist")
}
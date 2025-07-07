package assignment_june_13

fun main() {
    val num = (1..10).toList()
    num.forEachIndexed {
        i, v -> println("$i, $v")
    }
}
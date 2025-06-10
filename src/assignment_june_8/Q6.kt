package assignment_june_8

fun main() {
    val num = (1..10).toList()
    val result = sumOfOdd(num)
    println(result)
}

fun sumOfOdd(list: List<Int>): Int {
    return list.filter { it % 2 != 0 }.sum()
}
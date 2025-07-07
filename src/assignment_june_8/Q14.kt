package assignment_june_8

fun main() {
    println(maxOrMinusOne(null))
}

fun maxOrMinusOne(list: List<Int>?): Int {
    return list?.maxOrNull() ?: -1
}
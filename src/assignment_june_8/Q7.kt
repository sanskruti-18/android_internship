package assignment_june_8

fun main() {
    println(sumOfNum(3,7))
}

fun sumOfNum(x: Int, y: Int): String { // this will return a string and int both
    val sum = x+y
    return "Sum of $x and $y = $sum"
}
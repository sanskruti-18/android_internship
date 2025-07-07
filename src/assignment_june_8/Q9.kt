package assignment_june_8

fun main() {
    println(factorial(5))
}

fun factorial(x: Int) : Int {
    if (x == 1) {
        return 1
    }
    else {
        return x * factorial(x-1)
    }
}
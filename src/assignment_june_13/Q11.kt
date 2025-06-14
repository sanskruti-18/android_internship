package assignment_june_13

fun main() {
    println(hof(5) {it * 2})
}

fun hof(a: Int, b:(Int) -> Int): Int {
    return b(a)
}
package assignment_june_13

fun main() {
    println(check(""))
}

fun check(a: String) {
    if (a.isBlank())
        throw IllegalArgumentException("Input cannot be blank")
}
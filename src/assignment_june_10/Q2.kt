package assignment_june_10

fun main() {
    println(getLenght(""))
}

fun getLenght(input: String?): Int {
    return input?.length ?: 0
}
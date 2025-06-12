package assignment_june_10

fun main() {
    val value: Any? = 21
    val age: Int? = value as? Int // as? is a safe cast operator
    println(age)
}
package assignment_june_13

fun main() {
    println(checkAge(22))
}
class InvalidAgeException(msg: String) : Exception(msg)

fun checkAge(age: Int) {
    if (age > 18) throw InvalidAgeException("Age should be below 18")
}
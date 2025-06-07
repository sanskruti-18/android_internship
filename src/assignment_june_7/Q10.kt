package assignment_june_7

fun main() {
    var caffieneLevel = 50
    var strength = when {
        caffieneLevel <= 30 -> "Mild"
        caffieneLevel <= 70 -> "Medium"
        else -> "Strong"
    }
    println("Caffiene level is $strength")
}
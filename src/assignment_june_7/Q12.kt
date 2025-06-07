package assignment_june_7

fun main() {
    var coffeePrice = 7
    when {
        coffeePrice <= 3 -> println("Coffee price is low!")
        coffeePrice <=7 -> println("Coffee price os reasonable")
        else -> println("Coffee is expensive")
    }
}
package assignment_june_7

fun main() {
    var price = 150
    for (i in 10..50 step 10) {
        var discount = price - (i/100)
        println("$i% off: $discount")
    }
}
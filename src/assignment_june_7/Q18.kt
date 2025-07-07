package assignment_june_7

fun main() {
    var tipNo = (1..4).random()
    when (tipNo) {
        1 -> println("Stir before you sip!")
        2 -> println("Don't forget to tip!")
        3 -> println("Enjoy your coffee")
        4 -> println("Try a new flavour")
    }
}
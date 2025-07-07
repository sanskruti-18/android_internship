package assignment_june_7

fun main() {
    var temp = 40
    when {
        temp <= 30 -> println("Too cold")
        temp <= 50 -> println("Perfect")
        else -> println("Too hot")
    }
}
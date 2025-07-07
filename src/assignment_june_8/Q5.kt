package assignment_june_8

fun main() {
    var num = (1..10).toList()
    for (i in num) {
        var square = i*i
        println("Square of $i = $square")
    }
}

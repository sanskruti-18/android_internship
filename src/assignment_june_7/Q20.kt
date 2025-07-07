package assignment_june_7

fun main() {
    for (i in 1..10){
        if (i == 4 || i == 8)
            continue
        println("Order no: $i")
    }
}
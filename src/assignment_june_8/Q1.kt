package assignment_june_8

fun main() {
    val num = (1..10).toList();
    val evenNum = num.filter { it % 2 == 0 } // filter function is used to filter out the values satisfying the given cond
    println(evenNum)
}
package assignment_june_13

fun main() {
    println(operateOnNumbers(5,6) {x,y -> x+y})
    println(operateOnNumbers(5,6) {x,y -> x*y})
    println(operateOnNumbers(5,6) {x,y -> x-y})
}

fun operateOnNumbers(a: Int, b: Int, op: (Int,Int) -> Int): Int {
    return op(a,b)
}
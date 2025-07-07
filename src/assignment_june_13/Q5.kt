package assignment_june_13

fun main() {
    val num1 = listOf(1,2,3,4,5,6,7,8)
    val num2 = listOf(4,5,6,7,11,19,2,10)
    val merge = (num1+num2).distinct() // this function creates new list containing 1st occurence of each element
    println(merge)
}
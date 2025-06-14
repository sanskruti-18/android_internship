package assignment_june_13

fun main() {
    val mixedNums = listOf(1, 2, 3, 6, 4, 1)
    println(mixedNums.takeWhile { it < 5 }) // returns all the elements from the start as long as the cond is true
    println(mixedNums.dropWhile { it < 5 }) // ignores all the elements from the start unit the cond is false
                                            // then returns rest of the element
}
package assignment_june_8

fun main() {
    val words = listOf("dog", "cat", "horse", "tiger", "fish")
    val counts = words.count { it.length > 4 } // this function will directly count the words
    println(counts)
}
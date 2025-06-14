package assignment_june_13

fun main() {
    val sentence = "This is an assignment"
    val vowels = sentence.lowercase().filter { it in "aeiou" }.toSet()
    println(vowels)
}
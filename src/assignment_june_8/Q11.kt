package assignment_june_8

fun main() {
    val nullableString: String? = "Kotlin"
    nullableString?.takeIf { it.isNotBlank() }?.reversed()?.let { println(it) }
}
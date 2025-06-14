package assignment_june_13

fun main() {
    val list = listOf(1,2,3,4,5)
    try {
        println(list[6])
    } catch (e: Exception) {
        println("Exception ${e.message}")
    } finally {
        println("End of operation")
    }
}
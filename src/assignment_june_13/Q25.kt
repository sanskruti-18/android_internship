package assignment_june_13

fun main() {
    try {
        val arr: Array<String>? = null
        println(arr!![1]) // art!! -> not null assertion operator
    } catch (e: NullPointerException) {
        println("Null pointer!")
    } catch (e: IndexOutOfBoundsException) {
        println("Index out of bounds!")
    }
}
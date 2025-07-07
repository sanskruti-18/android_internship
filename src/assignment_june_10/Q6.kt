package assignment_june_10

fun main() {
    var address: String? = null
    // val len = address!!.length // Unsafe
    val len = address?.length //Safe
    println(len)
}
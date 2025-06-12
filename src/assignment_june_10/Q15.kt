package assignment_june_10

class MathUtils {
    companion object {
        fun square(n: Int): Int = n * n
    }
}

fun main() {
    println(MathUtils.square(4)) // without creating instances we can directly call
}
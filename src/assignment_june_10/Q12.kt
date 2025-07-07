package assignment_june_10

abstract class Shape {
    abstract fun area(): Double
}

class Circle(val radius: Int): Shape() {
    override fun area(): Double {
        return Math.PI * radius * radius
    }
}

fun main() {
    val a = Circle(8)
    println(a.area())
}
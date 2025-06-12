package assignment_june_10

open class Animal{
    open fun makesound() {
        println("Animal sound")
    }
}

class Dog: Animal() {
    override fun makesound() {
        super.makesound()
        println("Bark")
    }
}

fun main() {
    val dog = Dog()
    dog.makesound()
}
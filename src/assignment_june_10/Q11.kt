package assignment_june_10

interface Drivable {
    fun drive()
}

class Car : Drivable {
    override fun drive() {
        println("Car is driving")
    }
}

fun main() {
    val car = Car()
    car.drive()
}
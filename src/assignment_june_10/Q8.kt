package assignment_june_10

class Person(val name: String,val age: Int) {

}

fun main() {
    val person = Person("Sanskruti",21)
    println("Name: ${person.name}, Age: ${person.age}")
}
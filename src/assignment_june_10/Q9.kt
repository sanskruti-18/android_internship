package assignment_june_10

class person1(val name: String, val age: Int) {
    constructor(name: String) : this(name,18)
}

fun main() {
    val p = person1("Sanskruti")
    println("Name: ${p.name}, Age: ${p.age}")
}
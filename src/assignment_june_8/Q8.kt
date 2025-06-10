package assignment_june_8

fun main() {
    println(fullName("Sanskruti","Dash"))
}

fun fullName(first: String, last: String) : String {
    return "$first $last".trim()
}
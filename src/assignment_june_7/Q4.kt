package assignment_june_7

fun main() {
    var size1 = "small"
    var size2 = "large"
    var temp = size1
    size1 = size2
    size2 = temp
    println("$size1, $size2")
}
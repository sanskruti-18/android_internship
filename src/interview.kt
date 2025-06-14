//Find missing numbers:

//input: [1, 2, 3, 5, 7]
//output: [4, 6]

fun missingNumber(list: List<Int>): List<Int> {
    val num = list.first()..list.last()
    return num.filter { it !in list }
}

fun main() {
//    val num = listOf(1,2,3,5,7)
//    println(missingNumber(num))
    val ip = "10.0.1.250"
    println(validIPv4(ip))
}

//Functions:Create a function that will test to see whether a string value contains a valid IPv4 address.
// An IPv4 address is the address assigned to a computer that uses the internet Protocol (IP) to communicate.
// An IP address consists of four numeric values that range from 0-255, separated by a dot(period) Example: 10.0.1.250.

fun validIPv4(a: String): Boolean {
    val segment = a.split(".")
    if(segment.size != 4)
        return false
    for (i in segment) {
        val num = i.toIntOrNull() ?: return false
        if (num < 0 || num > 255)
            return false
        if (i.startsWith("0"))
            return false
    }
    return true
}
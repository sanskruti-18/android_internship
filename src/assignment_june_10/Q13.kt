package assignment_june_10

data class User(val name: String,val email: String) {

}

fun main() {
    val user1 = User("Alice","alice@gmail.com")
    val user2 = User("Alice","alice@gmail.com")
    println(user1 == user2)
}

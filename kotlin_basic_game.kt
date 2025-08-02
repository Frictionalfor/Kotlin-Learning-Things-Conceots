import kotlin.random.Random
import kotlin.system.exitProcess

fun main() {
    val a = Random.nextInt(1, 100)
    var b = 0
    var c = 0
    val d = 5
    val e = "Too high!"
    val f = "Too low!"
    val g = "Correct!"
    
    println("Welcome to the Guess the Number game!")
    println("I'm thinking of a number between 1 and 100.")
    
    while (c < d) {
        print("Attempt ${c + 1}: Enter your guess: ")
        val input = readLine()
        b = input?.toIntOrNull() ?: continue
        c++
        
        when {
            b == a -> {
                println("$g You guessed it in $c tries.")
                exitProcess(0)
            }
            b > a -> println(e)
            b < a -> println(f)
        }
    }

    println("Out of attempts! The number was $a. Better luck next time.")
}
package test

class Main() {
	fun main() {
		println("Hello, World!")
		val tim = Player("Tim")
		println(tim.name)
		println(tim.lives)
		println(tim.level)
		println(tim.score)

		println("How old are yout: ")
		val age = readLine()!!.toInt()
		println("age is $age")
	}
}
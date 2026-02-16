import kotlin.math.PI

//Задание 1

fun greetUser(name: String) {
    println("Привет $name")
}

//Задание 2

fun calculateCircleArea(radus:Double): Double {
    return PI * radus * radus
}

//Задание 3

fun printPersonInfo(name:String,age:Int = 18, city:String = "Неизвестно") {
    println("Имя человека $name, ему сейчас лет $age, город проживание $city" )
}

//Задание 5

fun calculateAverage(vararg numbers:Int): Double{
    var number_of_digits: Int = 0
    var sum: Double = 0.0
    for (i in numbers){
        sum += i
        number_of_digits++
    }
    return sum / number_of_digits
}

//Задание 6

fun square(number:Int): Int = number * number
fun isEven(number:Int): Boolean = number % 2 == 0
fun maxOfTwoShort(a: Int, b: Int)= if (a > b) a else b

//Задание 7

fun validatePasswordShort(password: String): Boolean {
    fun checkLength() = password.length >= 8
    fun hasDigit() = password.any { it.isDigit() }
    fun hasUppercase() = password.any { it.isUpperCase() }

    return checkLength() && hasDigit() && hasUppercase()
}

//Задание 8

fun calculateArea(radius: Double) = PI * radius * radius
fun calculateArea(width: Double, height: Double) = width * height
fun calculateArea(base: Double, height: Double, isTriangle: Boolean = true) =
    if (isTriangle) 0.5 * base * height else base * height
//Задание 9

fun filterList(list: List<Int>, predicate: (Int) -> Boolean) = list.filter(predicate)

//Задание 10

fun createCounter(start: Int): () -> Int {
    var count = start
    return { count++ }
}

fun main() {
//    Задание 1

    greetUser("Петя")
    greetUser("Лена")
    greetUser("Вася")
//    Задание 2

    println(calculateCircleArea(5.0))
    println(calculateCircleArea(10.0))
    println(calculateCircleArea(2.5))
//    Задание 3

    printPersonInfo("Петя",22,"Чита")
    printPersonInfo("Лена",15)
    printPersonInfo("Вася")

//Задание 4

    println(printPersonInfo(city = "Чертов город",name = "Властитель всего сущего", age = 4738))

//Задание 5

    println(calculateAverage(1,2,3))
    println(calculateAverage(10, 20, 30, 40, 50))
    println(calculateAverage(5,5,5,5,5))
//Задание 6

    println("Квадрат числа 4: ${square(4)}")
    println("Является ли число 10 четным: ${isEven(10)}")
    println("Какое число большое 5 или 143: ${maxOfTwoShort(5,143)}")
//Задание 7

    val passwords = listOf(
        "weak",
        "password123",
        "Password123",
        "PASS123",
        "Pass123"
    )

    for (pwd in passwords) {
        println("Пароль '$pwd' валидный? ${validatePasswordShort(pwd)}")
    }
//Задание 8

    println("Круг: ${calculateArea(5.0)}")
    println("Прямоугольник: ${calculateArea(5.0, 3.0)}")
    println("Треугольник: ${calculateArea(4.0, 6.0, true)}")
//Задание 9

    val numbers = (1..20).toList()

    println("Чётные: ${filterList(numbers) { it % 2 == 0 }}")
    println("Больше 10: ${filterList(numbers) { it > 10 }}")
    println("5-15: ${filterList(numbers) { it in 5..15 }}")

//Задание 10

    val counter = createCounter(5)
    println(counter()) // 5
    println(counter()) // 6
    println(counter()) // 7

    // Два независимых счётчика
    val c1 = createCounter(0)
    val c2 = createCounter(100)
    println("${c1()} ${c2()}")
    println("${c1()} ${c2()}")

}
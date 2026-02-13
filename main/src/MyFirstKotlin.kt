import kotlin.random.Random
import kotlin.math.sqrt

fun main() {
    while (true) {
        println("ВЫБЕРИТЕ ЗАДАНИЕ (1-12)")
        println("1. Динамические диапазоны")
        println("2. Работа с массивом и условиями")
        println("3. Конвертер систем счисления")
        println("4. Поиск простых чисел")
        println("5. Шифр Цезаря")
        println("6. Статистика текста")
        println("7. Игра «Угадай число»")
        println("8. Работа с матрицей")
        println("9. Фибоначчи с условиями")
        println("10. Валидатор пароля")
        println("11. Конвертер времени")
        println("12. Мини-калькулятор выражений")
        println("0. Выход")
        print("\nВаш выбор: ")

        when (readLine()) {
            "1" -> zadanie1()
            "2" -> zadanie2()
            "3" -> zadanie3()
            "4" -> zadanie4()
            "5" -> zadanie5()
            "6" -> zadanie6()
            "7" -> zadanie7()
            "8" -> zadanie8()
            "9" -> zadanie9()
            "10" -> zadanie10()
            "11" -> zadanie11()
            "12" -> zadanie12()
            "0" -> {
                println("Программа завершена")
                break
            }
            else -> println("Неверный выбор!")
        }

        print("\nНажмите Enter для продолжения...")
        readLine()
    }
}

// Задание 1: Динамические диапазоны
fun zadanie1() {
    println("\n--- Задание 1: Динамические диапазоны ---")
    print("Введите начальное число: ")
    val start = readLine()?.toIntOrNull() ?: return

    print("Введите конечное число: ")
    val end = readLine()?.toIntOrNull() ?: return

    println("Числа, делящиеся на 3, с шагом 2:")
    for (num in start..end step 2) {
        if (num % 3 == 0) {
            println(num)
        }
    }
}

// Задание 2: Работа с массивом и условиями
fun zadanie2() {
    println("\n--- Задание 2: Работа с массивом и условиями ---")
    val numbers = Array(10) { Random.nextInt(1, 101) }

    println("Сгенерированный массив: ${numbers.joinToString()}")

    val max = numbers.maxOrNull() ?: 0
    val min = numbers.minOrNull() ?: 0
    val average = numbers.average()
    val evenCount = numbers.count { it % 2 == 0 }

    println("Максимальный элемент: $max")
    println("Минимальный элемент: $min")
    println("Среднее арифметическое: $average")
    println("Количество чётных чисел: $evenCount")
}

// Задание 3: Конвертер систем счисления
fun zadanie3() {
    println("\n--- Задание 3: Конвертер систем счисления ---")
    print("Введите целое число: ")
    val number = readLine()?.toIntOrNull() ?: return

    print("Введите систему счисления (2, 8, 16): ")
    val base = readLine()?.toIntOrNull() ?: return

    val result = when (base) {
        2 -> convertToBinary(number)
        8 -> convertToOctal(number)
        16 -> convertToHex(number)
        else -> "Неподдерживаемая система счисления"
    }

    println("Результат: $result")
}

fun convertToBinary(n: Int): String {
    if (n == 0) return "0"
    var num = if (n < 0) -n else n
    var result = ""
    while (num > 0) {
        result = (num % 2).toString() + result
        num /= 2
    }
    return if (n < 0) "-$result" else result
}

fun convertToOctal(n: Int): String {
    if (n == 0) return "0"
    var num = if (n < 0) -n else n
    var result = ""
    while (num > 0) {
        result = (num % 8).toString() + result
        num /= 8
    }
    return if (n < 0) "-$result" else result
}

fun convertToHex(n: Int): String {
    if (n == 0) return "0"
    var num = if (n < 0) -n else n
    val hexDigits = "0123456789ABCDEF"
    var result = ""
    while (num > 0) {
        result = hexDigits[num % 16] + result
        num /= 16
    }
    return if (n < 0) "-$result" else result
}

// Задание 4: Поиск простых чисел
fun zadanie4() {
    println("\n--- Задание 4: Поиск простых чисел ---")
    println("Простые числа от 2 до 100:")

    for (num in 2..100) {
        var isPrime = true
        val limit = sqrt(num.toDouble()).toInt()

        for (i in 2..limit) {
            if (num % i == 0) {
                isPrime = false
                break
            }
        }

        if (isPrime) {
            print("$num ")
        }
    }
    println()
}

// Задание 5: Шифр Цезаря
fun zadanie5() {
    println("\n--- Задание 5: Шифр Цезаря ---")
    print("Введите строку для шифрования: ")
    val input = readLine() ?: return

    val shift = 3
    val encrypted = caesarCipher(input, shift)

    println("Зашифрованная строка: $encrypted")
}

fun caesarCipher(text: String, shift: Int): String {
    val result = StringBuilder()

    for (char in text) {
        when {
            char.isUpperCase() -> {
                val shifted = ((char - 'A' + shift) % 26 + 26) % 26
                result.append('A' + shifted)
            }
            char.isLowerCase() -> {
                val shifted = ((char - 'a' + shift) % 26 + 26) % 26
                result.append('a' + shifted)
            }
            else -> result.append(char)
        }
    }

    return result.toString()
}

// Задание 6: Статистика текста
fun zadanie6() {
    println("\n--- Задание 6: Статистика текста ---")
    println("Введите текст (для завершения введите пустую строку):")

    val lines = mutableListOf<String>()
    while (true) {
        val line = readLine() ?: break
        if (line.isEmpty()) break
        lines.add(line)
    }

    val text = lines.joinToString("\n")

    val charCount = text.length
    val words = text.split("\\s+".toRegex()).filter { it.isNotEmpty() }
    val wordCount = words.size

    val sentenceCount = text.split(Regex("[.!?]")).filter { it.isNotBlank() }.size

    val longestWord = words.maxByOrNull { it.length } ?: ""

    println("\nСтатистика текста:")
    println("Количество символов: $charCount")
    println("Количество слов: $wordCount")
    println("Количество предложений: $sentenceCount")
    println("Самое длинное слово: $longestWord (${longestWord.length} символов)")
}

// Задание 7: Игра «Угадай число»
fun zadanie7() {
    println("\n--- Задание 7: Игра «Угадай число» ---")
    val secretNumber = Random.nextInt(1, 101)
    var attempts = 0
    var guess: Int?

    println("Я загадал число от 1 до 100. Попробуй угадай!")

    do {
        print("Введите число: ")
        guess = readLine()?.toIntOrNull()

        if (guess != null) {
            attempts++

            when {
                guess < secretNumber -> println("Больше!")
                guess > secretNumber -> println("Меньше!")
                else -> println("Поздравляю! Вы угадали число $secretNumber за $attempts попыток!")
            }
        }
    } while (guess != secretNumber)
}

// Задание 8: Работа с матрицей
fun zadanie8() {
    println("\n--- Задание 8: Работа с матрицей ---")
    val matrix = Array(3) { Array(3) { Random.nextInt(1, 10) } }

    println("Матрица 3x3:")
    for (row in matrix) {
        println(row.joinToString(" "))
    }

    // Сумма элементов каждой строки
    println("\nСуммы по строкам:")
    for (i in matrix.indices) {
        val rowSum = matrix[i].sum()
        println("Строка ${i + 1}: $rowSum")
    }

    // Сумма элементов каждого столбца
    println("\nСуммы по столбцам:")
    for (j in matrix[0].indices) {
        var colSum = 0
        for (i in matrix.indices) {
            colSum += matrix[i][j]
        }
        println("Столбец ${j + 1}: $colSum")
    }

    // Сумма элементов главной диагонали
    var diagonalSum = 0
    for (i in matrix.indices) {
        diagonalSum += matrix[i][i]
    }
    println("\nСумма главной диагонали: $diagonalSum")
}

// Задание 9: Фибоначчи с условиями
fun zadanie9() {
    println("\n--- Задание 9: Фибоначчи с условиями ---")
    print("Введите количество чисел Фибоначчи (N): ")
    val n = readLine()?.toIntOrNull() ?: return

    println("Числа Фибоначчи, удовлетворяющие условиям:")

    var a = 0
    var b = 1

    for (i in 1..n) {
        val fib = a

        // Пропускаем неподходящие числа
        if (!(fib % 2 == 0 || (fib > 50 && fib < 200))) {
            a = b.also { b = a + b }
            continue
        }

        println("F$i = $fib")

        a = b.also { b = a + b }
    }
}

// Задание 10: Валидатор пароля
fun zadanie10() {
    println("\n--- Задание 10: Валидатор пароля ---")
    print("Введите пароль для проверки: ")
    val password = readLine() ?: return

    val errors = validatePassword(password)

    if (errors.isEmpty()) {
        println("Пароль надёжный!")
    } else {
        println("Пароль не соответствует требованиям:")
        errors.forEach { println("- $it") }
    }
}

fun validatePassword(password: String): List<String> {
    val errors = mutableListOf<String>()

    if (password.length < 8) {
        errors.add("Пароль должен содержать минимум 8 символов")
    }

    if (!password.any { it.isDigit() }) {
        errors.add("Пароль должен содержать хотя бы одну цифру")
    }

    if (!password.any { it.isUpperCase() }) {
        errors.add("Пароль должен содержать хотя бы одну заглавную букву")
    }

    val specialChars = "!@#\$%^&*"
    if (!password.any { it in specialChars }) {
        errors.add("Пароль должен содержать хотя бы один специальный символ (!@#\$%^&*)")
    }

    return errors
}

// Задание 11: Конвертер времени
fun zadanie11() {
    println("\n--- Задание 11: Конвертер времени ---")
    while (true) {
        println("\n--- Конвертер времени ---")
        println("1. Секунды → часы:минуты:секунды")
        println("2. Часы:минуты → секунды")
        println("3. Назад в главное меню")
        print("Выберите действие (1-3): ")

        when (readLine()) {
            "1" -> convertSecondsToHMS()
            "2" -> convertHMSToSeconds()
            "3" -> {
                println("Возврат в главное меню")
                break
            }
            else -> println("Неверный выбор")
        }
    }
}

fun convertSecondsToHMS() {
    print("Введите количество секунд: ")
    val totalSeconds = readLine()?.toIntOrNull() ?: return

    val hours = totalSeconds / 3600
    val minutes = (totalSeconds % 3600) / 60
    val seconds = totalSeconds % 60

    println("Результат: $hours часов, $minutes минут, $seconds секунд")
    println("Формат: $hours:$minutes:$seconds")
}

fun convertHMSToSeconds() {
    print("Введите часы: ")
    val hours = readLine()?.toIntOrNull() ?: return

    print("Введите минуты: ")
    val minutes = readLine()?.toIntOrNull() ?: return

    val totalSeconds = hours * 3600 + minutes * 60
    println("Результат: $totalSeconds секунд")
}

// Задание 12: Мини-калькулятор выражений
fun zadanie12() {
    println("\n--- Задание 12: Мини-калькулятор выражений ---")
    println("Калькулятор выражений (поддерживает +, -, *, /)")
    println("Пример: 12 + 34 - 5 * 2 / 4")
    print("Введите выражение: ")

    val expression = readLine() ?: return

    try {
        val result = evaluateExpression(expression)
        println("Результат: $result")
    } catch (e: Exception) {
        println("Ошибка: ${e.message}")
    }
}

fun evaluateExpression(expr: String): Double {
    // Разбиваем выражение на токены
    val tokens = expr.split(" ").filter { it.isNotEmpty() }
    val numbers = mutableListOf<Double>()
    val operators = mutableListOf<String>()

    // Разделяем числа и операторы
    var i = 0
    while (i < tokens.size) {
        if (i % 2 == 0) {
            // Должно быть число
            val num = tokens[i].toDoubleOrNull()
            if (num == null) {
                throw Exception("Некорректное число: ${tokens[i]}")
            }
            numbers.add(num)
        } else {
            // Должен быть оператор
            if (tokens[i] !in listOf("+", "-", "*", "/")) {
                throw Exception("Некорректный оператор: ${tokens[i]}")
            }
            operators.add(tokens[i])
        }
        i++
    }

    println("Промежуточные шаги вычисления:")

    // Сначала выполняем умножение и деление
    i = 0
    while (i < operators.size) {
        if (operators[i] == "*" || operators[i] == "/") {
            val a = numbers[i]
            val b = numbers[i + 1]
            val result = when (operators[i]) {
                "*" -> a * b
                "/" -> {
                    if (b == 0.0) throw Exception("Деление на ноль")
                    a / b
                }
                else -> 0.0
            }
            println("  $a ${operators[i]} $b = $result")

            numbers[i] = result
            numbers.removeAt(i + 1)
            operators.removeAt(i)
        } else {
            i++
        }
    }

    // Затем выполняем сложение и вычитание
    var result = numbers[0]
    for (j in operators.indices) {
        val nextNum = numbers[j + 1]
        result = when (operators[j]) {
            "+" -> {
                println("  $result + $nextNum = ${result + nextNum}")
                result + nextNum
            }
            "-" -> {
                println("  $result - $nextNum = ${result - nextNum}")
                result - nextNum
            }
            else -> result
        }
    }

    return result
}
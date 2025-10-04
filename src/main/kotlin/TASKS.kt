fun main() {
    while (true) {
        println("Выбери задачу (1-6):")
        println("1 - Сжать строку (AAABBB → A3B3)")
        println("2 - Посчитать символы (AAB → A-2 B-1)")
        println("3 - Перевести число в двоичное")
        println("4 - Калькулятор")
        println("5 - Найти степень (8 и 2 → 3)")
        println("6 - Сделать нечетное число из двух цифр")
        println("0 - Выход")

        val choice = readln().toIntOrNull() ?: continue

        when (choice) {
            1 -> task1()
            2 -> task2()
            3 -> task3()
            4 -> task4()
            5 -> task5()
            6 -> task6()
            0 -> break
        }
    }
}

fun task1() {
    println("=== Сжатие строки ===")
    println("Введи строку:")
    val s = readln()
    var result = ""
    var count = 1

    for (i in 0 until s.length - 1) {
        if (s[i] == s[i + 1]) {
            count++
        } else {
            result += s[i]
            if (count > 1) result += count
            count = 1
        }
    }

    result += s.last()
    if (count > 1) result += count
    println("Результат: $result")
}

fun task2() {
    println("=== Подсчет символов ===")
    println("Введи строку:")
    val s = readln()
    val sorted = s.toCharArray().sorted()

    var i = 0
    while (i < sorted.size) {
        val char = sorted[i]
        var count = 0

        while (i < sorted.size && sorted[i] == char) {
            count++
            i++
        }

        println("$char - $count")
    }
}

fun task3() {
    println("=== Перевод в двоичную систему ===")
    println("Введи число:")
    val n = readln().toIntOrNull()
    if (n == null) {
        println("Ошибка: введите корректное число")
        return
    }

    var num = n
    var binary = ""

    while (num > 0) {
        binary = (num % 2).toString() + binary
        num /= 2
    }

    println(binary)
}

fun task4() {
    println("=== Калькулятор ===")
    println("Введи первое число:")
    val num1Str = readln()
    println("Введи второе число:")
    val num2Str = readln()

    val num1 = num1Str.toDoubleOrNull()
    val num2 = num2Str.toDoubleOrNull()

    if (num1 == null || num2 == null) {
        println("Ошибка: введите корректные числа")
        return
    }

    println("Выбери операцию (+, -, *, /):")
    val op = readln()

    when (op) {
        "+" -> println("Результат: ${num1 + num2}")
        "-" -> println("Результат: ${num1 - num2}")
        "*" -> println("Результат: ${num1 * num2}")
        "/" -> {
            if (num2 == 0.0) {
                println("Ошибка: деление на ноль")
            } else {
                println("Результат: ${num1 / num2}")
            }
        }
        else -> println("Ошибка: неизвестная операция")
    }
}

fun task5() {
    println("=== Поиск степени ===")
    println("Введи число:")
    val n = readln().toIntOrNull()
    println("Введи основание степени:")
    val x = readln().toIntOrNull()

    if (n == null || x == null) {
        println("Ошибка: введите корректные числа")
        return
    }

    if (x <= 0) {
        println("Ошибка: основание степени должно быть положительным")
        return
    }

    if (n <= 0) {
        println("Ошибка: число должно быть положительным")
        return
    }

    var y = 0
    var power = 1

    while (power < n) {
        power *= x
        y++
    }

    if (power == n) {
        println("Показатель степени: $y")
        println("Проверка: $x^$y = $n")
    } else {
        println("Нет целого показателя степени")
        println("Ближайшие степени: $x^${y-1} = ${power/x}, $x^$y = $power")
    }
}

fun task6() {
    println("=== Создание нечетного числа ===")
    println("Введи первую цифру(0-9):")
    val d1 = readln().toIntOrNull()
    println("Введи вторую цифру(0-9):")
    val d2 = readln().toIntOrNull()

    if (d1 == null || d2 == null || d1 !in 0..9 || d2 !in 0..9) {
        println("Ошибка: введите корректные цифры от 0 до 9")
        return
    }

    val num1 = d1 * 10 + d2
    val num2 = d2 * 10 + d1

    if (num1 % 2 == 1) println(num1)
    else if (num2 % 2 == 1) println(num2)
    else println("Нечетное число сделать нельзя")
}
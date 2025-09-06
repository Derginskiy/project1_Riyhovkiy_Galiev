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
    val n = readln().toInt()
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
    println("Введи пример:")
    val parts = readln().split(" ")
    val a = parts[0].toDouble()
    val b = parts[2].toDouble()
    val op = parts[1]

    when (op) {
        "+" -> println(a + b)
        "-" -> println(a - b)
        "*" -> println(a * b)
        "/" -> println(a / b)
    }
}

fun task5() {
    println("=== Поиск степени ===")
    println("Введи число и основание (например: 8 2):")
    val parts = readln().split(" ")
    val n = parts[0].toInt()
    val x = parts[1].toInt()
    var y = 0
    var power = 1

    while (power < n) {
        power *= x
        y++
    }

    if (power == n) println(y) else println("Нет целого показателя")
}

fun task6() {
    println("=== Создание нечетного числа ===")
    println("Введи первую цифру(0-9):")
    val d1 = readln().toInt()
    println("Введи вторую цифру(0-9):")
    val d2 = readln().toInt()

    val num1 = d1 * 10 + d2
    val num2 = d2 * 10 + d1

    if (num1 % 2 == 1) println(num1)
    else if (num2 % 2 == 1) println(num2)
    else println("Нечетное число сделать нельзя")
}
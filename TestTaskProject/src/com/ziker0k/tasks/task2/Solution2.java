package com.ziker0k.tasks.task2;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Создайте программу, которая будет вычислять и выводить на экран простые множители,
 * из которых состоит целое число, введенное пользователем.
 * Если введенное число не целое, то нужно сообщать пользователю об ошибке.
 */

public class Solution2 {
    public static void main(String[] args) {
        // Сообщение для пользователя
        System.out.println("""
                Введите:
                end - для завершения программы
                (любое целое число) - для разложения его на простые множители""");
        // Запуск
        startChat();
    }

    // Метод разложения на множители
    public static String factorize(long number) {
        // StringJoiner для удобства вывода и читаемости
        StringJoiner stringJoiner = new StringJoiner(" * ", number + " = ", "");
        if (number == 1)
            stringJoiner.add(String.valueOf(number));

        for (int i = 2; i <= Math.sqrt(number); i++) {
            while (number % i == 0) {
                stringJoiner.add(String.valueOf(i));
                number /= i;
            }
        }

        if (number != 1) {
            stringJoiner.add(String.valueOf(number));
        }

        return stringJoiner.toString();
    }

    // Метод старта общения с пользователем
    private static void startChat() {
        // Создаем объект Scanner для чтения пользовательского ввода
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                // Получаем ввод пользователя
                String nextLine = scanner.nextLine();
                // Проверяем, является ли ввод командой завершения
                if (nextLine.equals("end")) break;
                try {
                    // Пытаемся преобразовать в long
                    long value = Long.parseLong(nextLine);
                    // Проверка на положительность
                    if (isPositive(value))
                        // Печать результата
                        System.out.println(factorize(value));
                    else
                        // Сообщение об ошибке
                        System.out.println("Отрицательное число нельзя разложить на простые множители!");
                } catch (NumberFormatException ex) {
                    // Сообщение об ошибке
                    System.out.println("Введенная строка не является целым числом!");
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    // Проверка положительное ли число
    public static boolean isPositive(long number) {
        return number >= 0;
    }
}

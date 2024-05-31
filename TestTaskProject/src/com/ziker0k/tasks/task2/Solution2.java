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
        System.out.println("""
                Введите:
                end - для завершения программы
                (любое целое число) - для разложения его на простые множители""");
        startChat();
    }

    public static String factorize(long number) {
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

    private static void startChat() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String nextLine = scanner.nextLine();
                if (nextLine.equals("end")) break;
                try {
                    long value = Long.parseLong(nextLine);
                    if (isPositive(value))
                        System.out.println(factorize(value));
                    else
                        System.out.println("Отрицательное число нельзя разложить на простые множители!");
                } catch (NumberFormatException ex) {
                    System.out.println("Введенная строка не является целым числом!");
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static boolean isPositive(long number) {
        return number >= 0;
    }
}

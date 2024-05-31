package com.ziker0k.tasks.task3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Создайте программу, которая будет:
 * подсчитывать количество гласных в словах
 * выводить слова отсортированным списком по количеству гласных (сначала те, у которых больше гласных)
 * делать первую гласную букву в слове заглавной
 * Предложение вводится пользователем вручную русскими буквами. Разделитель пробел (“ ”).
 */

public class Solution3 {
    public static void main(String[] args) {
        System.out.println("Введите предложение:");
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            // Присваиваем переменной значение, которое вернулось из функции
            String result = getResult(input);
            System.out.println(result);
        }
    }

    // Метод преобразования ввода в искомый результат
    private static String getResult(String input) {
        // Сплитуем и берем поток
        return Arrays.stream(input.trim().split(" "))
                // Преобразуем в нижний регистр
                .map(String::toLowerCase)
                // Преобразуем 1 гласную в верхний регистр
                .map(TextUtil::upperFirstVowel)
                // Сортируем по количеству гласных
                .sorted(Comparator.comparing(TextUtil::countVowels).reversed())
                // Собираем в строку
                .collect(Collectors.joining(System.lineSeparator()));
    }
}

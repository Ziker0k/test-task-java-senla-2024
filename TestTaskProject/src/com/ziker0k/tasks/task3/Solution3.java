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
            String result = getResult(input);
            System.out.println(result);
        }
    }

    private static String getResult(String input) {
        return Arrays.stream(input.trim().split(" "))
                .map(String::toLowerCase)
                .map(TextUtil::upperFirstVowel)
                .sorted(Comparator.comparing(TextUtil::countVowels).reversed())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}

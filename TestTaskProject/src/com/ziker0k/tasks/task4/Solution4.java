package com.ziker0k.tasks.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Создайте программу, которая будет получать число и печатать его в следующем формате
 * (формы цифр можно придумать свои, главное, чтобы они читались на экране):
 * <p>
 * (*) Дополнительно:
 * сделайте так, чтобы наибольшая цифра состояла не из ‘*’, а из соответствующих маленьких (обычных) цифр.
 */

public class Solution4 {
    public static void main(String[] args) {
        // Печатаем инструкции для пользователя
        System.out.println("""
                Введите число, чтобы представить его в виде символов ASCII.
                Или end для завершения программы.
                """);

        // Создаем объект Scanner для чтения пользовательского ввода
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                // Получаем ввод пользователя
                String userInput = getUserInput(scanner);
                // Проверяем, является ли ввод командой завершения
                if (userInput.equals("end")) break;

                try {
                    // Преобразуем ввод пользователя в список объектов Number
                    List<Number> numbers = parseInput(userInput);
                    // Находим максимальную цифру во введенных числах
                    int maxDigit = findMaxDigit(numbers);
                    // Генерируем представление ASCII для введенных чисел
                    String asciiRepresentation = generateAsciiRepresentation(numbers, maxDigit);
                    // Вывод в консоль
                    System.out.println(asciiRepresentation);
                } catch (NumberFormatException exception) {
                    // В случае ошибки формата числа выводим сообщение об ошибке
                    System.out.println("Неправильный ввод!");
                }
            }
        }
    }

    // Метод для запроса ввода у пользователя
    private static String getUserInput(Scanner scanner) {
        System.out.println("Введите число или end: ");
        return scanner.nextLine();
    }

    // Метод для преобразования ввода пользователя в список объектов Number
    private static List<Number> parseInput(String userInput) throws NumberFormatException {
        List<Number> numbers = new ArrayList<>();
        for (char c : userInput.toCharArray()) {
            int digit = Character.getNumericValue(c);
            if (digit < 0 || digit > 9) {
                throw new NumberFormatException();
            }
            numbers.add(Number.CASHED_VALUES.get(digit));
        }
        return numbers;
    }

    // Метод для нахождения максимальной цифры среди введенных чисел
    private static int findMaxDigit(List<Number> numbers) {
        int max = 0;
        for (Number number : numbers) {
            int value = number.ordinal();
            max = Math.max(max, value);
        }
        return max;
    }

    // Метод для генерации представления ASCII для введенных чисел
    private static String generateAsciiRepresentation(List<Number> numbers, int maxDigit) {
        StringBuilder asciiRepresentation = new StringBuilder();
        for (int i = 0; i < numbers.get(0).getValue().length; i++) {
            StringBuilder line = new StringBuilder();
            for (Number number : numbers) {
                String digitRepresentation = number.getValue()[i];
                if (number == Number.CASHED_VALUES.get(maxDigit)) {
                    digitRepresentation = digitRepresentation.replace('*', (char) ('0' + maxDigit));
                }
                line.append(digitRepresentation).append("  ");
            }
            asciiRepresentation.append(line).append("\n");
        }
        return asciiRepresentation.toString();
    }
}

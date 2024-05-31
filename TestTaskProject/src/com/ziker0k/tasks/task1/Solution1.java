package com.ziker0k.tasks.task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Напишите программу, которая возвращает сумму цифр, присутствующих в данной строке.
 * Если цифр нет, то возвращаемая сумма должна быть равна 0.
 */

public class Solution1 {
    public static void main(String[] args) {
        // Вводная строка
        String inputString = """
                123fgdkgjfkgkf123jfkgjdfg
                123jjjjhHGHGHGHKD.....123
                """;
        // Расчет суммы
        int result = getSum(inputString);
        assert (result == 24);
        // Печатаем в консоль
        System.out.println(result);
    }

    // Метод расчета суммы чисел
    private static int getSum(String string) {
        int sum = 0;
        // Паттерн для поиска цифр
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(string);
        // Проходим по каждой цифре и добавляем в сумму
        while (matcher.find()) {
            sum += Integer.parseInt(matcher.group());
        }
        // Возвращаем сумму чисел
        return sum;
    }
}

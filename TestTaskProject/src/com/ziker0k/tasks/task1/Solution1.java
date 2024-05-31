package com.ziker0k.tasks.task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Напишите программу, которая возвращает сумму цифр, присутствующих в данной строке.
 * Если цифр нет, то возвращаемая сумма должна быть равна 0.
 */

public class Solution1 {
    public static void main(String[] args) {
        String inputString = """
                123fgdkgjfkgkf123jfkgjdfg
                123jjjjhHGHGHGHKD.....123
                """;
        int result = getSum(inputString);
        assert (result == 24);
        System.out.println(result);
    }

    private static int getSum(String string) {
        int sum = 0;
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            sum += Integer.parseInt(matcher.group());
            System.out.println(matcher.group());
        }
        return sum;
    }
}

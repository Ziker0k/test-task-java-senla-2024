package com.ziker0k.tasks.task3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TextUtil {

    private TextUtil() {
    }

    public static Integer countVowels(String word) {
        return word.replaceAll("[^iu:аеёиоуыэюя]*", "").length();
    }

    public static String upperFirstVowel(String word) {
        String result;
        String regex = "^(.*?)?([аеёиоуыэюя])(.*?)?$";
        Matcher matcher = Pattern.compile(regex).matcher(word);
        if (matcher.find()) {
            result = matcher.group(1) +
                    matcher.group(2).toUpperCase() +
                    matcher.group(3);
        } else {
            result = word;
        }
        return result;
    }
}

package com.ziker0k.tasks.task4;

import java.util.Arrays;
import java.util.List;

public enum Number {
    VALUE0("""
             **\s
            *  *
            *  *
            *  *
             **\s"""),
    VALUE1("""
              *\s
             **\s
              *\s
              *\s
             ***
            """),
    VALUE2("""
             **\s
            *  *
              *\s
             * \s
            ****"""),
    VALUE3("""
            ****
               *
              *\s
               *
            ****"""),
    VALUE4("""
             * *
            *  *
            ****
               *
               *"""),
    VALUE5("""
            ****
            *  \s
            ****
               *
            ****"""),
    VALUE6("""
             ***
            *  \s
            ****
            *  *
             **\s"""),
    VALUE7("""
            ****
              *\s
             * \s
             * \s
             * \s"""),
    VALUE8("""
             **\s
            *  *
             **\s
            *  *
             **\s"""),
    VALUE9("""
             **\s
            *  *
             ***
               *
             **\s""");

    public static final List<Number> CASHED_VALUES = Arrays.asList(values());
    private final String[] value;

    Number(String value) {
        this.value = value.split(System.lineSeparator());
    }

    public String[] getValue() {
        return value;
    }
}

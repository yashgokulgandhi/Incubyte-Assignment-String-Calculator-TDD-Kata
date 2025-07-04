package com.incubyte;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int add(String input) {
        if (input == null || input.isEmpty()) return 0;

        input = input.replaceAll("\\n", ",");

        if (input.startsWith("//")) {
            String delim = Pattern.quote(input.substring(2, 3));
            input = input.substring(4);
            return Arrays.stream(input.split(delim)).mapToInt(Integer::parseInt).sum();
        }

        return Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
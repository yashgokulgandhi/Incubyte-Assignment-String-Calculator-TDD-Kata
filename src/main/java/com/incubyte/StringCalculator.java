package com.incubyte;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    public static int add(String input) {
        if (input == null || input.isEmpty()) return 0;


        input = input.replaceAll("\\n", ",");

        if (input.startsWith("//")) {
            String delim = Pattern.quote(input.substring(2, 3));
            input = input.substring(4);
            return Arrays.stream(input.split(delim)).mapToInt(Integer::parseInt).sum();
        }

        List<Integer> list = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> negatives = list.stream().filter(n -> n < 0).collect(Collectors.toList());
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives);
        }

        return list.stream().filter(n -> n <= 1000).mapToInt(i -> i).sum();
    }
}
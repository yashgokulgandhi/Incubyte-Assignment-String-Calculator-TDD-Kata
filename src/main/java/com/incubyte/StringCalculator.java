package com.incubyte;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    public static int add(String input) {
        if (input == null || input.isEmpty()) return 0;

        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf('\n');
            String delimiterSection = input.substring(2, newlineIndex);
            input = input.substring(newlineIndex + 1);

            String delimiter;
            if (delimiterSection.startsWith("[") && delimiterSection.endsWith("]")) {
                delimiter = Pattern.quote(delimiterSection.substring(1, delimiterSection.length() - 1));
            } else {
                delimiter = Pattern.quote(delimiterSection.substring(0, 1));
            }

            String[] tokens = input.split(delimiter);
            List<Integer> list = Arrays.stream(tokens)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            List<Integer> negatives = list.stream().filter(n -> n < 0).collect(Collectors.toList());
            if (!negatives.isEmpty()) {
                throw new IllegalArgumentException("Negatives not allowed: " + negatives);
            }

            return list.stream().filter(n -> n <= 1000).mapToInt(i -> i).sum(); // ✅ return here
        }

        // Normal case: no custom delimiter
        input = input.replaceAll("\\n", ",");
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
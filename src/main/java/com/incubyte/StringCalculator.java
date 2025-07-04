package com.incubyte;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    private static int callCount = 0;

    public static int add(String input) {

        callCount++;
        if (input == null || input.isEmpty()) return 0;

        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf('\n');
            String delimiterSection = input.substring(2, newlineIndex);
            input = input.substring(newlineIndex + 1);

            String delimiterRegex;
            if (delimiterSection.startsWith("[") && delimiterSection.endsWith("]")) {
                // Support one or more custom delimiters
                List<String> delims = Arrays.stream(delimiterSection.split("\\]\\["))
                        .map(s -> Pattern.quote(s.replace("[", "").replace("]", "")))
                        .collect(Collectors.toList());
                // ✅ include default delimiters
                delimiterRegex = String.join("|", delims) + "|,|\n";
            } else {
                delimiterRegex = Pattern.quote(delimiterSection);
            }


            String[] tokens = input.split(delimiterRegex);
            List<Integer> list = Arrays.stream(tokens)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            List<Integer> negatives = list.stream().filter(n -> n < 0).collect(Collectors.toList());
            if (!negatives.isEmpty()) {
                throw new IllegalArgumentException("Negatives not allowed: " + negatives);
            }

            return list.stream().filter(n -> n <= 1000).mapToInt(i -> i).sum();
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

    public static int getCalledCount() {
        return callCount;
    }

}
package com.incubyte;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void emptyStringShouldReturnZero() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""), "Empty string should return 0");
    }
}

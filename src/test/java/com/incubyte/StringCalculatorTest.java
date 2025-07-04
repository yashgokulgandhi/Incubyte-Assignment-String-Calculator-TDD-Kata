package com.incubyte;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void emptyStringShouldReturnZero() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""), "Empty string should return 0");
    }

    @Test
    public void shouldSumTwoCommaSeparatedNumbers() {
        assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    public void shouldSupportMultipleNumbers() {
        assertEquals(10, StringCalculator.add("1,2,3,4"));
    }

    @Test
    public void shouldSupportNewlineDelimiter() {
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test
    public void shouldSupportSingleCustomDelimiter() {
        assertEquals(3, StringCalculator.add("//;\n1;2"));
    }

    @Test
    public void shouldThrowExceptionForNegativeNumbers() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> StringCalculator.add("-1,2,-3")
        );
        assertTrue(ex.getMessage().contains("-1") && ex.getMessage().contains("-3"));
    }

    @Test
    public void shouldIgnoreNumbersGreaterThan1000() {
        assertEquals(2, StringCalculator.add("1001,2"));
    }

    @Test
    public void shouldSupportDelimiterOfAnyLength() {
        assertEquals(6, StringCalculator.add("//[***]\n1***2***3"));
    }

}

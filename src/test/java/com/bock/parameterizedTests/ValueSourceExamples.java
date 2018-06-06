package com.bock.parameterizedTests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class ValueSourceExamples {


    @ParameterizedTest(name = "{arguments} is not null")
    @ValueSource(strings = {"Hello", "JUnit"})
    @DisplayName("strings value source")
    void stringValueSource(String s) {
        assertNotNull(s);
    }

    @ParameterizedTest(name = "{arguments} > 1")
    @ValueSource(doubles = {1.3, 2.4, 333.333333})
    @DisplayName("doubles value source")
    void doubleValueSource(double d) {
        assertTrue(d > 1);
    }


    @ParameterizedTest(name = "{arguments} divisible by 7")
    @ValueSource(ints = {49, 70, 707})
    @DisplayName("ints value source")
    void intValueSource(int i) {
        assertEquals(0, i % 7);
    }


    @ParameterizedTest(name = "{arguments} is too big to be an int")
    @ValueSource(longs = {3147483647L, 40000000000L})
    @DisplayName("longs value source")
    void longValueSource(Long l) {
        assertThrows(NumberFormatException.class,
                () -> Integer.parseInt(l.toString())
        );
    }

    @ParameterizedTest(name = "{arguments} is even")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("int is even")
    void failingValueSource(int i) {
        assertEquals(0, i % 2);
    }

    @Test
    @DisplayName("where are all my tests?")
    void nonParameterizedTest() {
        IntStream.range(0, 10).forEach(
                (i) -> assertEquals(0, i % 2)
        );
    }
}

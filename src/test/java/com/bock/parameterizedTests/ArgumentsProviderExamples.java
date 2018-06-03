package com.bock.parameterizedTests;

import com.bock.parameterizedTests.argumentsProvider.LetterArgumentsProvider;
import com.bock.parameterizedTests.argumentsProvider.RangeSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArgumentsProviderExamples {

    @ParameterizedTest
    @ArgumentsSource(LetterArgumentsProvider.class)
    public void upperCase(char c) {
        assertTrue(Character.isUpperCase(c));
    }


    @ParameterizedTest
    @RangeSource
    public void lessThan50(int i) {
        assertTrue(i < 50);
    }


    @ParameterizedTest
    @RangeSource(min = 24, max = 200, step = 8)
    public void divisibleBy16(int i) {
        assertEquals(0, i % 16);
    }
}

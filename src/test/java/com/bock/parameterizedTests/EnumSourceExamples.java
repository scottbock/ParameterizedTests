package com.bock.parameterizedTests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnumSourceExamples {

    @ParameterizedTest(name = "Short version of {arguments} is 3 characters long")
    @EnumSource(DayOfWeek.class)
    void shortDay(DayOfWeek day) {
        String shortDay = day.getDisplayName(TextStyle.SHORT, Locale.getDefault());

        assertEquals(3, shortDay.length());
    }

}

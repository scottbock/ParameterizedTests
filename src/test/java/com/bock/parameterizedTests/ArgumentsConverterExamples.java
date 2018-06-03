package com.bock.parameterizedTests;

import com.bock.parameterizedTests.argumentConverter.CarConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArgumentsConverterExamples {



    @ParameterizedTest
    @CsvSource(value = {"true", "false", "true", "true"})
    void defaultConverterBoolean(boolean b) {
        assertTrue(b);
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "0", "1", "1"})
    void defaultConverterByte(byte b) {
        assertEquals(1, b);
    }

    @ParameterizedTest
    @CsvSource(value = {"t", "f", "t", "t"})
    void defaultConverterChar(char c) {
        assertEquals('t', c);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 1, 1, 1.0, 1.0", "1, 1, 2, 1.0, 1.5"})
    void defaultConverterNumbers(short s, int i, long l, float f, double d) {
        assertEquals(1, s);
        assertEquals(1, i);
        assertEquals(1L, l);
        assertEquals(1.0, f);
        assertEquals(1.0, d);
    }

    @ParameterizedTest
    @CsvSource(value = {"SECONDS", "MINUTES", "SECONDS"})
    void defaultConverterEnum(TimeUnit t) {
        assertEquals(TimeUnit.SECONDS, t);
    }


    @ParameterizedTest
    @CsvSource(value = {"./src/test/resources/5000 Sales Records.csv", "/NotAFile.csv", "./src/test/resources/5000 Sales Records.csv"})
    void defaultConverterFile(File f) {
        System.out.println(f.getAbsolutePath());
        assertTrue(f.exists());
    }

    @ParameterizedTest
    @CsvSource(value = {"123.456e789, 1234567890123456789", "123.456e78, 123456789012345678", "123.456e789, 1234567890123456789"})
    void defaultConverterBigs(BigDecimal bd, BigInteger bi) {
        assertEquals(new BigDecimal("123.456e789"), bd);
        assertEquals(new BigInteger("1234567890123456789"), bi);
    }

    /********************************
     * There are a bunch more
     *
     *  java.net.URI  "http://junit.org/" → URI.create("http://junit.org/")
     *
     *  java.net.URL  "http://junit.org/" → new URL("http://junit.org/")
     *
     *  java.nio.charset.Charset  "UTF-8" → Charset.forName("UTF-8")
     *
     *  java.nio.file.Path  "/path/to/file" → Paths.get("/path/to/file")
     *
     *  java.time.Instant  "1970-01-01T00:00:00Z" → Instant.ofEpochMilli(0)
     *
     *  java.time.LocalDateTime  "2017-03-14T12:34:56.789" → LocalDateTime.of(2017, 3, 14, 12, 34, 56, 789_000_000)
     *
     *  java.time.LocalDate  "2017-03-14" → LocalDate.of(2017, 3, 14)
     *
     *  java.time.LocalTime  "12:34:56.789" → LocalTime.of(12, 34, 56, 789_000_000)
     *
     *  java.time.OffsetDateTime  "2017-03-14T12:34:56.789Z" → OffsetDateTime.of(2017, 3, 14, 12, 34, 56, 789_000_000, ZoneOffset.UTC)
     *
     *  java.time.OffsetTime  "12:34:56.789Z" → OffsetTime.of(12, 34, 56, 789_000_000, ZoneOffset.UTC)
     *
     *  java.time.YearMonth  "2017-03" → YearMonth.of(2017, 3)
     *
     *  java.time.Year  "2017" → Year.of(2017)
     *
     *  java.time.ZonedDateTime  "2017-03-14T12:34:56.789Z" → ZonedDateTime.of(2017, 3, 14, 12, 34, 56, 789_000_000, ZoneOffset.UTC)
     *
     *  java.util.Currency  "JPY" → Currency.getInstance("JPY")
     *
     *  java.util.Locale  "en" → new Locale("en")
     *
     *  java.util.UUID  "d043e930-7b3b-48e3-bdbe-5a3ccfb833db" → UUID.fromString("d043e930-7b3b-48e3-bdbe-5a3ccfb833db")
     *
      ********************************/

    @ParameterizedTest
    @CsvSource(value = {"Of Mice and Men", "On the Road", "Of Mice and Men"})
    void defaultConverterFactoryMethod(Book b) {
        assertEquals("Of Mice and Men", b.getTitle());
    }

    @ParameterizedTest
    @CsvSource(value = {"Field & Stream", "Home & Garden", "Field & Stream"})
    void defaultConverterFactoryConstructor(Magazine m) {
        assertEquals("Field & Stream", m.getTitle());
    }


    @ParameterizedTest
    @CsvSource(value = {"Ford:Mustang", "Ford:Explorer", "Ford:Mustang"})
    void testWithExplicitArgumentConversion(@ConvertWith(CarConverter.class) Car car) {
        assertEquals("Ford", car.getMake());
        assertEquals("Mustang", car.getModel());
    }

}

package com.bock.parameterizedTests;

import java.util.stream.Stream;

public class ExternalMethodSource {

    static Stream<String> blankStrings() {
        return Stream.of("", " ", " \n ", "\t\t\r");
    }
}

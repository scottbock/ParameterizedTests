package com.bock.parameterizedTests.argumentConverter;

import com.bock.parameterizedTests.Car;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

public class CarConverter implements ArgumentConverter {

    @Override
    public Object convert(Object o, ParameterContext parameterContext) throws ArgumentConversionException {
        String[] split = ((String)o).split(":");
        Car c = new Car();

        c.setMake(split[0]);
        c.setModel(split[1]);

        return c;
    }
}

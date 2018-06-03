package com.bock.parameterizedTests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvSourceExamples {

    @ParameterizedTest(name = "{0} and {1} start with the same letter")
    @CsvSource(value = {"Miles, Morales", "Sue, Storm", "Doctor, Doom", "Peter, Parker", "Pepper, Potts", "Bucky, Barnes"})
    void marvelNames(String firstName, String lastName) {

        assertEquals(firstName.charAt(0), lastName.charAt(0));

    }

    @ParameterizedTest(name = "{8} Units Sold * ${10} Unit Cost = ${12} Total Cost")
    @CsvFileSource(resources= "/5000 Sales Records.csv", numLinesToSkip = 1)
    void cost(String region, String country, String itemType, String salesChannel, char orderPriority, String orderDate, int orderID, String shipDate, int unitsSold, double unitPrice, double unitCost, double totalRevenue, double totalCost, double totalProfit){
        double calculatedTotalCost = Math.round(100 * unitCost * unitsSold) / 100.0;

        assertEquals(totalCost, calculatedTotalCost);
    }

    @ParameterizedTest(name = "{8} Units Sold * ${9} Unit Price = ${11} Total Revenue")
    @CsvFileSource(resources= "/5000 Sales Records.csv", numLinesToSkip = 1)
    void revenue(String region, String country, String itemType, String salesChannel, char orderPriority, String orderDate, int orderID, String shipDate, int unitsSold, double unitPrice, double unitCost, double totalRevenue, double totalCost, double totalProfit){
        double calculatedTotalRevenue = Math.round(100 * unitPrice * unitsSold) / 100.0;

        assertEquals(totalRevenue, calculatedTotalRevenue);
    }

    @ParameterizedTest(name = "{8} Units Sold * (${10} Unit Price - ${9} Unit Cost) = ${11} Total Profit")
    @CsvFileSource(resources= "/5000 Sales Records.csv", numLinesToSkip = 1)
    void profit(String region, String country, String itemType, String salesChannel, char orderPriority, String orderDate, int orderID, String shipDate, int unitsSold, double unitPrice, double unitCost, double totalRevenue, double totalCost, double totalProfit){
        double calculatedTotalProfit = Math.round(100 * ((unitPrice - unitCost) * unitsSold)) / 100.0;

        assertEquals(totalProfit, calculatedTotalProfit);
    }

}

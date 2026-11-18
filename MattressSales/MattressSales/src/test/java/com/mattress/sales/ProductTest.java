package com.mattress.sales;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTest {

    private Product product;

    // Same data as the sample screenshot
    @BeforeEach
    public void setUp() {
        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] sales = {
            {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
        };
        product = new Product(names, sales);
    }

    // Unit Test 1
    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        int expected = 153;
        int actual = product.GetTotalProductsSold();
        assertEquals(expected, actual);
    }

    // Unit Test 2
    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        double expected = 17.0;
        double actual = product.GetAverageProductSold();
        assertEquals(expected, actual, 0.001);
    }

    // Extra test for the most popular product
    @Test
    public void GetMostPopularProduct_WithValidData_ReturnsCorrectValue() {
        String expected = "Cozy Nights Monarch(25)";
        String actual = product.GetMostPopularProduct();
        assertEquals(expected, actual);
    }
}

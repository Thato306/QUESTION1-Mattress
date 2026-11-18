package com.mattress.sales;

import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        String[] productNames = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        int numberOfMonths = 3;

        int[][] sales = new int[productNames.length][numberOfMonths];

        for (int p = 0; p < productNames.length; p++) {
            for (int m = 0; m < numberOfMonths; m++) {
                sales[p][m] = readSales(m + 1, productNames[p]);
            }
            System.out.println();
        }

        Product product = new Product(productNames, sales);
        PrintProduct printer = new PrintProduct(product);

        printer.printHeader();
        printer.printTotalProductSales();
        printer.printAverageProductSales();
        printer.printMostPopularProduct();
    }

    private static int readSales(int month, String productName) {
        while (true) {
            System.out.print("Enter number of sales for month " + month + " for " + productName + " mattress: ");
            String text = input.nextLine();
            try {
                int value = Integer.parseInt(text.trim());
                if (value >= 0) {
                    return value;
                }
                System.out.println("Sales cannot be negative. Try again.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }
}

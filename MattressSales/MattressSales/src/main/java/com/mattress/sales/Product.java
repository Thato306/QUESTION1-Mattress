package com.mattress.sales;

/**
 * Holds the sales data and does the report calculations (Q.1.2).
 *
 * productNames is a single-dimensional array (one name per product).
 * sales is a two-dimensional array: sales[product][month].
 */
public class Product implements IProduct {

    private String[] productNames;
    private int[][] sales;

    public Product(String[] productNames, int[][] sales) {
        this.productNames = productNames;
        this.sales = sales;
    }

    // Adds up every number in the 2D array
    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int p = 0; p < sales.length; p++) {
            for (int m = 0; m < sales[p].length; m++) {
                total = total + sales[p][m];
            }
        }
        return total;
    }

    // Total sold divided by the number of entries (products x months)
    @Override
    public double GetAverageProductSold() {
        int count = 0;
        for (int p = 0; p < sales.length; p++) {
            count = count + sales[p].length;
        }

        if (count == 0) {
            return 0;
        }
        return (double) GetTotalProductsSold() / count;
    }

    // Finds the product with the highest total sales.
    // Returns the name with that product's best month in brackets, e.g. Cozy Nights Monarch(25)
    @Override
    public String GetMostPopularProduct() {
        int bestProduct = 0;
        int bestTotal = 0;

        for (int p = 0; p < sales.length; p++) {
            int productTotal = 0;
            for (int m = 0; m < sales[p].length; m++) {
                productTotal = productTotal + sales[p][m];
            }

            // Only a strictly higher total replaces the winner, so ties keep the first product
            if (p == 0 || productTotal > bestTotal) {
                bestTotal = productTotal;
                bestProduct = p;
            }
        }

        // Highest single-month figure for the winning product (matches the sample screenshot)
        int bestMonth = 0;
        for (int m = 0; m < sales[bestProduct].length; m++) {
            if (sales[bestProduct][m] > bestMonth) {
                bestMonth = sales[bestProduct][m];
            }
        }

        return productNames[bestProduct] + "(" + bestMonth + ")";
    }
}

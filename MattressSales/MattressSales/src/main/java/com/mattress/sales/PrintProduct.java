package com.mattress.sales;

public class PrintProduct {

    private IProduct product;

    public PrintProduct(IProduct product) {
        this.product = product;
    }

    public void printHeader() {
        System.out.println();
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println();
        System.out.println("**********************************************");
    }

    public void printTotalProductSales() {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    public void printAverageProductSales() {
        double average = product.GetAverageProductSold();

        if (average == Math.floor(average)) {
            System.out.println("AVERAGE PRODUCT SALES: " + (int) average);
        } else {
            System.out.println("AVERAGE PRODUCT SALES: " + String.format(java.util.Locale.US, "%.2f", average));
        }
    }

    public void printMostPopularProduct() {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }
}

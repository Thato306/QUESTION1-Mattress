package com.mattress.sales;

/**
 * Interface that the Product class must implement (Q.1.2).
 */
public interface IProduct {

    int GetTotalProductsSold();

    double GetAverageProductSold();

    String GetMostPopularProduct();
}

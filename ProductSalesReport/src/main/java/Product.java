/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsalesreport;
/**
 *
 * @author Student
 */
public class Product implements IProduct {

    // Single-dimensional array for product names
    private String[] productNames = {
        "Cozy Nights Monarch mattress",
        "Restonic Barbados mattress",
        "Sealy Phuket mattress"
    };

    // Two-dimensional array for monthly sales
    private int[][] sales;

    // Constructor
    public Product(int[][] sales) {
        this.sales = sales;
    }

    // Calculate total products sold
    @Override
    public int GetTotalProductsSold() {

        int total = 0;

        for (int row = 0; row < sales.length; row++) {

            for (int col = 0; col < sales[row].length; col++) {

                total = total + sales[row][col];
            }
        }

        return total;
    }

    // Calculate average products sold
    @Override
    public double GetAverageProductSold() {

        int total = GetTotalProductsSold();

        return (double) total / 9;
    }

    // Find the most popular product
    @Override
    public String GetMostPopularProduct() {

        int highestTotal = 0;
        int popularIndex = 0;

        // Calculate total sales for each product
        for (int row = 0; row < sales.length; row++) {

            int productTotal = 0;

            for (int col = 0; col < sales[row].length; col++) {

                productTotal += sales[row][col];
            }

            if (productTotal > highestTotal) {

                highestTotal = productTotal;
                popularIndex = row;
            }
        }

        // Find the highest monthly sale
        int highestMonthlySale = 0;

        for (int col = 0; col < sales[popularIndex].length; col++) {

            if (sales[popularIndex][col] > highestMonthlySale) {

                highestMonthlySale = sales[popularIndex][col];
            }
        }

        return productNames[popularIndex]
                + "(" + highestMonthlySale + ")";
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsalesreport;


/**
 *
 * @author Student
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Single-dimensional array for product names
        String[] productNames = {

            "Cozy Nights Monarch mattress",
            "Restonic Barbados mattress",
            "Sealy Phuket mattress"

        };

        // Two-dimensional array for sales
        int[][] sales = new int[3][3];

        // Capture sales for three products and three months
        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                System.out.print(
                    "Enter number of sales for month "
                    + (col + 1)
                    + " for "
                    + productNames[row]
                    + ": "
                );

                sales[row][col] = input.nextInt();
            }

            System.out.println();
        }

        // Create Product object
        Product product = new Product(sales);

        // Create PrintProduct object
        PrintProduct report = new PrintProduct(product);

        // Display sales report
        report.PrintReport();

        input.close();
    }
}

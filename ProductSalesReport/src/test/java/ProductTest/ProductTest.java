/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProductTest;

/**
 *
 * @author Student
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    // Unit Test 1
    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {

        int[][] sales = {
            {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
        };

        Product product = new Product(sales);

        int expected = 153;

        int actual = product.GetTotalProductsSold();

        assertEquals(expected, actual);
    }

    // Unit Test 2
    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {

        int[][] sales = {
            {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
        };

        Product product = new Product(sales);

        double expected = 17.0;

        double actual = product.GetAverageProductSold();

        assertEquals(expected, actual, 0.001);
    }
}

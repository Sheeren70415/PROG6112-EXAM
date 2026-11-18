/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
@Test
public void GetVat_WithValidData_ReturnsCorrectValue() {

    ProductCalculations calculation =
        new ProductCalculations(3500);

    double expected = 525.0;

    double actual = calculation.GetVat();

    assertEquals(expected, actual, 0.001);
}
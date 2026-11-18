/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class ProductApp extends JFrame {

    // GUI components
    private JTextField txtCustomer;
    private JTextField txtPrice;
    private JComboBox<String> cmbProduct;
    private JButton btnProcess;

    public ProductApp() {

        setTitle("Product App");
        setSize(600, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        // File menu
        JMenu fileMenu = new JMenu("File");

        JMenuItem exitItem = new JMenuItem("Exit");

        exitItem.addActionListener(e -> System.exit(0));

        fileMenu.add(exitItem);

        // Tools menu
        JMenu toolsMenu = new JMenu("Tools");

        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");

        processItem.addActionListener(e -> processSale());
        clearItem.addActionListener(e -> clearFields());

        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);

        setJMenuBar(menuBar);

        // Main panel
        JPanel panel = new JPanel(new GridLayout(4, 2, 15, 20));

        panel.setBorder(
            BorderFactory.createEmptyBorder(40, 40, 40, 40)
        );

        // Customer name
        JLabel lblCustomer = new JLabel("Customer Name:");
        txtCustomer = new JTextField();

        // Product selection
        JLabel lblProduct = new JLabel("Select Product:");

        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        cmbProduct = new JComboBox<>(products);

        // Price
        JLabel lblPrice = new JLabel("Enter Price:");
        txtPrice = new JTextField();

        // Process button
        btnProcess = new JButton("PROCESS");

        btnProcess.addActionListener(e -> processSale());

        // Add components
        panel.add(lblCustomer);
        panel.add(txtCustomer);

        panel.add(lblProduct);
        panel.add(cmbProduct);

        panel.add(lblPrice);
        panel.add(txtPrice);

        panel.add(new JLabel(""));
        panel.add(btnProcess);

        add(panel);

        setVisible(true);
    }

    // Process button logic
    private void processSale() {

        try {

            String customer = txtCustomer.getText().trim();

            String product =
                cmbProduct.getSelectedItem().toString();

            if (customer.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please enter the customer name."
                );
                return;
            }

            double price = Double.parseDouble(
                txtPrice.getText().trim()
            );

            if (!Double.isFinite(price) || price < 0) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid positive price."
                );
                return;
            }

            // Create ProductCalculations object
            ProductCalculations calculations =
                new ProductCalculations(price);

            // Calculate amounts
            double vat = calculations.GetVat();

            double commission =
                calculations.GetCommission();

            double total = calculations.GetTotal();

            // Display results
            String message =
                "Customer Name: " + customer +
                "\nProduct: " + product +
                "\nVAT: R " + vat +
                "\nCOMMISSION: R " + commission +
                "\nTOTAL: R " + total;

            JOptionPane.showMessageDialog(
                this,
                message,
                "Message",
                JOptionPane.INFORMATION_MESSAGE
            );

            // Save information to data.txt
            saveToFile(customer, product, vat,
                       commission, total);

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                this,
                "Please enter a valid number for the price."
            );

        }
    }

    // Save information to file
    private void saveToFile(
        String customer,
        String product,
        double vat,
        double commission,
        double total
    ) {

        try {

            FileWriter writer =
                new FileWriter("data.txt", true);

            writer.write("DATA LOG\n");
            writer.write("************************************\n");

            writer.write("Customer Name: " + customer + "\n");
            writer.write("Product: " + product + "\n");
            writer.write("VAT: R " + vat + "\n");
            writer.write("COMMISSION: R " + commission + "\n");
            writer.write("TOTAL: R " + total + "\n");

            writer.write("************************************\n\n");

            writer.close();

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(
                this,
                "Error saving information to file."
            );

        }
    }

    // Clear button logic
    private void clearFields() {

        txtCustomer.setText("");
        txtPrice.setText("");

        cmbProduct.setSelectedIndex(0);

    }

    // Main method
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new ProductApp();
        });

    }
}


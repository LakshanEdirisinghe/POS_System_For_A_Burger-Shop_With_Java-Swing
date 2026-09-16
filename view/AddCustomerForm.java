package view;

import Controller.CustomerManager;
import model.Customer;

import javax.swing.*;
import java.awt.*;

public class AddCustomerForm extends JFrame {

    private final JTextField customerIdField = new JTextField(20);
    private final JTextField customerNameField = new JTextField(20);

    public AddCustomerForm() {
        setTitle("Add Customer");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setResizable(false);

        createForm();
    }

    private void createForm() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(8, 8, 8, 8);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        JLabel idLabel = new JLabel("Customer ID:");
        JLabel nameLabel = new JLabel("Customer Name:");

        JButton addButton = new JButton("Add Customer");
        JButton cancelButton = new JButton("Cancel");

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(idLabel, constraints);

        constraints.gridx = 1;
        panel.add(customerIdField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(nameLabel, constraints);

        constraints.gridx = 1;
        panel.add(customerNameField, constraints);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        panel.add(buttonPanel, constraints);

        add(panel);

        addButton.addActionListener(event -> addCustomer());
        cancelButton.addActionListener(event -> dispose());
    }

    private void addCustomer() {
        String customerId = customerIdField.getText().trim();
        String customerName = customerNameField.getText().trim();

        if (customerId.isEmpty() || customerName.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter both the customer ID and name.",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        Customer customer = new Customer(customerId, customerName);
        CustomerManager.addCustomer(customer);

        JOptionPane.showMessageDialog(
                this,
                "Customer added successfully.",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );

        clearFields();
    }

    private void clearFields() {
        customerIdField.setText("");
        customerNameField.setText("");
        customerIdField.requestFocus();
    }
}
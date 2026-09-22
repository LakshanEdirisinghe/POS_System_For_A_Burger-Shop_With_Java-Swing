package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Controller.PanelOparater;
import util.*;
// import Controller.PlaceOrderManager;
// import Controller.OrderS;
// import model.OrderItem;

import Controller.PlaceOrderManager;
import model.Order;

public class PlaceOrder extends JFrame {

    // === Panels ===
    private JPanel topPanel, subLeftPanel, subRightPanel;
    private JPanel subLeftNorthPanel, subLeftSouthPanel;
    private JPanel subRightCenterPanel, subRightSouthPanel;

    // === Labels ===
    private JLabel titleLabel;
    private JLabel orderId, orderIdValue;
    private JLabel customerId, qtyLabel, orderStatusLabel, orderStatusValue;
    private JLabel netTotal, netTotalValue;

    // === Text fields ===
    private JTextField customerIdValue, qtyField;

    // === Buttons ===
    private JButton placeOrderButton, bToHome, cancel;

    public PlaceOrder() {

        setTitle("Place Order");
        setSize(600, 223);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        headerPanel();
        leftFormPanel();
        rightButtonPanel();
        eventListeners();

    }

    private void headerPanel() {
        topPanel = new JPanel();
        topPanel.setBackground(new Color(0x2C3E50));

        titleLabel = Components.createStyledLabel("Place Order");
        titleLabel.setFont(new Font("Quicksand", Font.BOLD, 35));
        titleLabel.setForeground(Color.WHITE);
        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);
    }

    private void leftFormPanel() {

        subLeftPanel = new JPanel();
        subRightPanel = new JPanel();

        orderId = Components.createStyledLabel("Order ID:");
        orderIdValue = Components.createStyledLabel(PlaceOrderManager.getID() + "");

        customerId = Components.createStyledLabel("Customer ID:");
        customerIdValue = Components.createStyledTextField("C");

        qtyLabel = Components.createStyledLabel("Burger QTY:");
        qtyField = Components.createStyledTextField("");

        orderStatusLabel = Components.createStyledLabel("Order Status:");
        orderStatusValue = Components.createStyledLabel(" " + OrderStatus.PREPARING);

        subLeftNorthPanel = new JPanel();
        subLeftNorthPanel.setLayout(new GridLayout(2, 2));

        subLeftNorthPanel.add(orderId);
        subLeftNorthPanel.add(orderIdValue);
        subLeftNorthPanel.add(customerId);
        subLeftNorthPanel.add(customerIdValue);

        subLeftPanel.add(subLeftNorthPanel, BorderLayout.NORTH);

        subLeftSouthPanel = new JPanel();
        subLeftSouthPanel.setLayout(new GridLayout(2, 2));

        subLeftSouthPanel.add(qtyLabel);
        subLeftSouthPanel.add(qtyField);
        subLeftSouthPanel.add(orderStatusLabel);
        subLeftSouthPanel.add(orderStatusValue);

        subLeftPanel.add(subLeftSouthPanel, BorderLayout.SOUTH);

        add(subLeftPanel, BorderLayout.CENTER);

    }

    private void rightButtonPanel() {
        subRightPanel = new JPanel(new BorderLayout());

        subRightCenterPanel = new JPanel();
        subRightCenterPanel.setLayout(new GridLayout(3, 1));

        placeOrderButton = Components.createStyledButton("Place Order", new Color(0x27AE60));
        bToHome = Components.createStyledButton("Back to Home", new Color(0x3498DB));
        cancel = Components.createStyledButton("Cancel", new Color(0xE74C3C));

        subRightCenterPanel.add(placeOrderButton);
        subRightCenterPanel.add(bToHome);
        subRightCenterPanel.add(cancel);

        subRightPanel.add(subRightCenterPanel, BorderLayout.CENTER);

        subRightSouthPanel = new JPanel(new GridLayout(1, 2));

        netTotal = Components.createStyledLabel("Net Total:");
        netTotalValue = Components.createStyledLabel(" 0.00");

        subRightSouthPanel.add(netTotal);
        subRightSouthPanel.add(netTotalValue);

        subRightPanel.add(subRightSouthPanel, BorderLayout.SOUTH);

        add(subRightPanel, BorderLayout.EAST);
    }

    private void eventListeners() {
        qtyField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                PlaceOrderManager.netTotTigger(qtyField, netTotalValue);
            }
        });

        placeOrderButton.addActionListener(e -> {
            if (PlaceOrderManager.placeOrder(new Order(
                    orderIdValue.getText(),
                    customerIdValue.getText(),
                    OrderStatus.PREPARING,
                    Integer.parseInt(qtyField.getText().trim().isEmpty() ? "0" : qtyField.getText().trim())))) {

                JOptionPane.showMessageDialog(this, "Order placed successfully!", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to place order. Please check the input values.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            
           
            // PlaceOrderManager.displayOrderDetails();

        });

        bToHome.addActionListener(e -> PanelOparater.backToHome(this));
        cancel.addActionListener(e -> PanelOparater.backToHome(this));

    }

    private void clearFields(){

        orderIdValue.setText(PlaceOrderManager.getID());
        customerIdValue.setText("C");
        qtyField.setText("");
        netTotalValue.setText("0.00");
    }

}

package view;

import javax.swing.*;

import Controller.PanelOparater;
import model.Order;

import java.awt.*;
import java.awt.event.*;
import util.Components;
import Controller.UpdateDetailsController;

public class UpdateDetails extends JFrame {

    private JPanel topPanel, subCenterPanel, subCenterTopPanel, subLeftCCPanel, subBottomPanel;

    private JLabel titleLabel, customerIdLabel, customerNameLabel, qtyLabel, totalLabel, statusLabel;
    private JLabel customerNameValue, totalValue;
    private JTextField searchField, customerIdValue, qtyValue;
    private JButton back, searchBtn, btnUpdate;
    private JComboBox<String> comboBox;

    private Order selectedOrder;
    private final UpdateDetailsController controller = new UpdateDetailsController();

    public UpdateDetails() {

        setTitle("Update Order Details");
        setSize(950, 445);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        initializePanels();
        setLayouts();
        assemblePanels();

        hedding();
        searchBar();
        subBottomP();

        setVisible(true);
    }

    private void initializePanels() {
        topPanel = new JPanel();
        subCenterPanel = new JPanel();
        subCenterTopPanel = new JPanel();
        subLeftCCPanel = new JPanel();
        subBottomPanel = new JPanel();
    }

    private void setLayouts() {
        setLayout(new BorderLayout());

        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        subCenterPanel.setLayout(new BorderLayout());
        subCenterTopPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        subLeftCCPanel.setLayout(new GridLayout(0, 2, 10, 10));
        subBottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    }

    private void assemblePanels() {
        add(topPanel, BorderLayout.NORTH);
        add(subCenterPanel, BorderLayout.CENTER);
        add(subBottomPanel, BorderLayout.SOUTH);

        subCenterPanel.add(subCenterTopPanel, BorderLayout.NORTH);
        subCenterPanel.add(subLeftCCPanel, BorderLayout.CENTER);
    }

    public void hedding() {
        topPanel.setBackground(new Color(0x2C3E50));

        titleLabel = new JLabel("Update Order Details");
        titleLabel.setFont(new Font("Quicksand", Font.BOLD, 40));
        titleLabel.setForeground(Color.WHITE);

        topPanel.add(titleLabel);
    }

    public void searchBar() {
        searchField = Components.createStyledTextField("");
        searchField.setPreferredSize(new Dimension(220, 35));

        searchBtn = Components.createStyledButton("Search");

        searchBtn.addActionListener(e -> displayOrderDetails(
                controller.search(searchField.getText().trim())));

        subCenterTopPanel.add(searchField);
        subCenterTopPanel.add(searchBtn);
        subCenterPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        displayOrderDetails(null);
    }

    private void displayOrderDetails(Order order) {
        selectedOrder = order;
        subLeftCCPanel.removeAll();

        customerIdLabel = Components.createStyledLabel("Customer ID:");
        customerNameLabel = Components.createStyledLabel("Customer Name:");
        qtyLabel = Components.createStyledLabel("Burger QTY:");
        totalLabel = Components.createStyledLabel("Total:");
        statusLabel = Components.createStyledLabel("Order Status:");

        customerIdValue = Components.createStyledTextField(order == null ? "" : order.getCustId());
        customerNameValue = Components.createStyledLabel(order == null ? ""
                : ": " + controller.findCustomerName(order.getCustId()));
        qtyValue = Components.createStyledTextField(order == null ? "" : String.valueOf(order.getQuantity()));
        totalValue = Components.createStyledLabel(order == null ? "" : formatTotal(order.getQuantity()));
        comboBox = new JComboBox<>(new String[] { "PREPARING", "DELIVERED", "CANCELLED" });

        if (order != null) {
            comboBox.setSelectedItem(order.getOrderStatus().toString());
        }

        customerIdValue.setEnabled(order != null);
        qtyValue.setEnabled(order != null);
        comboBox.setEnabled(order != null);
        qtyValue.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                totalValue.setText(formatTotal(parseQuantity(qtyValue.getText())));
            }
        });

        subLeftCCPanel.setBorder(BorderFactory.createEmptyBorder(20, 150, 20, 150));
        subLeftCCPanel.add(customerIdLabel);
        subLeftCCPanel.add(customerIdValue);
        subLeftCCPanel.add(customerNameLabel);
        subLeftCCPanel.add(customerNameValue);
        subLeftCCPanel.add(qtyLabel);
        subLeftCCPanel.add(qtyValue);
        subLeftCCPanel.add(totalLabel);
        subLeftCCPanel.add(totalValue);
        subLeftCCPanel.add(statusLabel);
        subLeftCCPanel.add(comboBox);

        subLeftCCPanel.revalidate();
        subLeftCCPanel.repaint();
    }

    private int parseQuantity(String text) {
        try {
            return Integer.parseInt(text.trim());
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    private String formatTotal(int quantity) {
        return String.format(": %.2f LKR", quantity * 500.0);
    }

    private void subBottomP() {
        subBottomPanel.setBackground(Color.WHITE);

        back = Components.createStyledButton("Back to Home");

        back.addActionListener(e -> PanelOparater.backToHome(this));

        btnUpdate = Components.createStyledButton("Update", new Color(0, 177, 59));

        btnUpdate.addActionListener(e -> updateOrder());

        subBottomPanel.add(btnUpdate);
        subBottomPanel.add(back);
    }

    private void updateOrder() {
        UpdateDetailsController.UpdateResult result = controller.update(
                selectedOrder,
                customerIdValue.getText(),
                qtyValue.getText(),
                (String) comboBox.getSelectedItem());

        if (result != UpdateDetailsController.UpdateResult.SUCCESS) {
            showUpdateError(result);
            return;
        }

        displayOrderDetails(selectedOrder);
        JOptionPane.showMessageDialog(this, "Order updated successfully!", "Success",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void showUpdateError(UpdateDetailsController.UpdateResult result) {
        String message;
        switch (result) {
            case NO_ORDER_SELECTED:
                message = "Search for an order first.";
                break;
            case ORDER_NOT_PREPARING:
                message = "Only preparing orders can be updated.";
                break;
            case INVALID_QUANTITY:
                message = "Quantity must be greater than zero.";
                break;
            case CUSTOMER_NOT_FOUND:
                message = "Customer ID was not found.";
                break;
            default:
                message = "The order could not be updated.";
        }

        JOptionPane.showMessageDialog(this, message, "Validation Error", JOptionPane.WARNING_MESSAGE);
    }
}

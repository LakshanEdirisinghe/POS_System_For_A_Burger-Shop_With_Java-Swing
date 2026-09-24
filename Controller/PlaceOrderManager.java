package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

import model.Customer;
import model.Order;


public class PlaceOrderManager {

    private static final double BURGER_PRICE = 500.00;

    private static ArrayList<Order> placeOrderDataSet = new ArrayList<>();

    public static boolean placeOrder(Order order) {

        if (order.getQuantity() <= 0) {
            JOptionPane.showMessageDialog(null, "Quantity must be greater than zero.",
                    "Invalid quantity",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (order.getCustId().trim().substring(1).isEmpty()) {
            JOptionPane.showMessageDialog(null, "Customer ID cannot be empty.",
                    "Invalid Customer ID",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return placeOrderDataSet.add(order);

    }

    public static String getID() {

        return generateOrderID();
    }

    private static String generateOrderID() {

        int lastOrderId = placeOrderDataSet.size() + 1;
        int count = 0;
        int copyOfNum = lastOrderId;

        while (copyOfNum > 0) {
            count++;
            copyOfNum /= 10;
        }

        String stringNum = Integer.toString(lastOrderId);
        for (int x = 0; x < (3 - count); x++) {
            stringNum = "0" + stringNum;
        }
        String fullOrderId = "O" + stringNum;

        return fullOrderId;
    }

    public static void updateNetTotal(JTextField qtyField, JLabel netTotalValue) {
        String quantityText = qtyField.getText().trim();
        double quantity;

        try {
            quantity = quantityText.isEmpty() ? 0 : Double.parseDouble(quantityText);
        } catch (NumberFormatException ex) {
            quantity = 0;
        }

        double total = BURGER_PRICE * quantity;
        netTotalValue.setText(String.format(" %.2f", total));
    }

    public static void displayOrderDetails() {
        placeOrderDataSet.forEach(order -> {
            System.out.println("Order ID: " + order.getOrderId());
            System.out.println("Customer ID: " + order.getCustId());
            System.out.println("Quantity: " + order.getQuantity());
            System.out.println("Order Status: " + order.getOrderStatus());
            System.out.println("---------------------------");
        });
    }

    public static void netTotTigger(JTextField qtyField, JLabel netTotalValue) {

        String text = qtyField.getText().trim();

        if (text.isEmpty()) {
            netTotalValue.setText(" 0.00");
            return;
        }

        try {
            int qty = Integer.parseInt(text);

            if (qty > 0) {
                PlaceOrderManager.updateNetTotal(qtyField, netTotalValue);
            } else {
                netTotalValue.setText(" 0.00");
            }
        } catch (NumberFormatException ex) {
            netTotalValue.setText(" 0.00");

        }
    }

    public static void bestCustomer(JPanel centerPanel) {

        if (placeOrderDataSet.isEmpty()) {
            JLabel noDataLabel = new JLabel("No orders placed yet...", JLabel.CENTER);
            noDataLabel.setFont(new java.awt.Font("Quicksand", java.awt.Font.BOLD, 30));
            centerPanel.add(noDataLabel, BorderLayout.CENTER);
            return;
        }

        ArrayList<Order> tempOrderDataSet = new ArrayList<>(placeOrderDataSet);
        ArrayList<Order> uniqueOrders = new ArrayList<>();

        // double price=0.0;
        toSort(tempOrderDataSet, 1);

        for (int i = 0; i < tempOrderDataSet.size(); i++) {

            if (uniqueOrders.isEmpty()) {
                uniqueOrders.add(tempOrderDataSet.get(i));
            } else if (uniqueOrders.get(uniqueOrders.size() - 1).getCustId()
                    .equalsIgnoreCase(tempOrderDataSet.get(i).getCustId())) {
                int lastUniqueIndex = uniqueOrders.size() - 1;
                uniqueOrders.get(lastUniqueIndex).setQuantity(
                        uniqueOrders.get(lastUniqueIndex).getQuantity() + tempOrderDataSet.get(i).getQuantity());
            } else {
                uniqueOrders.add(tempOrderDataSet.get(i));
            }

        }
        toSort(uniqueOrders);

        for (Order order : uniqueOrders) {
            System.out.println("Customer ID: " + order.getCustId() + ", Quantity: " + order.getQuantity());
        }

        // --- Prepare data for JTable ---
        String[] columnNames = { "Customer ID", "Name", "Total" };
        Object[][] tableData = new Object[uniqueOrders.size()][3];

        for (int i = 0; i < uniqueOrders.size(); i++) {
            tableData[i][0] = uniqueOrders.get(i).getCustId();
            tableData[i][1] = CustomerManager.findEqualName(uniqueOrders.get(i).getCustId());
            tableData[i][2] = (uniqueOrders.get(i).getQuantity()) * 500 + ".00";
        }

        JTable table = new JTable(tableData, columnNames);
        table.setFont(new java.awt.Font("Quicksand", java.awt.Font.PLAIN, 18));
        table.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(table);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

    }

    private static void toSort(ArrayList<Order> tempOrderDataSet, int num) {

        for (int i = 0; i < tempOrderDataSet.size(); i++) {

            for (int j = i + 1; j < tempOrderDataSet.size(); j++) {

                if (Integer.parseInt(tempOrderDataSet.get(i).getCustId().substring(1)) > Integer
                        .parseInt(tempOrderDataSet.get(j).getCustId().substring(1))) {
                    Order temp = tempOrderDataSet.get(i);
                    tempOrderDataSet.set(i, tempOrderDataSet.get(j));
                    tempOrderDataSet.set(j, temp);
                }

            }

        }
    }

    private static void toSort(ArrayList<Order> tempOrderDataSet) {

        for (int i = 0; i < tempOrderDataSet.size(); i++) {

            for (int j = i + 1; j < tempOrderDataSet.size(); j++) {

                if (tempOrderDataSet.get(i).getQuantity() < tempOrderDataSet.get(j).getQuantity()) {
                    Order temp = tempOrderDataSet.get(i);
                    tempOrderDataSet.set(i, tempOrderDataSet.get(j));
                    tempOrderDataSet.set(j, temp);
                }

            }

        }
    }

}

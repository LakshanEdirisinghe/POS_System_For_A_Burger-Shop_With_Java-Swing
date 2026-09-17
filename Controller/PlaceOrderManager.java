package Controller;

import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Order;
// import view.PlaceOrder;
import util.OrderStatus;

public class PlaceOrderManager {

    private static final double BURGER_PRICE = 500.00;

    private static ArrayList<Order> placeOrderDataSet = new ArrayList<>();

    public static boolean placeOrder(Order order) {

        placeOrderDataSet.add(order);
        // String quantityText = qtyField.getText().trim();

        // if (quantityText.isEmpty()) {
        // JOptionPane.showMessageDialog(this, "Please enter the burger quantity.",
        // "Invalid quantity",
        // JOptionPane.ERROR_MESSAGE);
        // qtyField.requestFocusInWindow();
        // return;
        // }

        // try {
        // int quantity = Integer.parseInt(quantityText);
        // if (quantity <= 0) {
        // JOptionPane.showMessageDialog(this, "Quantity must be greater than zero.",
        // "Invalid quantity",
        // JOptionPane.ERROR_MESSAGE);
        // qtyField.requestFocusInWindow();
        // return;
        // }

        // PlaceOrderManager.placeOrder(new Order(orderIdValue.getText(),
        // customerIdValue.getText(),
        // OrderStatus.PREPARING, quantity));
        // } catch (NumberFormatException ex) {
        // JOptionPane.showMessageDialog(this, "Quantity must be a whole number.",
        // "Invalid quantity",
        // JOptionPane.ERROR_MESSAGE);
        // qtyField.requestFocusInWindow();
        // }

        return true;
        // placeOrderDataSet.add(orderItem);
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

    public static void displayOrderDetails(){
        placeOrderDataSet.forEach(order -> {
            System.out.println("Order ID: " + order.getOrderId());
            System.out.println("Customer ID: " + order.getCustId());
            System.out.println("Quantity: " + order.getQuantity());
            System.out.println("Order Status: " + order.getOrderStatus());
            System.out.println("---------------------------");
        });
    }

}

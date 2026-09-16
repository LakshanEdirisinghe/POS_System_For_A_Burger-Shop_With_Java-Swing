package Controller;

import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.OrderItem;
import view.PlaceOrder;

public class PlaceOrderManager {

    private static final double BURGER_PRICE = 500.00;

    private static ArrayList<OrderItem> placeOrderDataSet = new ArrayList<>();

    public static boolean placeOrder(OrderItem orderItem) {

        // if (customerId.isEmpty() || qtyField.getText().isEmpty()) {
        //     JOptionPane.showMessageDialog(null, "Please fill in all fields.");
        //     return;
        // }
        // if (Integer.parseInt(qtyField.getText()) <= 0) {
        //     JOptionPane.showMessageDialog(null, "Quantity must be greater than zero.");
        //     return;

        // } else {
        //     qty = Integer.parseInt(qtyField.getText());
        // }

        return placeOrderDataSet.add(orderItem);
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
        double total = BURGER_PRICE * Double.parseDouble(qtyField.getText());
        netTotalValue.setText(String.format(" %.2f", total));
    }

}

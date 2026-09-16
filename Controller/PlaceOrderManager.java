package Controller;

import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

import view.PlaceOrder;

public class PlaceOrderManager {

    private static final double BURGER_PRICE = 500.00;

    private static ArrayList<PlaceOrder> placeOrderDataSet = new ArrayList<>();

    public boolean addPlaceOrder(PlaceOrder placeOrder) {
        return placeOrderDataSet.add(placeOrder);
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

    public static  void updateNetTotal(JTextField qtyField, JLabel netTotalValue) {
        double total = BURGER_PRICE * Double.parseDouble(qtyField.getText());
        netTotalValue.setText(String.format(" %.2f", total));
    }

    

}

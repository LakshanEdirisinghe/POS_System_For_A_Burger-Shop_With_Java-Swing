package Controller;

import java.util.ArrayList;

import view.PlaceOrder;

public class PlaceOrderManager {

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

}

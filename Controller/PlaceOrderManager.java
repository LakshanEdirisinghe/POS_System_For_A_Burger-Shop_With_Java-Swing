package Controller;

import java.util.ArrayList;

import view.PlaceOrder;

public class PlaceOrderManager {

    private static ArrayList<PlaceOrder> placeOrderDataSet = new ArrayList<>();

    public boolean addPlaceOrder(PlaceOrder placeOrder) {
        return placeOrderDataSet.add(placeOrder);
    }

    public static int getID() {

        return placeOrderDataSet.size() + 1;
    }

}

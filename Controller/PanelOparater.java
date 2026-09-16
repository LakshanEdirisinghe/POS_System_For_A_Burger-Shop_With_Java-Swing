package Controller;

import view.PlaceOrder;

public class PanelOparater {

    private static PlaceOrder placeOrder;

    public static void openPlaceOrder() {
        if (placeOrder == null || !placeOrder.isDisplayable()) {
            placeOrder = new PlaceOrder();
        }

        placeOrder.setVisible(true);
    }

}

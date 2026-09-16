package Controller;

import view.PlaceOrder;

public class PanelOparater {

    private static PlaceOrder placeOderObj;

    public static void openPlaceOrder() {
        placeOderObj = new PlaceOrder();
        placeOderObj.setVisible(true);

    }

}

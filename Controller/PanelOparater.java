package Controller;

import javax.swing.JFrame;

import view.*;

public class PanelOparater {

    public void openPlaceOrder() {
        openWindow(new PlaceOrder());
    }

    public void openBestCustomer() {
        openWindow(new BestCustomer());
    }

    public void openSearchOrder() {
        openWindow(new SearchOrder());
    }

    public void openSearchCustomer() {
        openWindow(new SearchCustomer());
    }

    public void openViewOrders() {
        openWindow(new ViewOrders());
    }

    public void openUpdateDetails() {
        openWindow(new UpdateDetails());
    }

    private void openWindow(JFrame window) {
        window.setVisible(true);
    }
}

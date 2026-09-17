package Controller;

import javax.swing.*;

import view.*;

public class PanelOparater {

    public static void openPlaceOrder() {
        openWindow(new PlaceOrder());
        
    }

    public static void openBestCustomer() {
        openWindow(new BestCustomer());
    }

    public static void openSearchOrder() {
        openWindow(new SearchOrder());
    }

    public static void openSearchCustomer() {
        openWindow(new SearchCustomer());
    }

    public static void openViewOrders() {
        openWindow(new ViewOrders());
    }

    public static void openUpdateDetails() {
        openWindow(new UpdateDetails());
    }
    public static void openAddCustomer() {
        openWindow(new AddCustomerForm());
    }

    public static void backToHome(JFrame currentWindow) {
        new MainMenu().setVisible(true);
        currentWindow.dispose();
    }

    private static void openWindow(JFrame window) {
        window.setVisible(true);
    }
}

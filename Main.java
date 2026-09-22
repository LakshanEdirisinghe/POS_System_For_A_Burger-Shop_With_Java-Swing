import view.*;
import Controller.*;
import model.*;
import util.*;

class Main{
    public static void main(String[] args) {

        new MainMenu().setVisible(true);


        //Temporary code to add a customer to the CustomerManager's dataset
        addCustomer();
        //Temporary code to add an order to the PlaceOrderManager's dataset
        addOrder();
        // CustomerManager.printCustomerDataSet();

        
    }

    private static void addCustomer() {

        CustomerManager.addCustomer(new Customer("C001", "John Doe"));
        CustomerManager.addCustomer(new Customer("C002", "Jane Smith"));
        CustomerManager.addCustomer(new Customer("C003", "Bob Johnson"));
        CustomerManager.addCustomer(new Customer("C004", "Alice Williams"));

        
    }

    private static void addOrder() {


        PlaceOrderManager.placeOrder(new Order("O001", "C001", OrderStatus.PREPARING, 2));
        PlaceOrderManager.placeOrder(new Order("O002", "C002", OrderStatus.DELIVERED, 1));
        PlaceOrderManager.placeOrder(new Order("O003", "C003", OrderStatus.CANCELLED, 3));
        PlaceOrderManager.placeOrder(new Order("O004", "C001", OrderStatus.DELIVERED, 1));
        PlaceOrderManager.placeOrder(new Order("O005", "C002", OrderStatus.PREPARING, 2));
        PlaceOrderManager.placeOrder(new Order("O006", "C003", OrderStatus.DELIVERED, 1));
        PlaceOrderManager.placeOrder(new Order("O007", "C004", OrderStatus.PREPARING, 3));
        PlaceOrderManager.placeOrder(new Order("O008", "C001", OrderStatus.DELIVERED, 2));
        PlaceOrderManager.placeOrder(new Order("O009", "C002", OrderStatus.PREPARING, 1));
        PlaceOrderManager.placeOrder(new Order("O010", "C003", OrderStatus.DELIVERED, 2));
    }
}
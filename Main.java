import view.*;
import Controller.*;
import model.*;

class Main{
    public static void main(String[] args) {

        new MainMenu().setVisible(true);


        //Temporary code to add a customer to the CustomerManager's dataset
        addCustomer();
        CustomerManager.printCustomerDataSet();

        
    }

    private static void addCustomer() {

        CustomerManager.addCustomer(new Customer("C001", "John Doe"));
        CustomerManager.addCustomer(new Customer("C002", "Jane Smith"));
        CustomerManager.addCustomer(new Customer("C003", "Bob Johnson"));
        CustomerManager.addCustomer(new Customer("C004", "Alice Williams"));

        
    }
}
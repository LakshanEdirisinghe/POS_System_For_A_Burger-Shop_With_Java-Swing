package Controller;

import java.util.ArrayList;

import model.Customer;

public class CustomerManager {
    
    private static ArrayList<Customer> CustomerDataSet = new ArrayList<>();



    public static void addCustomer(Customer customer) {
        CustomerDataSet.add(customer);
    }

    public static void printCustomerDataSet() {
        for (Customer customer : CustomerDataSet) {
            System.out.println(customer.getId() + " - " + customer.getName());
        }
        System.out.println("Total customers: " + CustomerDataSet.size());
    }




}


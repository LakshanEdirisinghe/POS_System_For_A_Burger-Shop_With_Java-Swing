package Controller;

import java.util.ArrayList;

import model.Customer;

public class CustomerManager {
    
    private static ArrayList<Customer> CustomerDataSet = new ArrayList<>();


    public void addCustomer(Customer customer) {
        CustomerDataSet.add(customer);
    }




}


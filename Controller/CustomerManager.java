package Controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Customer;

public class CustomerManager {

    private static ArrayList<Customer> CustomerDataSet = new ArrayList<>();

    public static void addCustomer(Customer customer) {

        if (customer.getId().substring(1).isEmpty() || customer.getName().isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Please enter both the customer ID and name.",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(findCustomerById(customer.getId()) != null) {
            JOptionPane.showMessageDialog(
                    null,
                    "Customer ID already exists.",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        boolean check=CustomerDataSet.add(customer);

        // if (check) {

        //     JOptionPane.showMessageDialog(
        //         null,
        //         "Customer added successfully.",
        //         "Success",
        //         JOptionPane.INFORMATION_MESSAGE);
            
        // }

    }

    public static String findEqualName(String id){

        for (Customer customer : CustomerDataSet) {
            
            if (customer.getId().equals(id)) {
                return customer.getName();
            }
        }

        return "Unknown";
    }

    public static void printCustomerDataSet() {
        for (Customer customer : CustomerDataSet) {
            System.out.println(customer.getId() + " - " + customer.getName());
        }
        System.out.println();
    }

    public static Customer findCustomerById(String id) {
        for (Customer customer : CustomerDataSet) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null; // Return null if customer not found
    }

}

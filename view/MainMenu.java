package view;

import java.awt.*;
import javax.swing.*;

import Controller.PanelOparater;
import util.Components;


public class MainMenu extends JFrame {

    private JPanel subLeftPanel, subRightPanel, btnPanel;
    private JButton btnPlaceOrder, btnBestCustomer, btnSearchOrder, btnCustomerDetails, btnViewOrders, btnUpdateOrder,btnAddCustomer,
            btnExit;

    // private PanelOparater panelOparater;

    public MainMenu() {
        setTitle("Home Page");
        setSize(1227, 579);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(1, 2));
        subLeftPanel = new JPanel(new BorderLayout());
        subRightPanel = new JPanel(new BorderLayout());

        add(subLeftPanel);
        add(subRightPanel);

        // === Components ===
        setupLeftPanel();
        setupRightPanel();

        // panelOparater = new PanelOparater();
        eventListeners();
    }

    private void setupLeftPanel() {

        JLabel heading = new JLabel("Welcome to Burgers");
        heading.setFont(new Font("Quicksand", Font.BOLD, 40));
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setForeground(new Color(202, 158, 4));

        JLabel imgView = new JLabel(new ImageIcon("assets/Foodies - Chef Top Menu.png"));

        JLabel copyRightSign = new JLabel("@iCET", JLabel.CENTER);
        copyRightSign.setForeground(new Color(137, 137, 137));
        copyRightSign.setPreferredSize(new Dimension(100, 50));

        subLeftPanel.add(heading, BorderLayout.NORTH);
        subLeftPanel.add(imgView, BorderLayout.CENTER);
        subLeftPanel.add(copyRightSign, BorderLayout.SOUTH);

    }

    private void setupRightPanel() {
        subRightPanel.setBackground(new Color(216, 216, 216));

        btnPanel = new JPanel(new GridLayout(7, 1, 10, 10));
        btnPanel.setBackground(new Color(216, 216, 216));
        btnPanel.setBorder(BorderFactory.createEmptyBorder(120, 120, 120, 120));

        // Buttons
        btnPlaceOrder = Components.createStyledButton("Place Order");
        btnAddCustomer = Components.createStyledButton("Add Customer",new Color(0x3498DB));
        btnBestCustomer = Components.createStyledButton("Find Best Customer");
        btnSearchOrder = Components.createStyledButton("Search Order");
        btnCustomerDetails = Components.createStyledButton("Search Customer Details");
        btnViewOrders = Components.createStyledButton("View Orders");
        btnUpdateOrder = Components.createStyledButton("Update Order Details");
        btnExit = Components.createStyledButton("Exit");

        btnPanel.add(btnPlaceOrder);
        btnPanel.add(btnAddCustomer);
        btnPanel.add(btnBestCustomer);
        btnPanel.add(btnSearchOrder);
        btnPanel.add(btnCustomerDetails);
        btnPanel.add(btnViewOrders);
        btnPanel.add(btnUpdateOrder);
        
        JPanel exitPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        exitPanel.setBackground(new Color(216, 216, 216));
        exitPanel.add(btnExit);

        subRightPanel.add(btnPanel, BorderLayout.CENTER);
        subRightPanel.add(exitPanel, BorderLayout.SOUTH);
    }

    private void eventListeners() {

        btnPlaceOrder.addActionListener(e -> openPlaceOrder());
        btnAddCustomer.addActionListener(e -> openAddCustomer());
        btnBestCustomer.addActionListener(e -> openBestCustomer());
        btnSearchOrder.addActionListener(e -> openSearchOrder());
        btnCustomerDetails.addActionListener(e -> openSearchCustomer());
        btnViewOrders.addActionListener(e -> openViewOrders());
        btnUpdateOrder.addActionListener(e -> openUpdateDetails());
        btnExit.addActionListener(e -> System.exit(0));
    }

    private void openPlaceOrder() {
        PanelOparater.openPlaceOrder();
        dispose();
    }

    private void openBestCustomer() {
        PanelOparater.openBestCustomer();
        dispose();
    }

    private void openSearchOrder() {
        PanelOparater.openSearchOrder();
        dispose();
    }

    private void openSearchCustomer() {
        PanelOparater.openSearchCustomer();
        dispose();
    }

    private void openViewOrders() {
        PanelOparater.openViewOrders();
        dispose();
    }

    private void openAddCustomer() {
        PanelOparater.openAddCustomer();
        dispose();
    }

    private void openUpdateDetails() {
        PanelOparater.openUpdateDetails();
        dispose();
    }

}

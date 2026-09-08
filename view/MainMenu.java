package view;

import java.awt.*;
import javax.swing.*;

public class MainMenu extends JFrame {

    private JPanel subLeftPanel, subRightPanel, btnPanel;
    private JButton btnPlaceOrder, btnBestCustomer, btnSearchOrder, btnCustomerDetails, btnViewOrders, btnUpdateOrder,
            btnExit;

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

        btnPanel = new JPanel(new GridLayout(6, 1, 10, 10));
        btnPanel.setBackground(new Color(216, 216, 216));
        btnPanel.setBorder(BorderFactory.createEmptyBorder(120, 120, 120, 120));

        // Buttons
        btnPlaceOrder = createStyledButton("Place Order");
        btnBestCustomer = createStyledButton("Find Best Customer");
        btnSearchOrder = createStyledButton("Search Order");
        btnCustomerDetails = createStyledButton("Search Customer Details");
        btnViewOrders = createStyledButton("View Orders");
        btnUpdateOrder = createStyledButton("Update Order Details");
        btnExit = createStyledButton("Exit");

        btnPanel.add(btnPlaceOrder);
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

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(209, 72, 72));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Quicksand", Font.BOLD, 20));
        return button;
    }

}

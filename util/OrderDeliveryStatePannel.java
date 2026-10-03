package util;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import Controller.PanelOparater;

public class OrderDeliveryStatePannel extends JFrame {

    private JPanel topPanel, centerPanel, southJPanel;
    private JLabel titleLabel;
    private JButton back;


    private String windowTitle="";



    public OrderDeliveryStatePannel(String title) {

        windowTitle = title;
        // === Frame setup ===
        setTitle(title);    
        setLayout(new BorderLayout());
        setSize(735, 445);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        topPanel();
        centerPanel();
        southJPanel();

    }

    private void topPanel() {
        // --- Top panel ---
        topPanel = new JPanel();
        topPanel.setBackground(new Color(209, 72, 72));

        titleLabel = new JLabel(this.windowTitle, JLabel.CENTER);
        titleLabel.setFont(new Font("Quicksand", Font.BOLD, 40));
        titleLabel.setForeground(Color.WHITE);

        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);
    }

    private void centerPanel() {
        // --- Center panel ---
        centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);


        // --- Prepare data for JTable ---
        // if (dataArray != null) {
        //     String[] columnNames = { "Order ID", "Customer ID", "Name", "Order Qty", "Total" };
        //     Object[][] tableData = new Object[dataArray.length][5];

        //     for (int i = 0; i < dataArray.length; i++) {
        //         tableData[i][0] = dataArray[i].getOrderId();
        //         tableData[i][1] = dataArray[i].getCustId();
        //         tableData[i][2] =  ViewOrders.customerDatabase.getName(dataArray[i].getCustId());
        //         tableData[i][3] = dataArray[i].getQuantityOfBurger();
        //         tableData[i][4] = dataArray[i].getQuantityOfBurger() * 500 + ".00";
        //     }

        //     JTable table = new JTable(tableData, columnNames);
        //     table.setFont(new Font("Quicksand", Font.BOLD, 18));
        //     table.setRowHeight(30);

        //     JScrollPane scrollPane = new JScrollPane(table);
        //     centerPanel.add(scrollPane, BorderLayout.CENTER);

        //     add(centerPanel, BorderLayout.CENTER);
        // }else {
        //     JLabel noOrdersLabel = new JLabel("No Preparing Orders Found", JLabel.CENTER);
        //     noOrdersLabel.setFont(new Font("Quicksand", Font.BOLD, 24));
        //     centerPanel.add(noOrdersLabel, BorderLayout.CENTER);
        //     add(centerPanel, BorderLayout.CENTER);
        // }

    }
    public JPanel getCenterPanel() {
        return centerPanel;
    }

    // private String getName(String custId) {

    //     DbCustomer customerArray[] = ViewOrders.customerDatabase.toArray();
    //     for (int i = 0; i < customerArray.length; i++) {
    //         if (customerArray[i].getCustId().equalsIgnoreCase(custId)) {
    //             return customerArray[i].getName();
    //         }
    //     }
    //     return "Unknown";
    // }

    private void southJPanel() {
        southJPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        southJPanel.setBackground(Color.WHITE);

        back = Components.createStyledButton("Back");
        back.addActionListener(e -> PanelOparater.openViewOrders());
        southJPanel.add(back);
        add(southJPanel, BorderLayout.SOUTH);

        // back.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         new ViewOrders(ViewOrders.database, ViewOrders.customerDatabase); // open Main Menu window
        //         dispose(); // close current window
        //     }
        // });
    }

    // private JButton createStyledButton(String text) {
    //     JButton button = new JButton(text);
    //     button.setBackground(new Color(209, 72, 72));
    //     button.setForeground(Color.WHITE);
    //     button.setFont(new Font("Quicksand", Font.BOLD, 20));
    //     return button;
    // }

    
}

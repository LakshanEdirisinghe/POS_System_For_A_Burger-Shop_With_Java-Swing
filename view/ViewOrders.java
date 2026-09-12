package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewOrders extends JFrame {

    private JPanel subLeftPanel, subRightPanel, subRightCenter, subRightTopPanel, subRightBottomPanel;

    private JButton btnDeliveredOrder, btnCanceledOrder, back, btnPreparingOrder;


    public ViewOrders() {
       // === Frame setup ===
        setLayout(new GridLayout(1, 2));
        setTitle("View Orders");
        setSize(1227, 579);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setupPanels();
        assemblePanels();

        setupLeftPanel();
        setupRightPanel();

        setVisible(true);
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

        subRightCenter.setBackground(new Color(216, 216, 216));
        subRightCenter.setBorder(BorderFactory.createEmptyBorder(130, 130, 130, 130));

        // Buttons
        btnDeliveredOrder = createStyledButton("Delivered Order");
        btnPreparingOrder = createStyledButton("Preparing Order");
        btnCanceledOrder = createStyledButton("Canceled Order");

        // btnPreparingOrder.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         new PreparingOrder("Preparing Orders",ViewOrders.database.findPreparingOrders());
        //         dispose();
        //     }
        // });
        // btnDeliveredOrder.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         new DeliveredOrder("Delivered Orders",ViewOrders.database.findDeliveredOrders());
        //         dispose();
        //     }
        // });

        // btnCanceledOrder.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         new CancelledOrder("Cancelled Orders",ViewOrders.database.findCancelledOrders());
        //         dispose();
        //     }
        // });

        subRightCenter.add(btnDeliveredOrder);
        subRightCenter.add(btnPreparingOrder);
        subRightCenter.add(btnCanceledOrder);

        subRightBottomPanel.setBackground(Color.WHITE);
        back = createStyledButton("Back to Home");
        // back.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         new MainMenu(database);
        //         dispose();
        //     }
        // });
        subRightBottomPanel.add(back);

        subRightTopPanel.setBackground(new Color(0x2C3E50));

        JLabel heading = new JLabel("View Orders");
        heading.setFont(new Font("Quicksand", Font.BOLD, 40));
        heading.setForeground(Color.WHITE);
        subRightTopPanel.add(heading);

        subRightPanel.add(subRightTopPanel, BorderLayout.NORTH);

        subRightPanel.add(subRightCenter, BorderLayout.CENTER);
        subRightPanel.add(subRightBottomPanel, BorderLayout.SOUTH);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(209, 72, 72));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Quicksand", Font.BOLD, 20));
        return button;
    }

    private void setupPanels() {
        subLeftPanel = new JPanel(new BorderLayout());
        subRightPanel = new JPanel(new BorderLayout());

        subRightBottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        subRightCenter = new JPanel(new GridLayout(3, 1, 10, 10));
        subRightTopPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // subRightBottomPanel = new JPanel(new BorderLayout());

    }

    private void assemblePanels() {

        add(subLeftPanel);
        add(subRightPanel);

    }

}

class PreparingOrder extends JFrame {

    private JPanel topPanel, centerPanel, southJPanel;
    private JLabel titleLabel;
    private JButton back;


    private String windowTitle="";


    public PreparingOrder(String title) {

        this.windowTitle = title;
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

        back = createStyledButton("Back");
        southJPanel.add(back);
        add(southJPanel, BorderLayout.SOUTH);

        // back.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         new ViewOrders(ViewOrders.database, ViewOrders.customerDatabase); // open Main Menu window
        //         dispose(); // close current window
        //     }
        // });
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(209, 72, 72));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Quicksand", Font.BOLD, 20));
        return button;
    }

}

class DeliveredOrder extends PreparingOrder {


    public DeliveredOrder(String title) {

        super(title);

    }

}

class CancelledOrder extends PreparingOrder {


    public CancelledOrder(String title) {

        super(title);

    }

}

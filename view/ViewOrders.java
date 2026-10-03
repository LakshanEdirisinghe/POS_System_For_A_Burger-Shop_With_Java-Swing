package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import util.Components;
import util.OrderStatus;
import util.OrderDeliveryStatePannel;
import Controller.PanelOparater;
import Controller.OrderManager;

public class ViewOrders extends JFrame {

    private JPanel subLeftPanel, subRightPanel, subRightCenter, subRightTopPanel, subRightBottomPanel;

    private JButton btnDeliveredOrder, btnCanceledOrder, back, btnPreparingOrder;
    private OrderDeliveryStatePannel preparingOrderPanel;


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

        subRightCenter.setBackground(new Color(216, 216, 216));
        subRightCenter.setBorder(BorderFactory.createEmptyBorder(130, 130, 130, 130));

        // Buttons
        btnDeliveredOrder = Components.createStyledButton("Delivered Order");
        btnPreparingOrder = Components.createStyledButton("Preparing Order");
        btnCanceledOrder = Components.createStyledButton("Canceled Order");

        btnPreparingOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (preparingOrderPanel == null || !preparingOrderPanel.isDisplayable()) {
                    preparingOrderPanel = new OrderDeliveryStatePannel("Preparing Orders");
                    OrderManager.getOrderDetailsOrderByStatus(preparingOrderPanel.getCenterPanel(), OrderStatus.PREPARING);
                } else {
                    preparingOrderPanel.setVisible(true);
                    preparingOrderPanel.toFront();
                    preparingOrderPanel.requestFocus();
                }
            }
        });

        btnDeliveredOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (preparingOrderPanel == null || !preparingOrderPanel.isDisplayable()) {
                    preparingOrderPanel = new OrderDeliveryStatePannel("Delivered Orders");
                    OrderManager.getOrderDetailsOrderByStatus(preparingOrderPanel.getCenterPanel(), OrderStatus.DELIVERED);
                } else {
                    preparingOrderPanel.setVisible(true);
                    preparingOrderPanel.toFront();
                    preparingOrderPanel.requestFocus();
                }
            }
        });

        btnCanceledOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (preparingOrderPanel == null || !preparingOrderPanel.isDisplayable()) {
                    preparingOrderPanel = new OrderDeliveryStatePannel("Cancelled Orders");
                    OrderManager.getOrderDetailsOrderByStatus(preparingOrderPanel.getCenterPanel(), OrderStatus.CANCELLED);
                } else {
                    preparingOrderPanel.setVisible(true);
                    preparingOrderPanel.toFront();
                    preparingOrderPanel.requestFocus();
                }
            }
        });

        subRightCenter.add(btnDeliveredOrder);
        subRightCenter.add(btnPreparingOrder);
        subRightCenter.add(btnCanceledOrder);

        subRightBottomPanel.setBackground(Color.WHITE);
        back =Components.createStyledButton("Back to Home");
        back.addActionListener(e -> PanelOparater.backToHome(this));

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

    private void setupPanels() {
        subLeftPanel = new JPanel(new BorderLayout());
        subRightPanel = new JPanel(new BorderLayout());

        subRightBottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        subRightCenter = new JPanel(new GridLayout(3, 1, 10, 10));
        subRightTopPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

    }

    private void assemblePanels() {

        add(subLeftPanel);
        add(subRightPanel);

    }

}

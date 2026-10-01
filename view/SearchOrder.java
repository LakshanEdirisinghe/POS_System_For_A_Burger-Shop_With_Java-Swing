package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.PanelOparater;
import Controller.OrderManager;
import util.Components;

import java.awt.*;

public class SearchOrder extends JFrame {

    private JPanel topPanel, subCenterPanel, subCenterTopPanel, subLeftCCPanel, subBottomPanel;

    private JLabel titleLabel, customerIdLabel, customerIdValue, nameLabel, nameValue, qtyLabel, qtyValue,
            totalLabel, totalValue, statusLabel, statusValue;

    private JTextField searchField;
    private JButton back, searchBtn;

    public SearchOrder() {

        setTitle("Search Order");
        setSize(735, 445);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        headerPanel();
        centerSearchBarPanal();
        centerFormPannel();
        bottomBackBtnPanel();

    }

    private void headerPanel() {
        topPanel = new JPanel();
        topPanel.setBackground(new Color(0x2C3E50));

        titleLabel = Components.createStyledLabel("Search Order");
        titleLabel.setFont(new Font("Quicksand", Font.BOLD, 35));
        titleLabel.setForeground(Color.WHITE);
        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);
    }

    private void centerSearchBarPanal() {

        subCenterPanel = new JPanel(new BorderLayout());
        subCenterTopPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        searchField = new JTextField(20);
        searchField.setFont(new Font("Quicksand", Font.BOLD, 18));

        searchBtn = Components.createStyledButton("Search");

        subCenterTopPanel.add(searchField);
        subCenterTopPanel.add(searchBtn);
        subCenterPanel.add(subCenterTopPanel, BorderLayout.NORTH);

        subCenterPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        add(subCenterPanel, BorderLayout.CENTER);

    }

    private void centerFormPannel() {
        subLeftCCPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        subLeftCCPanel.setBorder(BorderFactory.createEmptyBorder(20, 150, 20, 150));
        subCenterPanel.add(subLeftCCPanel, BorderLayout.CENTER);

        searchBtn.addActionListener(e -> {
            model.Order order = OrderManager.findOrder(searchField.getText().trim());
            displayOrderDetails(order);
        });

    }

    private void displayOrderDetails(model.Order order) {
        subLeftCCPanel.removeAll();

        if (order == null) {
            customerIdLabel = Components.createStyledLabel("Customer ID ");
            customerIdValue = Components.createStyledLabel(": Not Found");

            nameLabel = Components.createStyledLabel("Customer Name ");
            nameValue = Components.createStyledLabel(": Not Found");

            qtyLabel = Components.createStyledLabel("Quantity ");
            qtyValue = Components.createStyledLabel(": Not Found");

            totalLabel = Components.createStyledLabel("Total ");
            totalValue = Components.createStyledLabel(": Not Found");

            statusLabel = Components.createStyledLabel("Status ");
            statusValue = Components.createStyledLabel(": Not Found");
        } else {
            customerIdLabel = Components.createStyledLabel("Customer ID ");
            customerIdValue = Components.createStyledLabel(": " + order.getCustId());

            nameLabel = Components.createStyledLabel("Customer Name ");
            nameValue = Components.createStyledLabel(": " + Controller.CustomerManager.findEqualName(order.getCustId()));

            qtyLabel = Components.createStyledLabel("Quantity ");
            qtyValue = Components.createStyledLabel(": " + order.getQuantity());

            totalLabel = Components.createStyledLabel("Total ");
            totalValue = Components.createStyledLabel(": " + (order.getQuantity() * 500) + " LKR");

            statusLabel = Components.createStyledLabel("Status ");
            statusValue = Components.createStyledLabel(": " + order.getOrderStatus());
        }

        subLeftCCPanel.add(customerIdLabel);
        subLeftCCPanel.add(customerIdValue);
        subLeftCCPanel.add(nameLabel);
        subLeftCCPanel.add(nameValue);
        subLeftCCPanel.add(qtyLabel);
        subLeftCCPanel.add(qtyValue);
        subLeftCCPanel.add(totalLabel);
        subLeftCCPanel.add(totalValue);
        subLeftCCPanel.add(statusLabel);
        subLeftCCPanel.add(statusValue);

        subLeftCCPanel.revalidate();
        subLeftCCPanel.repaint();
        subCenterPanel.revalidate();
        subCenterPanel.repaint();
        revalidate();
        repaint();
    }

    private void bottomBackBtnPanel() {

        subBottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        subBottomPanel.setBackground(Color.WHITE);

        back = Components.createStyledButton("Back to Home");
        back.addActionListener(e -> PanelOparater.backToHome(this));

        subBottomPanel.add(back);
        add(subBottomPanel, BorderLayout.SOUTH);

    }

}

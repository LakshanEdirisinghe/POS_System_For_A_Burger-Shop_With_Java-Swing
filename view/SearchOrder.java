package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.PlaceOrderManager;
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

        titleLabel = Components.createStyledLabel ("Search Order");
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

        searchBtn.addActionListener(e -> {

            // System.out.println(searchField.getText());

            PlaceOrderManager.findOrder(searchField.getText());

        });

        subCenterTopPanel.add(searchField);
        subCenterTopPanel.add(searchBtn);
        subCenterPanel.add(subCenterTopPanel, BorderLayout.NORTH);

        subCenterPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

    }

    private void centerFormPannel() {
        subLeftCCPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        subLeftCCPanel.removeAll();

        // Create labels
        customerIdLabel = Components.createStyledLabel("Customer ID ");
        customerIdValue = Components.createStyledLabel(": " + "C015");

        nameLabel = Components.createStyledLabel("Customer Name ");
        nameValue = Components.createStyledLabel(": " + "Ayomal");

        qtyLabel = Components.createStyledLabel("Quantity ");
        qtyValue = Components.createStyledLabel(": " + 4);

        totalLabel = Components.createStyledLabel("Total ");
        totalValue = Components.createStyledLabel(": " + 2400 + " LKR");

        statusLabel = Components.createStyledLabel("Status ");
        statusValue = Components.createStyledLabel(": " + "DELIVERED");

        // Add to panel
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

        // refresh UI
        subLeftCCPanel.revalidate();
        subLeftCCPanel.repaint();
        subLeftCCPanel.setBorder(BorderFactory.createEmptyBorder(20, 150, 20, 150));
        subCenterPanel.add(subLeftCCPanel, BorderLayout.CENTER);
        add(subCenterPanel, BorderLayout.CENTER);

    }

    private void bottomBackBtnPanel() {

        subBottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        subBottomPanel.setBackground(Color.WHITE);

        back = Components.createStyledButton("Back to Home");

        subBottomPanel.add(back);
        add(subBottomPanel, BorderLayout.SOUTH);

    }

    
}

package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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

        titleLabel = createStyledLabel("Search Order");
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

        searchBtn = createStyledButton("Search");

        subCenterTopPanel.add(searchField);
        subCenterTopPanel.add(searchBtn);
        subCenterPanel.add(subCenterTopPanel, BorderLayout.NORTH);

        subCenterPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

    }

    private void centerFormPannel() {
        subLeftCCPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        subLeftCCPanel.removeAll();

        // Create labels
        customerIdLabel = createStyledLabel("Customer ID ");
        customerIdValue = createStyledLabel(": " + "C015");

        nameLabel = createStyledLabel("Customer Name ");
        nameValue = createStyledLabel(": " + "Ayomal");

        qtyLabel = createStyledLabel("Quantity ");
        qtyValue = createStyledLabel(": " + 4);

        totalLabel = createStyledLabel("Total ");
        totalValue = createStyledLabel(": " + 2400 + " LKR");

        statusLabel = createStyledLabel("Status ");
        statusValue = createStyledLabel(": " + "DELIVERED");

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

        back = createStyledButton("Back to Home");

        subBottomPanel.add(back);
        add(subBottomPanel, BorderLayout.SOUTH);

    }

    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Quicksand", Font.BOLD, 20));
        return label;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(209, 72, 72));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Quicksand", Font.BOLD, 20));
        return button;
    }

    
}

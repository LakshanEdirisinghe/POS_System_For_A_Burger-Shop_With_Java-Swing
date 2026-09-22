package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
// import javax.swing.JScrollPane;
// import javax.swing.JTable;

import java.awt.*;
import Controller.PlaceOrderManager;
import Controller.PanelOparater;
import util.Components;

public class BestCustomer extends JFrame {

    private JPanel topPanel, centerPanel, southJPanel;
    private JLabel titleLabel;
    private JButton back;

    public BestCustomer() {

        // === Frame setup ===
        setTitle("Best Customer");
        setLayout(new BorderLayout());
        setSize(735, 445);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        topPanel();
        dataTableLoder();
        backBtn();

    }

    private void topPanel() {
        // --- Top panel ---
        topPanel = new JPanel();

        topPanel.setBackground(new Color(0x2C3E50));
        titleLabel = Components.createStyledLabel("Best Customer");
        titleLabel.setFont(new Font("Quicksand", Font.BOLD, 40));
        titleLabel.setForeground(Color.WHITE);

        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);
    }

    private void dataTableLoder() {
        centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);

        // PlaceOrderManager.bestCustomer(centerPanel);
        add(centerPanel, BorderLayout.CENTER);
    }

    private void backBtn() {
        southJPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        back = Components.createStyledButton("Back");
        southJPanel.add(back);
        add(southJPanel, BorderLayout.SOUTH);

        back.addActionListener(e -> PanelOparater.backToHome(this));

    }

}

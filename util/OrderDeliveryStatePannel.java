package util;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

public class OrderDeliveryStatePannel extends JFrame {

    private JPanel topPanel, centerPanel, southJPanel;
    private JLabel titleLabel;
    private JButton back;
    private JFrame parentWindow;


    private String windowTitle="";



    public OrderDeliveryStatePannel(String title, JFrame parentWindow) {

        windowTitle = title;
        this.parentWindow = parentWindow;
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
        add(centerPanel, BorderLayout.CENTER);

    }

    public JPanel getCenterPanel() {
        return centerPanel;
    }


    private void southJPanel() {
        southJPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        southJPanel.setBackground(Color.WHITE);

        back = Components.createStyledButton("Back");
        back.addActionListener(e -> {
            parentWindow.setVisible(true);
            dispose();
        });
        southJPanel.add(back);
        add(southJPanel, BorderLayout.SOUTH);
    }
}

package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;

public class PlaceOrder extends JFrame {

    // === Panels ===
    private JPanel topPanel, subLeftPanel, subRightPanel;
    private JPanel subNorthPanel, subSouthPanel;
    private JPanel subRightCenterPanel, subRightSouthPanel;

    // === Labels ===
    private JLabel titleLabel;
    private JLabel orderId, orderIdValue;
    private JLabel customerId, qtyLabel, orderStatusLabel, orderStatusValue;
    private JLabel netTotal, netTotalValue;

    // === Text fields ===
    private JTextField customerIdValue, qtyField;

    // === Buttons ===
    private JButton placeOrderButton, bToHome, cancel;

    public PlaceOrder() {

        setTitle("Place Order");
        setSize(600, 223);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Quicksand", Font.BOLD, 20));
        return label;
    }

    private JTextField createStyledTextField(String text) {
        JTextField textField = new JTextField(text);
        textField.setFont(new Font("Quicksand", Font.BOLD, 20));
        return textField;
    }

    private JButton createButton(String text, Color bgColor) {
        JButton btn = new JButton(text);
        btn.setBackground(bgColor);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Quicksand", Font.BOLD, 20));
        return btn;
    }

}

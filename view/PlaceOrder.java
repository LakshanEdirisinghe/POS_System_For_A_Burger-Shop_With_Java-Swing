package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
    
}

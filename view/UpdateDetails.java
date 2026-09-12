package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UpdateDetails extends JFrame {


    private JPanel topPanel, subCenterPanel, subCenterTopPanel, subLeftCCPanel, subBottomPanel;

    private JLabel titleLabel;
    private JTextField searchField, CustomerIDValue, CustomerNameValue, QtyValue, TotalValue;
    private JButton back, searchBtn, btnUpdate;
    private JComboBox<String> comboBox;

    private String orderId;
    private String newCustId;
    private String qtyText;
    private int selectedStatus;

    private int statusint = -1;

    public UpdateDetails() {


        setTitle("Update Order Details");
        setSize(950, 445);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        initializePanels();
        setLayouts();
        assemblePanels();

        hedding();
        searchBar();
        subBottomP();

        setVisible(true);
    }

    private void initializePanels() {
        topPanel = new JPanel();
        subCenterPanel = new JPanel();
        subCenterTopPanel = new JPanel();
        subLeftCCPanel = new JPanel();
        subBottomPanel = new JPanel();
    }

    private void setLayouts() {
        setLayout(new BorderLayout());

        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        subCenterPanel.setLayout(new BorderLayout());
        subCenterTopPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        subLeftCCPanel.setLayout(new GridLayout(0, 2, 10, 10));
        subBottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    }

    private void assemblePanels() {
        add(topPanel, BorderLayout.NORTH);
        add(subCenterPanel, BorderLayout.CENTER);
        add(subBottomPanel, BorderLayout.SOUTH);

        subCenterPanel.add(subCenterTopPanel, BorderLayout.NORTH);
        subCenterPanel.add(subLeftCCPanel, BorderLayout.CENTER);
    }

    public void hedding() {
        topPanel.setBackground(new Color(0x2C3E50));

        titleLabel = new JLabel("Search Order");
        titleLabel.setFont(new Font("Quicksand", Font.BOLD, 40));
        titleLabel.setForeground(Color.WHITE);

        topPanel.add(titleLabel);
    }

    public void searchBar() {
        searchField = new JTextField("O", 20);
        searchField.setFont(new Font("Quicksand", Font.BOLD, 18));

        searchBtn = createStyledButton("Search");

        // searchBtn.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         orderId = searchField.getText().trim();
        //         displayOrderDetails(orderId);
        //     }
        // });

        subCenterTopPanel.add(searchField);
        subCenterTopPanel.add(searchBtn);
        subCenterPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
    }

    public void displayOrderDetails(String orderId) {
        subLeftCCPanel.removeAll();

        // DbOrders[] orderArray = database.toArray();
        // boolean found = false;

        // for (int i = 0; i < orderArray.length; i++) {
        //     if (orderArray[i].getOrderId().equalsIgnoreCase(orderId)) {
        //         found = true;

                
        //         statusint = orderArray[i].getOrderStatus();

        //         // Common order info
        //         String custId = orderArray[i].getCustId();
        //         String custName = customerDb.getName(custId);
        //         int qty = orderArray[i].getQuantityOfBurger();
        //         int total = qty * 500;

        //         Color labelColor = (statusint == 0) ? Color.BLACK : Color.LIGHT_GRAY;

        //         subLeftCCPanel.setLayout(new GridLayout(0, 2, 10, 10));

        //         // ==== Customer ID ====
        //         subLeftCCPanel.add(createStyledLabel("Customer ID ", labelColor));

        //         if (statusint == 0) {
        //             CustomerIDValue = createStyledTextField(custId);
        //             UpdateDetails.this.newCustId = custId; // initialize

        //             CustomerIDValue.addKeyListener(new KeyAdapter() {
        //                 public void keyReleased(KeyEvent e) {
        //                     UpdateDetails.this.newCustId = CustomerIDValue.getText().trim();
        //                     String newCustName = customerDb.getName(newCustId);
        //                     CustomerNameValue.setText(newCustName);
        //                 }
        //             });
        //             subLeftCCPanel.add(CustomerIDValue);
        //         } else {
        //             subLeftCCPanel.add(createStyledLabel(": " + custId, labelColor));
        //         }

        //         // ==== Customer Name ====
        //         subLeftCCPanel.add(createStyledLabel("Customer Name ", labelColor));

        //         if (statusint == 0) {
        //             CustomerNameValue = createStyledTextField(custName);
        //             CustomerNameValue.setEditable(false);
        //             subLeftCCPanel.add(CustomerNameValue);
        //         } else {
        //             subLeftCCPanel.add(createStyledLabel(": " + custName, labelColor));
        //         }

        //         // ==== Quantity ====
        //         subLeftCCPanel.add(createStyledLabel("Quantity ", labelColor));

        //         if (statusint == 0) {
        //             QtyValue = createStyledTextField(String.valueOf(qty));
        //             UpdateDetails.this.qtyText = String.valueOf(qty); // initialize

        //             QtyValue.addKeyListener(new KeyAdapter() {
        //                 public void keyReleased(KeyEvent e) {
        //                     UpdateDetails.this.qtyText = QtyValue.getText().trim();
        //                     int newQty = 0;
        //                     try {
        //                         newQty = Integer.parseInt(UpdateDetails.this.qtyText);
        //                     } catch (NumberFormatException ex) {
        //                         // Handle invalid input
        //                     }
        //                     int newTotal = newQty * 500;
        //                     TotalValue.setText(newTotal + ".00");
        //                 }
        //             });
        //             subLeftCCPanel.add(QtyValue);
        //         } else {
        //             subLeftCCPanel.add(createStyledLabel(": " + qty, labelColor));
        //         }

        //         // ==== Total ====
        //         subLeftCCPanel.add(createStyledLabel("Total ", labelColor));

        //         if (statusint == 0) {
        //             TotalValue = createStyledTextField(String.valueOf(total));
        //             TotalValue.setEditable(false);
        //             subLeftCCPanel.add(TotalValue);
        //         } else {
        //             subLeftCCPanel.add(createStyledLabel(": " + total + " LKR", labelColor));
        //         }

        //         // ==== Status ====
        //         String statusText = (statusint == 0) ? "PREPARING" : (statusint == 1) ? "DELIVERED" : "CANCELLED";

        //         subLeftCCPanel.add(createStyledLabel("Status ", labelColor));

        //         if (statusint == 0) {
        //             String[] options = { "PREPARING", "DELIVERED", "CANCELLED" };
        //             comboBox = new JComboBox<>(options);
        //             comboBox.setSelectedItem(statusText);
        //             comboBox.setFont(new Font("Quicksand", Font.BOLD, 20));
        //             this.selectedStatus = comboBox.getSelectedIndex();

        //             subLeftCCPanel.add(comboBox);
        //         } else {
        //             subLeftCCPanel.add(createStyledLabel(": " + statusText, labelColor));
        //         }

        //         // ==== Extra message for delivered/cancelled ====
        //         if (statusint == 1) {
        //             subLeftCCPanel.add(createStyledLabel("Message", Color.RED));
        //             subLeftCCPanel.add(createStyledLabel(": Sorry, this order is delivered.", Color.RED));
        //         } else if (statusint == 2) {
        //             subLeftCCPanel.add(createStyledLabel("Message", Color.RED));
        //             subLeftCCPanel.add(createStyledLabel(": Sorry, this order is canceled.", Color.RED));
        //         }

        //         break;
        //     }
        // }

        // if (!found) {
        //     subLeftCCPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        //     subLeftCCPanel.add(createStyledLabel("Order not found!", Color.RED));
        // }

        subLeftCCPanel.revalidate();
        subLeftCCPanel.repaint();
        subLeftCCPanel.setBorder(BorderFactory.createEmptyBorder(20, 150, 20, 150));
    }

    private void subBottomP() {
        subBottomPanel.setBackground(Color.WHITE);

        back = createStyledButton("Back to Home");
        btnUpdate = createStyledButton("Update");
        btnUpdate.setBackground(new Color(0, 177, 59));

        // back.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         new MainMenu(database);
        //         dispose();
        //     }
        // });

        // btnUpdate.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
                
        //         if (orderId != null && statusint == 0) {
        //             try {
        //                 int newQty = Integer.parseInt(qtyText);
        //                 int newStatus = comboBox.getSelectedIndex(); 
        //                 // 0 = Preparing, 1 = Delivered, 2 = Cancelled

        //                 boolean success = database.updateOrder(orderId, newCustId, newQty, newStatus);

        //                 if (success) {
        //                     JOptionPane.showMessageDialog(UpdateDetails.this,
        //                             "Order updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        //                 } else {
        //                     JOptionPane.showMessageDialog(UpdateDetails.this,
        //                             "Failed to update order!", "Error", JOptionPane.ERROR_MESSAGE);
        //                 }
        //             } catch (NumberFormatException ex) {
        //                 JOptionPane.showMessageDialog(UpdateDetails.this,
        //                         "Invalid quantity entered!", "Error", JOptionPane.ERROR_MESSAGE);
        //             }
        //         }
        //     }
        // });

        subBottomPanel.add(btnUpdate);
        subBottomPanel.add(back);
    }

    private JLabel createStyledLabel(String text, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Quicksand", Font.BOLD, 20));
        label.setForeground(color);
        return label;
    }

    private JTextField createStyledTextField(String text) {
        JTextField textField = new JTextField(text);
        textField.setFont(new Font("Quicksand", Font.BOLD, 20));
        return textField;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(209, 72, 72));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Quicksand", Font.BOLD, 20));
        return button;
    }
}


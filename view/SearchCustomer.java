package view;

// import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
// import javax.swing.JOptionPane;
import javax.swing.JPanel;
// import javax.swing.JScrollPane;
// import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.*;

import Controller.CustomerManager;
import Controller.OrderManager;
import util.Components;

public class SearchCustomer extends JFrame {

    private JPanel subToPPanel, subBottomPanel, subBottomBPanel, subBottomCenterPanel, subTopCenterPanel,
            subTopTitleJPanel, subBottomTitleJPanel;

    private JTextField searchField;
    private JButton back, searchBtn;
    private JLabel custnameTag, nameValue, title, titlebottumname, customerIdTag, customerIdValue;

    public SearchCustomer() {

        setTitle("Search Customer");
        setSize(735, 445);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 0));
        setLocationRelativeTo(null);

        subBottomPannal();
        subTopPannal();
        

    }

    private void subTopPannal() {

        subToPPanel = new JPanel(new BorderLayout());

        subTopTitleJPanel = new JPanel();

        subTopTitleJPanel.setBackground(new Color(0x2C3E50));

        title = Components.createStyledLabel("Search Customer");
        title.setFont(new Font("Quicksand", Font.BOLD, 30));
        title.setForeground(Color.WHITE);

        subTopTitleJPanel.add(title);
        subToPPanel.add(subTopTitleJPanel, BorderLayout.NORTH);

        subTopCenterPanel = new JPanel(new GridBagLayout());

        GridBagConstraints formConstraints = new GridBagConstraints();
        formConstraints.insets = new Insets(8, 12, 8, 12);
        formConstraints.anchor = GridBagConstraints.CENTER;

        customerIdTag = Components.createStyledLabel("Customer ID: ");
        customerIdTag.setHorizontalAlignment(SwingConstants.RIGHT);

        searchField = new JTextField(15);
        searchField.setFont(new Font("Quicksand", Font.BOLD, 16));

        searchBtn = Components.createStyledButton("Search");

        searchBtn.addActionListener(e -> {

            String customerName = OrderManager.getOrderDetails(searchField.getText().trim(), subBottomCenterPanel);
            if (customerName != null) {
                nameValue.setText(customerName.toUpperCase());
            }
        });

        custnameTag = Components.createStyledLabel("Customer Name: ");
        custnameTag.setHorizontalAlignment(SwingConstants.RIGHT);
        nameValue = Components.createStyledLabel("");
        nameValue.setHorizontalAlignment(SwingConstants.LEFT);

        formConstraints.gridx = 0;
        formConstraints.gridy = 0;
        subTopCenterPanel.add(customerIdTag, formConstraints);

        formConstraints.gridx = 1;
        subTopCenterPanel.add(searchField, formConstraints);

        formConstraints.gridx = 2;
        subTopCenterPanel.add(searchBtn, formConstraints);

        formConstraints.gridx = 0;
        formConstraints.gridy = 1;
        subTopCenterPanel.add(custnameTag, formConstraints);

        formConstraints.gridx = 1;
        subTopCenterPanel.add(nameValue, formConstraints);

        subToPPanel.add(subTopCenterPanel, BorderLayout.CENTER);

        add(subToPPanel);
    }

    private void subBottomPannal() {
        subBottomPanel = new JPanel(new BorderLayout());

        subBottomTitleJPanel = new JPanel();//

        subBottomTitleJPanel.setBackground(new Color(0x2C3E50));

        titlebottumname = Components.createStyledLabel("Order Details");
        titlebottumname.setFont(new Font("Quicksand", Font.BOLD, 20));
        titlebottumname.setForeground(Color.WHITE);

        subBottomTitleJPanel.add(titlebottumname);
        subBottomPanel.add(subBottomTitleJPanel, BorderLayout.NORTH);

        subBottomCenterPanel = new JPanel(new BorderLayout());

        subBottomPanel.add(subBottomCenterPanel, BorderLayout.CENTER);

        subBottomBPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        back = Components.createStyledButton("Back");
        subBottomBPanel.add(back);
        subBottomPanel.add(subBottomBPanel, BorderLayout.SOUTH);

        add(subBottomPanel);

    }

}

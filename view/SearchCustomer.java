package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.*;

public class SearchCustomer extends JFrame {

    private JPanel subToPPanel, subBottomPanel, subBottomBPanel, subTopCenterPanel, subTopBottomPanel,
            subTopTitleJPanel, subBottomTitleJPanel;

    private JTextField searchField;
    private JButton back, searchBtn;
    private JLabel name, nameValue, title;

    public SearchCustomer() {

        setTitle("Search Customer");
        setSize(735, 445);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 0));
        setLocationRelativeTo(null);

        subTopPannal();

    }

    private void subTopPannal() {

        subToPPanel = new JPanel(new BorderLayout());

        subTopTitleJPanel = new JPanel();

        subTopTitleJPanel.setBackground(new Color(0x2C3E50));

        title = createStyledLabel("Search Customer");
        title.setFont(new Font("Quicksand", Font.BOLD, 30));
        title.setForeground(Color.WHITE);

        subTopTitleJPanel.add(title);
        subToPPanel.add(subTopTitleJPanel, BorderLayout.NORTH);

        // createStyledPanel("Search Customer", 40, subTopTitleJPanel);

        // searchField = new JTextField(20);
        // searchField.setFont(new Font("Quicksand", Font.BOLD, 18));

        // searchBtn = createStyledButton("Search");

        // subTopCenterPanel.add(searchField);
        // subTopCenterPanel.add(searchBtn);

        // subTopBottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 20));

        add(subToPPanel);
    }

    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Quicksand", Font.BOLD, 20));
        return label;
    }

}

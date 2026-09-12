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
import java.awt.*;

public class SearchCustomer extends JFrame {

    private JPanel subToPPanel, subBottomPanel, subBottomBPanel, subBottomCenterPanel, subTopBottomPanel,
            subTopTitleJPanel, subBottomTitleJPanel;

    private JTextField searchField;
    private JButton back, searchBtn;
    private JLabel name, nameValue, title, titlebottumname;

    public SearchCustomer() {

        setTitle("Search Customer");
        setSize(735, 445);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 0));
        setLocationRelativeTo(null);

        subTopPannal();
        subBottomPannal();

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

        searchField = new JTextField(20);
        searchField.setFont(new Font("Quicksand", Font.BOLD, 18));

        searchBtn = createStyledButton("Search");

        subTopBottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        subTopBottomPanel.add(searchField);
        subTopBottomPanel.add(searchBtn);

        subToPPanel.add(subTopBottomPanel, BorderLayout.CENTER);

        // subToPPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 20));

        add(subToPPanel);
    }

    private void subBottomPannal() {
        subBottomPanel = new JPanel(new BorderLayout());

        subBottomTitleJPanel = new JPanel();//

        subBottomTitleJPanel.setBackground(new Color(0x2C3E50));

        titlebottumname = createStyledLabel("Order Details");
        titlebottumname.setFont(new Font("Quicksand", Font.BOLD, 20));
        titlebottumname.setForeground(Color.WHITE);

        subBottomTitleJPanel.add(titlebottumname);
        subBottomPanel.add(subBottomTitleJPanel, BorderLayout.NORTH);

        // subBottomCenterPanel = new JPanel(new BorderLayout());

        // for order details table is here

        subBottomBPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        back = createStyledButton("Back");
        subBottomBPanel.add(back);
        subBottomPanel.add(subBottomBPanel,BorderLayout.SOUTH);

        add(subBottomPanel);

    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(209, 72, 72));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Quicksand", Font.BOLD, 20));
        return button;
    }

    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Quicksand", Font.BOLD, 20));
        return label;
    }

}

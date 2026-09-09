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
    private JLabel name, nameValue;

    public SearchCustomer() {

        setTitle("Search Customer");
        setSize(735, 445);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 0));
        setLocationRelativeTo(null);

    }


    

   
    
}

package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

    }
    
}

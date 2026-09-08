package view;

import java.awt.*;
import javax.swing.*;

public class MainMenu extends JFrame {

    private JPanel subLeftPanel, subRightPanel;

    public MainMenu(){
        setTitle("Home Page");
        setSize(1227, 579);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(1, 2));
        subLeftPanel = new JPanel(new BorderLayout());
        subRightPanel = new JPanel(new BorderLayout());

        add(subLeftPanel);
        add(subRightPanel);


        // === Components ===
        setupLeftPanel();
        // setupRightPanel();
    }

    private void setupLeftPanel(){

        JLabel heading = new JLabel("Welcome to Burgers");
        heading.setFont(new Font("Quicksand", Font.BOLD, 40));
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setForeground(new Color(202, 158, 4));

        JLabel imgView = new JLabel(new ImageIcon("assets/Foodies - Chef Top Menu.png"));

        JLabel copyRightSign = new JLabel("@iCET", JLabel.CENTER);
        copyRightSign.setForeground(new Color(137, 137, 137));
        copyRightSign.setPreferredSize(new Dimension(100, 50));

        subLeftPanel.add(heading, BorderLayout.NORTH);
        subLeftPanel.add(imgView, BorderLayout.CENTER);
        subLeftPanel.add(copyRightSign, BorderLayout.SOUTH);

    }


    


    
}

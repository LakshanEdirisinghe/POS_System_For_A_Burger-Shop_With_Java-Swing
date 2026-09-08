package view;

import java.awt.*;
import javax.swing.*;
import util.Components;

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

        

        

    }


    


    
}

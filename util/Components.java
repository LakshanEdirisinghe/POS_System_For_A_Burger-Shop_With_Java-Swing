package util;

import java.awt.*;
import javax.swing.*;

public class Components {

    private static void setHeading(String title,String fFamily, Font fStyle, int fSize, JLabel fAlignment, int cR,int cG,int cB) {

        JLabel heading = new JLabel("Welcome to Burgers");
        heading.setFont(new Font("Quicksand", Font.BOLD, 40));
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setForeground(new Color(202, 158, 4));

    }

}

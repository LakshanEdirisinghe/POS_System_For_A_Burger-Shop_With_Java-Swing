package util;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Components {

    public static JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(209, 72, 72));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Quicksand", Font.BOLD, 20));
        return button;
    }

    public static JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Quicksand", Font.BOLD, 20));
        return label;
    }

    public static JButton createStyledButton(String text, Color bgColor) {
        JButton btn = new JButton(text);
        btn.setBackground(bgColor);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Quicksand", Font.BOLD, 20));
        return btn;
    }

}

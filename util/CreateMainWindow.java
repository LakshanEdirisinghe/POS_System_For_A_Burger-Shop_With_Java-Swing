package util;

import javax.swing.JFrame;

public class CreateMainWindow  {

    public static JFrame getMainWindow (String WindowTitle, int closeOperationType, int sizeX, int sizeY ){

        JFrame frameObj = new JFrame();

        frameObj.setTitle(WindowTitle);
        frameObj.setDefaultCloseOperation(closeOperationType);
        frameObj.setSize(sizeX, sizeY);
        frameObj.setLocationRelativeTo(null);
        frameObj.setVisible(true);

        return frameObj;
    }
    
}

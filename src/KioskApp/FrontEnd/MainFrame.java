package KioskApp.FrontEnd;

import javax.swing.*;
import java.awt.*;

/**
 * A class that extends JFrame that acts as a default frame for a few of the windows used in KioskApp.
 * Contains some basic UI customizations to the Frame.
 */
public class MainFrame extends JFrame{


    protected ImageIcon appImgIcon;
    public MainFrame() {

        appImgIcon = new ImageIcon("src\\AppIcon.png");
        this.setIconImage(appImgIcon.getImage());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(800,600));
        this.setTitle("KioskApp V0.01A");


        this.getContentPane().setBackground(new Color(43, 43, 43));

        this.setLayout(new GridBagLayout());
        this.pack();
        this.setVisible(true);
    }

}

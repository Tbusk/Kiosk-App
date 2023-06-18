package KioskApp.FrontEnd;

import javax.swing.*;
import java.awt.*;

/**
 * A class that extends JPanel that is the UI for the logo that is seen in various windows in KioskApp.
 */
public class LogoBarPanel extends JPanel {
    protected JLabel logoLabel;
    protected ImageIcon logoIcon;
    protected Image logoImg;
    protected Image logoImgResized;
    protected ImageIcon logoIconResized;

    public LogoBarPanel() {

        this.setLayout(new BorderLayout());
        this.setBackground(new Color(43,43,43));
        logoLabel = new JLabel();
        logoIcon = new ImageIcon("src\\AppLogo.png");
        logoImg = logoIcon.getImage();
        logoImgResized = logoImg.getScaledInstance(410,100, Image.SCALE_SMOOTH);
        logoIconResized = new ImageIcon(logoImgResized);
        logoLabel.setIcon(logoIconResized);
        logoLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(logoLabel);

    }
}

package KioskApp.FrontEnd;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A class that extends JPanel that is the UI for the bottom component seen in a few windows in KioskApp.
 * It contains app version number, the app mode, and the date and time.
 */
public class BottomBarPanel extends JPanel{

    protected JLabel versionNumber;
    protected JLabel appMode;
    static JLabel dateAndTime;

    public BottomBarPanel() {

        this.setLayout(new BorderLayout());
        this.setBackground(new Color(43,43,43));

        versionNumber = new JLabel("v0.01A");
        versionNumber.setFocusable(false);
        versionNumber.setOpaque(false);
        versionNumber.setFont(new Font(null, Font.PLAIN, 18));
        versionNumber.setForeground(Color.WHITE);
        versionNumber.setHorizontalTextPosition(JLabel.LEFT);
        versionNumber.setVerticalTextPosition(JLabel.BOTTOM);
        this.add(versionNumber, BorderLayout.LINE_START);

        appMode = new JLabel("Store Mode");
        appMode.setFocusable(false);
        appMode.setOpaque(false);
        appMode.setFont(new Font(null, Font.PLAIN, 18));
        appMode.setForeground(Color.WHITE);
        appMode.setHorizontalAlignment(JLabel.CENTER);
        appMode.setHorizontalTextPosition(JLabel.RIGHT);
        appMode.setVerticalTextPosition(JLabel.BOTTOM);
        this.add(BorderLayout.CENTER, appMode);

        dateAndTime = new JLabel(getCurrentDateAndTime());
        dateAndTime.setFocusable(false);
        dateAndTime.setOpaque(false);
        dateAndTime.setHorizontalTextPosition(JLabel.RIGHT);
        dateAndTime.setVerticalTextPosition(JLabel.BOTTOM);
        dateAndTime.setFont(new Font(null, Font.PLAIN, 18));
        dateAndTime.setForeground(Color.WHITE);
        this.add(dateAndTime, BorderLayout.LINE_END);
    }

     static String getCurrentDateAndTime() {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        return dateTimeFormatter.format(now);

    }
}

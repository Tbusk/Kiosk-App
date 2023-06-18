package KioskApp.FrontEnd;

import KioskApp.Accounts.AccountCreationAndReadingTest;
import KioskApp.Accounts.CredentialChecker;
import KioskApp.Accounts.UserTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * A class that extends JPanel that has ActionListeners that represents the login interface with the functionality of allowing a user to login.
 */
public class LoginPanel extends JPanel implements ActionListener {
    WindowEvent closingEvent;
    static Integer isLoggedIn = 0;
    protected JLabel appLogo;
    ImageIcon usernameIcon;
    Image usernameIconImg;
    Image usernameIconImgResized;
    ImageIcon usernameIconResized;

    ImageIcon passwordIcon;
    Image passwordIconImg;
    Image pwdIconImgResized;
    ImageIcon pwdIconResized;

    GridBagConstraints gbConst;

    protected LogoBarPanel logoBarPanel;
    protected JLabel usernameIconLbl;
    protected JLabel passwordIconLbl;
    protected JTextField usernameField;
    protected JTextField passwordField;
    protected JButton loginButton;


    public LoginPanel() {
        logoBarPanel = new LogoBarPanel();

        closingEvent = new WindowEvent(Window.getWindows()[0], WindowEvent.WINDOW_CLOSING);
        gbConst = new GridBagConstraints();
        this.setOpaque(false);
        this.setBackground(new Color(43, 43, 43));
        this.setLayout(new GridBagLayout());

        usernameIcon = new ImageIcon("src\\accountImg.png");
        usernameIconImg = usernameIcon.getImage();
        usernameIconImgResized = usernameIconImg.getScaledInstance(50,50, Image.SCALE_SMOOTH);
        usernameIconResized = new ImageIcon(usernameIconImgResized);

        passwordIcon = new ImageIcon("src\\lock.png");
        passwordIconImg = passwordIcon.getImage();
        pwdIconImgResized = passwordIconImg.getScaledInstance(50,50, Image.SCALE_SMOOTH);
        pwdIconResized = new ImageIcon(pwdIconImgResized);

        appLogo = new JLabel();
        appLogo.setFocusable(false);
        appLogo.setOpaque(false);
        appLogo.setHorizontalTextPosition(JLabel.CENTER);
        appLogo.setVerticalTextPosition(JLabel.CENTER);
        gbConst.gridx = 0;
        gbConst.gridy = 0;
        gbConst.gridwidth = 2;
        appLogo.setFont(new Font(null, Font.PLAIN, 60));
        appLogo.setForeground(Color.WHITE);
        gbConst.insets = new Insets(10,10,25,10);
        this.add(logoBarPanel, gbConst);

        usernameIconLbl = new JLabel();
        usernameIconLbl.setFocusable(false);
        usernameIconLbl.setIcon(usernameIconResized);
        usernameIconLbl.setOpaque(false);
        gbConst.gridx = 0;
        gbConst.gridy = 1;
        gbConst.gridwidth = 1;
        usernameIconLbl.setPreferredSize(new Dimension(75,75));
        gbConst.insets = new Insets(10,10,10,10);
        this.add(usernameIconLbl, gbConst);

        usernameField = new JTextField("Username");
        usernameField.setFont(new Font("Dialog", Font.PLAIN, 24));
        usernameField.setPreferredSize(new Dimension(350, 50));
        usernameField.addActionListener(this);
        usernameField.setMargin(new Insets(0,10,0,0));
        gbConst.gridx = 1;
        gbConst.gridy = 1;
        gbConst.gridwidth = 1;
        gbConst.insets = new Insets(10,0,10,10);
        usernameField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if(usernameField.getText().equals("Username")) {
                    usernameField.setText("");
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if(usernameField.getText().equals("")) {
                    if(usernameField.hasFocus()) {
                        usernameField.setText("");
                    } else {
                        usernameField.setText("Username");
                    }
                }
            }
        });
        this.add(usernameField, gbConst);

        passwordIconLbl = new JLabel();
        passwordIconLbl.setFocusable(false);
        passwordIconLbl.setIcon(pwdIconResized);
        passwordIconLbl.setOpaque(false);
        passwordIconLbl.setPreferredSize(new Dimension(75,75));
        gbConst.gridx = 0;
        gbConst.gridy = 2;
        gbConst.gridwidth = 1;
        gbConst.insets = new Insets(10,10,10,10);
        this.add(passwordIconLbl, gbConst);

        passwordField = new JTextField("Password");
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 24));
        passwordField.setPreferredSize(new Dimension(350, 50));
        passwordField.setMargin(new Insets(0,10,0,0));
        passwordField.addActionListener(this);
        gbConst.gridx = 1;
        gbConst.gridy = 2;
        gbConst.gridwidth = 1;
        gbConst.insets = new Insets(10,0,10,10);
        passwordField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if(passwordField.getText().equals("Password")) {
                    passwordField.setText("");
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if(passwordField.getText().equals("")) {
                    if(passwordField.hasFocus()) {
                        passwordField.setText("");
                    } else {
                        passwordField.setText("Password");
                    }
                }
            }
        });
        this.add(passwordField, gbConst);

        loginButton = new JButton("Login");
        loginButton.setFocusable(false);
        loginButton.setBackground(new Color(115,188, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setPreferredSize(new Dimension(225,65));
        loginButton.addActionListener(this);
        loginButton.setFont(new Font(null, Font.PLAIN, 35));
        gbConst.gridx = 0;
        gbConst.gridy = 3;
        gbConst.gridwidth = 2;
        gbConst.insets = new Insets(20,10,10,10);
        this.add(loginButton, gbConst);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            try {
                CredentialChecker credChecker = new CredentialChecker();
                if (usernameField.hasFocus() || passwordField.hasFocus()) {
                if (credChecker.checkCreds(usernameField.getText(), passwordField.getText())) {
                    System.out.println("Login Successful.  Welcome " + usernameField.getText());
                    isLoggedIn = 1;
                    MainFrame mFrame = new MainFrame();
                    MainPagePanel mPanel = new MainPagePanel();

                    mFrame.add(mPanel);

                    mFrame.pack();
                    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closingEvent);
                } }

            } catch (IOException a) {
                System.out.println(e);
            } catch (NoSuchElementException b) {
                System.out.println(b.getMessage());
            }
        }
    }
}

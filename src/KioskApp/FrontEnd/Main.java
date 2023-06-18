package KioskApp.FrontEnd;

/**
 * Class that starts the KioskApp program.
 * The login window will open.
 */
public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        LoginPanel loginPanel = new LoginPanel();

        mainFrame.add(loginPanel);
        mainFrame.pack();

    }

}

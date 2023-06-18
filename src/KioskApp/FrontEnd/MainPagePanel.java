package KioskApp.FrontEnd;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/**
 * A class that extends JPanel that is a UI for the default page located after logging in.
 * It contains some text, a barcode image, and Mouse Listeners that will open the cart page after clicking on this panel.
 */
public class MainPagePanel extends JPanel {

    WindowEvent closingEvent;
    protected JLabel barcodeLabel;
    protected GridBagConstraints gbConst;
    protected LogoBarPanel logoBarPanel;
    protected BottomBarPanel bottomBarPanel;
    ImageIcon barcode;
    Image barcodeImg;
    Image barcodeImgResized;
    ImageIcon barcodeResized;

    public MainPagePanel() {

        logoBarPanel = new LogoBarPanel();
        bottomBarPanel = new BottomBarPanel();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() > 0) {
                    try {
                        new CartPageFrame();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                super.mouseClicked(e);
            }
        });

        closingEvent = new WindowEvent(Window.getWindows()[0], WindowEvent.WINDOW_CLOSING);
        this.setOpaque(false);
        this.setBackground(new Color(43, 43, 43));
        this.setLayout(new GridBagLayout());

        barcode = new ImageIcon("src\\Barcode.png");
        barcodeImg = barcode.getImage();
        barcodeImgResized = barcodeImg.getScaledInstance(256, 256, Image.SCALE_SMOOTH);
        barcodeResized = new ImageIcon(barcodeImgResized);

        gbConst = new GridBagConstraints();


        gbConst.gridx = 0;
        gbConst.gridy = 0;
        gbConst.insets = new Insets(25, 0, 0, 0);
        gbConst.gridwidth = 4;
        this.add(logoBarPanel, gbConst);

        barcodeLabel = new JLabel("start scanning to begin");
        barcodeLabel.setFocusable(false);
        barcodeLabel.setOpaque(false);
        barcodeLabel.setHorizontalTextPosition(JLabel.CENTER);
        barcodeLabel.setVerticalTextPosition(JLabel.BOTTOM);
        barcodeLabel.setIconTextGap(20);
        barcodeLabel.setIcon(barcodeResized);
        gbConst.gridx = 0;
        gbConst.gridy = 1;
        gbConst.gridwidth = 4;
        barcodeLabel.setFont(new Font(null, Font.PLAIN, 60));
        barcodeLabel.setForeground(Color.WHITE);
        gbConst.insets = new Insets(10,10,25,10);
        this.add(barcodeLabel, gbConst);


        this.setVisible(true);
    }
}

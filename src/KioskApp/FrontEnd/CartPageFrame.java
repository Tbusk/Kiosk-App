package KioskApp.FrontEnd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/**
 * A class that extends JFrame that is the frame for the cart page of KioskApp that puts the various components on the screen in the desired locations.
 */
public class CartPageFrame extends JFrame{
    ImageIcon appImgIcon;
    CartPageCartPanel cartPanel;
    TotalBarPanel totalBarPanel;
    NumberPanel numberPanel;
    TopBarPanel topBarPanel;
    BottomBarPanel bottomBarPanel;
    LogoBarPanel logoBarPanel;
    GridBagConstraints gbConst;
    public CartPageFrame() throws IOException {

        this.setLayout(new GridBagLayout());
        this.setResizable(false);

        logoBarPanel = new LogoBarPanel();
        cartPanel = new CartPageCartPanel();
        totalBarPanel = new TotalBarPanel();
        numberPanel = new NumberPanel();
        topBarPanel = new TopBarPanel();
        bottomBarPanel = new BottomBarPanel();

        gbConst = new GridBagConstraints();

        gbConst.gridy = 0;
        gbConst.gridx = 0;
        gbConst.gridwidth = 4;
        gbConst.insets = new Insets(0,20,0,20);
        gbConst.fill = GridBagConstraints.HORIZONTAL;
        this.add(logoBarPanel, gbConst);

        gbConst.gridy = 1;
        gbConst.gridx = 0;
        gbConst.gridwidth = 4;
        gbConst.gridheight = 1;
        gbConst.insets = new Insets(0,40,0,20);
        gbConst.fill = GridBagConstraints.HORIZONTAL;
        this.add(topBarPanel, gbConst);

        gbConst.gridy = 3;
        gbConst.gridx = 0;
        gbConst.gridwidth = 3;
        gbConst.gridheight = 3;
        gbConst.insets = new Insets(20,40,20,20);
        gbConst.fill = GridBagConstraints.HORIZONTAL;
        this.add(cartPanel, gbConst);

        gbConst.gridy = 3;
        gbConst.gridx = 3;
        gbConst.gridwidth = 1;
        gbConst.gridheight = 4;
        gbConst.fill = GridBagConstraints.VERTICAL;
        gbConst.insets = new Insets(5,0,5,20);
        numberPanel.cancelOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CartPageCartPanel.itemsAdded.clear();
                SearchedItemsPanel.quantityToAdd.clear();

                SearchedItemsPanel.itemPriceSum = 0.0;
                SearchedItemsPanel.items = 0;
                TotalBarPanel.discountAdded = 0.0;
                TotalBarPanel.taxSum = 0.0;
                TotalBarPanel.grandTotal = 0.0;
                TotalBarPanel.totalPriceSum = 0.0;
                TopBarPanel.searchBarField.setText("");

                dispose();
            }
        });
        this.add(numberPanel, gbConst);

        gbConst.gridy = 6;
        gbConst.gridx = 0;
        gbConst.gridwidth = 3;
        gbConst.gridheight = 1;
        gbConst.insets = new Insets(20,40,5,20);
        gbConst.fill = GridBagConstraints.HORIZONTAL;
        this.add(totalBarPanel,gbConst);

        gbConst.gridy = 7;
        gbConst.gridx = 0;
        gbConst.gridwidth = 4;
        gbConst.gridheight = 1;
        gbConst.insets = new Insets(0,40,15,40);
        gbConst.fill = GridBagConstraints.HORIZONTAL;
        this.add(bottomBarPanel, gbConst);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                CartPageCartPanel.itemsAdded.clear();
                SearchedItemsPanel.quantityToAdd.clear();
                SearchedItemsPanel.itemPriceSum = 0.0;
                SearchedItemsPanel.items = 0;
                TotalBarPanel.discountAdded = 0.0;
                TotalBarPanel.taxSum = 0.0;
                TotalBarPanel.grandTotal = 0.0;
                TotalBarPanel.totalPriceSum = 0.0;
                TopBarPanel.searchBarField.setText("");

                super.windowClosing(e);
            }
        });

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("KioskApp V0.01A");
        this.getContentPane().setBackground(new Color(43, 43, 43));
        appImgIcon = new ImageIcon("src\\AppIcon.png");
        this.setIconImage(appImgIcon.getImage());

        this.pack();
        this.setVisible(true);
    }

}

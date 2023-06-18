package KioskApp.FrontEnd;

import KioskApp.Inventory.Item;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A class that extends JPanel that is a UI for the number panel that is on KioskApp's cart page.
 * This class contains numbers for inputting into the search bar and changing the quantity in the cart page's table as
 * well as a cancel order button and checkout button.
 * The majority of this class is logic surrounding the buttons used and the rest is UI related.
 */
public class NumberPanel extends JPanel{

    protected JButton number1Button;
    protected JButton number2Button;
    protected JButton number3Button;
    protected JButton number4Button;
    protected JButton number5Button;
    protected JButton number6Button;
    protected JButton number7Button;
    protected JButton number8Button;
    protected JButton number9Button;
    protected JButton number0Button;
    protected JButton decimalButton;
    protected JButton backspaceButton;
    protected JButton checkoutButton;
    protected JButton cancelOrderButton;
    protected Dimension buttonDimension = new Dimension(115, 75);
    protected Font buttonFont = new Font(null, Font.PLAIN, 40);

    ImageIcon backspaceIcon;

    public NumberPanel() {
        this.setPreferredSize(new Dimension(408,680));
        this.setBackground(new Color(43, 43, 43));
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));

        backspaceIcon = new ImageIcon("src\\backspace.png");

        number1Button = new JButton("1");
        number2Button = new JButton("2");
        number3Button = new JButton("3");
        number4Button = new JButton("4");
        number5Button = new JButton("5");
        number6Button = new JButton("6");
        number7Button = new JButton("7");
        number8Button = new JButton("8");
        number9Button = new JButton("9");
        number0Button = new JButton("0");
        decimalButton = new JButton(".");
        backspaceButton = new JButton();
        backspaceButton.setIcon(backspaceIcon);

        number1Button.setPreferredSize(buttonDimension);
        number1Button.setFont(buttonFont);
        number1Button.setForeground(new Color(43, 43, 43));
        number1Button.setFocusable(false);

        number1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(TopBarPanel.searchBarField.hasFocus()){
                    TopBarPanel.searchBarField.setText(TopBarPanel.searchBarField.getText() + "1");
                    TopBarPanel.searchBarField.grabFocus();
                }
                if(CartPageCartPanel.cartTable.hasFocus()) {
                    if(CartPageCartPanel.cartTable.isColumnSelected(1)) {
                        if(CartPageCartPanel.cartTable.getValueAt(CartPageCartPanel.cartTable.getSelectedRow(),CartPageCartPanel.cartTable.getSelectedColumn()) != null) {
                            CartPageCartPanel.cartTable.setValueAt("1", CartPageCartPanel.cartTable.getSelectedRow(), CartPageCartPanel.cartTable.getSelectedColumn());
                        }

                        int i = 0;
                        for(Item item : CartPageCartPanel.itemsAdded) {

                            CartPageCartPanel.cartTable.setValueAt(String.format("%.2f",(item.getItemPrice() * SearchedItemsPanel.quantityToAdd.get(i))), i, 3);
                            i += 1;
                        }



                    }
                }
            }
        });

        number2Button.setPreferredSize(buttonDimension);
        number2Button.setFont(buttonFont);
        number2Button.setForeground(new Color(43, 43, 43));
        number2Button.setFocusable(false);
        number2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(TopBarPanel.searchBarField.hasFocus()){
                    TopBarPanel.searchBarField.setText(TopBarPanel.searchBarField.getText() + "2");
                    TopBarPanel.searchBarField.grabFocus();
                }
                if(CartPageCartPanel.cartTable.hasFocus()) {
                    if(CartPageCartPanel.cartTable.isColumnSelected(1)) {
                        if(CartPageCartPanel.cartTable.getValueAt(CartPageCartPanel.cartTable.getSelectedRow(),CartPageCartPanel.cartTable.getSelectedColumn()) != null) {
                            CartPageCartPanel.cartTable.setValueAt("2", CartPageCartPanel.cartTable.getSelectedRow(), CartPageCartPanel.cartTable.getSelectedColumn());
                        }
                        int i = 0;
                        for(Item item : CartPageCartPanel.itemsAdded) {

                            CartPageCartPanel.cartTable.setValueAt(String.format("%.2f",(item.getItemPrice() * SearchedItemsPanel.quantityToAdd.get(i))), i, 3);
                            i += 1;
                        }


                    }
                }
            }
        });

        number3Button.setPreferredSize(buttonDimension);
        number3Button.setFont(buttonFont);
        number3Button.setForeground(new Color(43, 43, 43));
        number3Button.setFocusable(false);
        number3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(TopBarPanel.searchBarField.hasFocus()){
                    TopBarPanel.searchBarField.setText(TopBarPanel.searchBarField.getText() + "3");
                    TopBarPanel.searchBarField.grabFocus();
                }
                if(CartPageCartPanel.cartTable.hasFocus()) {
                    if(CartPageCartPanel.cartTable.isColumnSelected(1)) {
                        if(CartPageCartPanel.cartTable.getValueAt(CartPageCartPanel.cartTable.getSelectedRow(),CartPageCartPanel.cartTable.getSelectedColumn()) != null) {
                            CartPageCartPanel.cartTable.setValueAt("3", CartPageCartPanel.cartTable.getSelectedRow(), CartPageCartPanel.cartTable.getSelectedColumn());
                        }

                        int i = 0;
                        for(Item item : CartPageCartPanel.itemsAdded) {

                            CartPageCartPanel.cartTable.setValueAt(String.format("%.2f",(item.getItemPrice() * SearchedItemsPanel.quantityToAdd.get(i))), i, 3);
                            i += 1;
                        }

                    }
                }
            }
        });

        number4Button.setPreferredSize(buttonDimension);
        number4Button.setFont(buttonFont);
        number4Button.setForeground(new Color(43, 43, 43));
        number4Button.setFocusable(false);

        number4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(TopBarPanel.searchBarField.hasFocus()){
                    TopBarPanel.searchBarField.setText(TopBarPanel.searchBarField.getText() + "4");
                    TopBarPanel.searchBarField.grabFocus();
                }
                if(CartPageCartPanel.cartTable.hasFocus()) {
                    if(CartPageCartPanel.cartTable.isColumnSelected(1)) {
                        if(CartPageCartPanel.cartTable.getValueAt(CartPageCartPanel.cartTable.getSelectedRow(),CartPageCartPanel.cartTable.getSelectedColumn()) != null) {
                            CartPageCartPanel.cartTable.setValueAt("4", CartPageCartPanel.cartTable.getSelectedRow(), CartPageCartPanel.cartTable.getSelectedColumn());
                        }

                        int i = 0;
                        for(Item item : CartPageCartPanel.itemsAdded) {

                            CartPageCartPanel.cartTable.setValueAt(String.format("%.2f",(item.getItemPrice() * SearchedItemsPanel.quantityToAdd.get(i))), i, 3);
                            i += 1;
                        }

                    }
                }
            }
        });


        number5Button.setPreferredSize(buttonDimension);
        number5Button.setFont(buttonFont);
        number5Button.setForeground(new Color(43, 43, 43));
        number5Button.setFocusable(false);

        number5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(TopBarPanel.searchBarField.hasFocus()){
                    TopBarPanel.searchBarField.setText(TopBarPanel.searchBarField.getText() + "5");
                    TopBarPanel.searchBarField.grabFocus();
                }
                if(CartPageCartPanel.cartTable.hasFocus()) {
                    if(CartPageCartPanel.cartTable.isColumnSelected(1)) {
                        if(CartPageCartPanel.cartTable.getValueAt(CartPageCartPanel.cartTable.getSelectedRow(),CartPageCartPanel.cartTable.getSelectedColumn()) != null) {
                            CartPageCartPanel.cartTable.setValueAt("5", CartPageCartPanel.cartTable.getSelectedRow(), CartPageCartPanel.cartTable.getSelectedColumn());
                        }

                        int i = 0;
                        for(Item item : CartPageCartPanel.itemsAdded) {

                            CartPageCartPanel.cartTable.setValueAt(String.format("%.2f",(item.getItemPrice() * SearchedItemsPanel.quantityToAdd.get(i))), i, 3);
                            i += 1;
                        }

                    }
                }
            }
        });

        number6Button.setPreferredSize(buttonDimension);
        number6Button.setFont(buttonFont);
        number6Button.setForeground(new Color(43, 43, 43));
        number6Button.setFocusable(false);

        number6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(TopBarPanel.searchBarField.hasFocus()){
                    TopBarPanel.searchBarField.setText(TopBarPanel.searchBarField.getText() + "6");
                    TopBarPanel.searchBarField.grabFocus();
                }
                if(CartPageCartPanel.cartTable.hasFocus()) {
                    if(CartPageCartPanel.cartTable.isColumnSelected(1)) {
                        if(CartPageCartPanel.cartTable.getValueAt(CartPageCartPanel.cartTable.getSelectedRow(),CartPageCartPanel.cartTable.getSelectedColumn()) != null) {
                            CartPageCartPanel.cartTable.setValueAt("6", CartPageCartPanel.cartTable.getSelectedRow(), CartPageCartPanel.cartTable.getSelectedColumn());
                        }

                        int i = 0;
                        for(Item item : CartPageCartPanel.itemsAdded) {

                            CartPageCartPanel.cartTable.setValueAt(String.format("%.2f",(item.getItemPrice() * SearchedItemsPanel.quantityToAdd.get(i))), i, 3);
                            i += 1;
                        }

                    }
                }
            }
        });


        number7Button.setPreferredSize(buttonDimension);
        number7Button.setFont(buttonFont);
        number7Button.setForeground(new Color(43, 43, 43));
        number7Button.setFocusable(false);

        number7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(TopBarPanel.searchBarField.hasFocus()){
                    TopBarPanel.searchBarField.setText(TopBarPanel.searchBarField.getText() + "7");
                    TopBarPanel.searchBarField.grabFocus();
                }
                if(CartPageCartPanel.cartTable.hasFocus()) {
                    if(CartPageCartPanel.cartTable.isColumnSelected(1)) {
                        if(CartPageCartPanel.cartTable.getValueAt(CartPageCartPanel.cartTable.getSelectedRow(),CartPageCartPanel.cartTable.getSelectedColumn()) != null) {
                            CartPageCartPanel.cartTable.setValueAt("7", CartPageCartPanel.cartTable.getSelectedRow(), CartPageCartPanel.cartTable.getSelectedColumn());
                        }

                        int i = 0;
                        for(Item item : CartPageCartPanel.itemsAdded) {

                            CartPageCartPanel.cartTable.setValueAt(String.format("%.2f",(item.getItemPrice() * SearchedItemsPanel.quantityToAdd.get(i))), i, 3);
                            i += 1;
                        }

                    }
                }
            }
        });

        number8Button.setPreferredSize(buttonDimension);
        number8Button.setFont(buttonFont);
        number8Button.setForeground(new Color(43, 43, 43));
        number8Button.setFocusable(false);

        number8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(TopBarPanel.searchBarField.hasFocus()){
                    TopBarPanel.searchBarField.setText(TopBarPanel.searchBarField.getText() + "8");
                    TopBarPanel.searchBarField.grabFocus();
                }
                if(CartPageCartPanel.cartTable.hasFocus()) {
                    if(CartPageCartPanel.cartTable.isColumnSelected(1)) {
                        if(CartPageCartPanel.cartTable.getValueAt(CartPageCartPanel.cartTable.getSelectedRow(),CartPageCartPanel.cartTable.getSelectedColumn()) != null) {
                            CartPageCartPanel.cartTable.setValueAt("8", CartPageCartPanel.cartTable.getSelectedRow(), CartPageCartPanel.cartTable.getSelectedColumn());
                        }

                        int i = 0;
                        for(Item item : CartPageCartPanel.itemsAdded) {

                            CartPageCartPanel.cartTable.setValueAt(String.format("%.2f",(item.getItemPrice() * SearchedItemsPanel.quantityToAdd.get(i))), i, 3);
                            i += 1;
                        }

                    }
                }
            }
        });

        number9Button.setPreferredSize(buttonDimension);
        number9Button.setFont(buttonFont);
        number9Button.setForeground(new Color(43, 43, 43));
        number9Button.setFocusable(false);

        number9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(TopBarPanel.searchBarField.hasFocus()){
                    TopBarPanel.searchBarField.setText(TopBarPanel.searchBarField.getText() + "9");
                    TopBarPanel.searchBarField.grabFocus();
                }
                if(CartPageCartPanel.cartTable.hasFocus()) {
                    if(CartPageCartPanel.cartTable.isColumnSelected(1)) {
                        if(CartPageCartPanel.cartTable.getValueAt(CartPageCartPanel.cartTable.getSelectedRow(),CartPageCartPanel.cartTable.getSelectedColumn()) != null) {
                            CartPageCartPanel.cartTable.setValueAt("9", CartPageCartPanel.cartTable.getSelectedRow(), CartPageCartPanel.cartTable.getSelectedColumn());
                        }

                        int i = 0;
                        for(Item item : CartPageCartPanel.itemsAdded) {

                            CartPageCartPanel.cartTable.setValueAt(String.format("%.2f",(item.getItemPrice() * SearchedItemsPanel.quantityToAdd.get(i))), i, 3);
                            i += 1;
                        }

                    }
                }
            }
        });

        number0Button.setPreferredSize(buttonDimension);
        number0Button.setFont(buttonFont);
        number0Button.setForeground(new Color(43, 43, 43));
        number0Button.setFocusable(false);

        number0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(TopBarPanel.searchBarField.hasFocus()){
                    TopBarPanel.searchBarField.setText(TopBarPanel.searchBarField.getText() + "0");
                    TopBarPanel.searchBarField.grabFocus();
                }
                if(CartPageCartPanel.cartTable.hasFocus()) {
                    if(CartPageCartPanel.cartTable.isColumnSelected(1)) {
                        if(CartPageCartPanel.cartTable.getValueAt(CartPageCartPanel.cartTable.getSelectedRow(),CartPageCartPanel.cartTable.getSelectedColumn()) != null) {
                            CartPageCartPanel.cartTable.setValueAt("0", CartPageCartPanel.cartTable.getSelectedRow(), CartPageCartPanel.cartTable.getSelectedColumn());
                        }

                        int i = 0;
                        for(Item item : CartPageCartPanel.itemsAdded) {

                            CartPageCartPanel.cartTable.setValueAt(String.format("%.2f",(item.getItemPrice() * SearchedItemsPanel.quantityToAdd.get(i))), i, 3);
                            i += 1;
                        }

                    }
                }
            }
        });

        backspaceButton.setPreferredSize(buttonDimension);
        backspaceButton.setFocusable(false);

        backspaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(TopBarPanel.searchBarField.hasFocus()){
                    if(TopBarPanel.searchBarField.getText().length() > 0) {
                        try {
                            TopBarPanel.searchBarField.setText(TopBarPanel.searchBarField.getText(0, TopBarPanel.searchBarField.getText().length() - 1));
                        } catch (BadLocationException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    TopBarPanel.searchBarField.grabFocus();
                }
            }
        });

        decimalButton.setPreferredSize(buttonDimension);
        decimalButton.setFont(buttonFont);
        decimalButton.setForeground(new Color(43, 43, 43));
        decimalButton.setFocusable(false);

        decimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(TopBarPanel.searchBarField.hasFocus()){

                    TopBarPanel.searchBarField.setText(TopBarPanel.searchBarField.getText() + ".");

                    TopBarPanel.searchBarField.grabFocus();
                }

            }
        });


        cancelOrderButton = new JButton("cancel order");
        cancelOrderButton.setFont(new Font(null, Font.PLAIN, 42));
        cancelOrderButton.setPreferredSize(new Dimension(320, 100));
        cancelOrderButton.setFocusable(false);

        checkoutButton = new JButton("checkout");
        checkoutButton.setFont(new Font(null, Font.PLAIN, 56));
        checkoutButton.setPreferredSize(new Dimension(360, 105));
        checkoutButton.setFocusable(false);

        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogoBarPanel logoPanel = new LogoBarPanel();
                MainFrame checkoutFrame = new MainFrame();
                checkoutFrame.setResizable(false);
                checkoutFrame.setPreferredSize(new Dimension(1200,800));
                PaymentTypePanel paymentPanel = new PaymentTypePanel();
                BottomBarPanel bottomPanel = new BottomBarPanel();
                checkoutFrame.setLayout(new BorderLayout());
                checkoutFrame.add(logoPanel, BorderLayout.PAGE_START);

                checkoutFrame.add(paymentPanel, BorderLayout.CENTER);

                checkoutFrame.add(bottomPanel, BorderLayout.PAGE_END);
                checkoutFrame.pack();
            }
        });


        this.add(number7Button);
        this.add(number8Button);
        this.add(number9Button);
        this.add(number4Button);
        this.add(number5Button);
        this.add(number6Button);
        this.add(number1Button);
        this.add(number2Button);
        this.add(number3Button);
        this.add(decimalButton);
        this.add(number0Button);
        this.add(backspaceButton);
        this.add(Box.createRigidArea(new Dimension(360,25)));
        this.add(cancelOrderButton);
        this.add(Box.createRigidArea(new Dimension(360,20)));
        this.add(checkoutButton);
    }
}

package KioskApp.FrontEnd;

import javax.swing.*;
import java.awt.*;

/**
 * A class that extends JPanel that is a UI that operates as a total panel.
 * It contains sub-total, tax, and grand total labels plus the quantities calculated.
 */
public class TotalBarPanel extends JPanel {
    protected JLabel subtotalLabel;
    static JLabel subtotalQtyLabel;
    protected JLabel discountLabel;
    static JLabel discountQtyLabel;
    protected JLabel taxLabel;
    static JLabel taxQtyLabel;
    protected JLabel totalItemsLabel;
    static JLabel totalItemsQtyLabel;
    protected JLabel totalLabel;
    static JLabel totalQtyLabel;
    static Integer totalItems = 0;
    static Double totalPriceSum = 0.00;
    static Double grandTotal = 0.00;
    static Double taxSum = 0.0;
    static Double discountAdded = 0.0;

    GridBagConstraints gbConst;
    public TotalBarPanel() {
        this.setLayout(new GridBagLayout());
        gbConst = new GridBagConstraints();

        subtotalLabel = new JLabel("Sub Total: ");
        subtotalQtyLabel = new JLabel("$0.00");
        discountLabel = new JLabel("Discount: ");
        discountQtyLabel = new JLabel("$0.00");
        taxLabel = new JLabel("Tax: ");
        taxQtyLabel = new JLabel("$0.00");
        totalItemsLabel = new JLabel("Items: ");
        totalItemsQtyLabel = new JLabel("000");
        totalLabel = new JLabel("Total");
        totalQtyLabel = new JLabel("$0.00");

        subtotalLabel.setFont(new Font(null,Font.PLAIN, 20));
        subtotalLabel.setFocusable(false);
        gbConst.gridx = 0;
        gbConst.gridy = 0;
        gbConst.insets = new Insets(10, 10,10, 10);
        this.add(subtotalLabel, gbConst);

        subtotalQtyLabel.setFont(new Font(null,Font.PLAIN, 20));
        subtotalQtyLabel.setFocusable(false);
        gbConst.gridx = 1;
        gbConst.gridy = 0;
        gbConst.insets = new Insets(10, 0,10, 10);
        this.add(subtotalQtyLabel, gbConst);

        discountLabel.setFont(new Font(null,Font.PLAIN, 20));
        discountLabel.setFocusable(false);
        gbConst.gridx = 0;
        gbConst.gridy = 1;
        gbConst.insets = new Insets(10, 10,10, 10);
        this.add(discountLabel, gbConst);

        discountQtyLabel.setFont(new Font(null,Font.PLAIN, 20));
        discountQtyLabel.setFocusable(false);
        gbConst.gridx = 1;
        gbConst.gridy = 1;
        gbConst.insets = new Insets(10, 0,10, 10);
        this.add(discountQtyLabel, gbConst);

        taxLabel.setFont(new Font(null,Font.PLAIN, 20));
        taxLabel.setFocusable(false);
        gbConst.gridx = 2;
        gbConst.gridy = 0;
        gbConst.insets = new Insets(10, 30,10, 10);
        this.add(taxLabel, gbConst);

        taxQtyLabel.setFont(new Font(null,Font.PLAIN, 20));
        taxQtyLabel.setFocusable(false);
        gbConst.gridx = 3;
        gbConst.gridy = 0;
        gbConst.insets = new Insets(10, 0,10, 10);
        this.add(taxQtyLabel, gbConst);

        totalItemsLabel.setFont(new Font(null,Font.PLAIN, 20));
        totalItemsLabel.setFocusable(false);
        gbConst.gridx = 2;
        gbConst.gridy = 1;
        gbConst.insets = new Insets(10, 30,10, 10);
        this.add(totalItemsLabel, gbConst);

        totalItemsQtyLabel.setFont(new Font(null,Font.PLAIN, 20));
        totalItemsQtyLabel.setFocusable(false);
        gbConst.gridx = 3;
        gbConst.gridy = 1;
        gbConst.insets = new Insets(10, 0,10, 10);
        this.add(totalItemsQtyLabel, gbConst);

        totalLabel.setFont(new Font(null,Font.PLAIN, 30));
        totalLabel.setFocusable(false);
        gbConst.gridx = 4;
        gbConst.gridy = 0;
        gbConst.insets = new Insets(10, 120,0, 60);
        this.add(totalLabel, gbConst);

        totalQtyLabel.setFont(new Font(null,Font.PLAIN, 36));
        totalQtyLabel.setFocusable(false);
        totalQtyLabel.setForeground(new Color(115,188,255));
        gbConst.gridx = 4;
        gbConst.gridy = 1;
        gbConst.insets = new Insets(0, 120,10, 60);
        this.add(totalQtyLabel, gbConst);

    }
}

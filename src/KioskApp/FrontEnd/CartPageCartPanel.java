package KioskApp.FrontEnd;

import KioskApp.Inventory.Item;
import KioskApp.Inventory.ImportItems;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A class that extends JPanel that is the UI for the cart page's cart table.
 * This mainly contains the table and customizations for it as well as some logic surrounding listeners like MouseListener, KeyListener, and TableModelListener.
 */
public class CartPageCartPanel extends JPanel {

    static JTable cartTable;
    static JScrollPane jSP;
    protected static ArrayList<Item> itemsAdded;
    ImportItems importItems = new ImportItems();
    protected static int arraySize = 0;
    protected DefaultTableModel model;
    public CartPageCartPanel() throws IOException {


        arraySize = Integer.parseInt(String.format("%s",importItems.lineCounter()));

        itemsAdded = new ArrayList<>();
        this.setLayout(new BorderLayout(25,25));
        Object[][] tableVals = new Object[arraySize][5];
        String[] columnHeadings = {"NAME", "QTY", "PRICE", "TOTAL", "REMOVE ITEM"};

        model = new DefaultTableModel(tableVals,columnHeadings);

        cartTable = new JTable(model) {
            public boolean isCellEditable(int row, int column) {
                return column == 1;
            }
        };
        jSP = new JScrollPane(cartTable);
        jSP.setPreferredSize(new Dimension(900,500));

        cartTable.getTableHeader().setFont(new Font(null, Font.PLAIN, 23));
        cartTable.getTableHeader().setReorderingAllowed(false);
        add(cartTable.getTableHeader());

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

        for (int i = 0; i < cartTable.getColumnCount(); i++) {
            cartTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);

        }
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        cartTable.setDefaultRenderer(String.class, centerRenderer);

        cartTable.setFont(new Font(null, Font.PLAIN, 20));
        cartTable.setRowHeight(35);
        cartTable.setShowVerticalLines(false);
        cartTable.getColumnModel().getColumn(0).setMinWidth(300);
        cartTable.getColumnModel().getColumn(1).setMinWidth(75);
        cartTable.getColumnModel().getColumn(2).setMinWidth(75);
        cartTable.getColumnModel().getColumn(3).setMinWidth(75);
        cartTable.getColumnModel().getColumn(4).setMinWidth(125);
        cartTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        cartTable.getTableHeader().setReorderingAllowed(false);

        cartTable.setFocusable(true);
        cartTable.setRowSelectionAllowed(true);
        cartTable.setCellSelectionEnabled(true);

        cartTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                BottomBarPanel.dateAndTime.setText("" + BottomBarPanel.getCurrentDateAndTime());
                if(cartTable.getSelectedColumn() == 4)  {
                    if (e.getClickCount() > 1) {
                        if(itemsAdded.size() > 0) {
                            if(cartTable.getValueAt(cartTable.getSelectedRow(),cartTable.getSelectedColumn()).equals("Remove")) {
                                System.out.println("Removed " + cartTable.getValueAt(cartTable.getSelectedRow(),0) + " from cart.");
                                SearchedItemsPanel.quantityToAdd.remove(cartTable.getSelectedRow());
                                TotalBarPanel.taxSum = 0.0;
                                SearchedItemsPanel.taxesAccrued = 0.0;
                                itemsAdded.remove(cartTable.getSelectedRow());
                                model.removeRow(cartTable.getSelectedRow());
                                }
                            }

                        }
                    }
                super.mousePressed(e);
            }
        });

        cartTable.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int i = 0;
                for(Item item : CartPageCartPanel.itemsAdded) {

                    CartPageCartPanel.cartTable.setValueAt(String.format("%.2f",(item.getItemPrice() * SearchedItemsPanel.quantityToAdd.get(i))), i, 3);
                    i += 1;
                }

                if (cartTable.hasFocus()) {
                    cartTable.getSelectionModel().clearSelection();
                }
            }
        });


        cartTable.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {

                if(e.getColumn() == 1) {
                    SearchedItemsPanel.quantityToAdd.set(e.getFirstRow(), (Integer.valueOf(String.valueOf(cartTable.getValueAt(e.getFirstRow(),e.getColumn())))));
                }

                SearchedItemsPanel.items = 0;
                SearchedItemsPanel.itemPriceSum = 0.0;
                for(int j = 0; j < CartPageCartPanel.itemsAdded.size(); ++j ) {
                    SearchedItemsPanel.items += SearchedItemsPanel.quantityToAdd.get(j);
                    if(cartTable.getValueAt(j,3) != null) {
                        SearchedItemsPanel.itemPriceSum += Double.parseDouble(String.valueOf(cartTable.getValueAt(j, +3)));
                    }
                }

                int i = 0;
                TotalBarPanel.taxSum = 0.0;
                SearchedItemsPanel.taxesAccrued = 0.0;
                for (Item item: itemsAdded) {
                    if (item.getDepartmentName().equals("Miscellaneous")) {
                        SearchedItemsPanel.taxesAccrued += (item.getItemPrice() * SearchedItemsPanel.quantityToAdd.get(i)) * 0.06;
                    }
                    ++i;
                }

                TotalBarPanel.taxSum = SearchedItemsPanel.taxesAccrued;
                TotalBarPanel.taxQtyLabel.setText(String.format("$%.2f",TotalBarPanel.taxSum));
                TotalBarPanel.totalPriceSum = SearchedItemsPanel.itemPriceSum;
                TotalBarPanel.totalItems = SearchedItemsPanel.items;
                TotalBarPanel.totalItemsQtyLabel.setText(String.valueOf(TotalBarPanel.totalItems));
                TotalBarPanel.subtotalQtyLabel.setText(String.format("$%.2f",TotalBarPanel.totalPriceSum));

                TotalBarPanel.grandTotal = TotalBarPanel.totalPriceSum + TotalBarPanel.taxSum - TotalBarPanel.discountAdded;
                TotalBarPanel.totalQtyLabel.setText(String.format("$%.2f", TotalBarPanel.grandTotal));

            }
        });

        add(jSP);
    }
}

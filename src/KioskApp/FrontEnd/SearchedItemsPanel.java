package KioskApp.FrontEnd;

import KioskApp.Inventory.Item;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A class that extends JPanel that acts as a UI for items that are searched for from TopBarPanel's searchbar which are in a table format.
 */
public class SearchedItemsPanel extends JPanel {
    private static JTable itemTable;
    static ArrayList<Item> itemsSearched = new ArrayList<>();
    static ArrayList<Integer> quantityToAdd = new ArrayList<>();
    static Double taxesAccrued = 0.0;
    static Integer items;
    static Double itemPriceSum = 0.00;

    public SearchedItemsPanel() throws IOException {

        Object[][] tableVals = new Object[itemsSearched.size()][5];
        String[] tableHeadings = {"Qty to Add", "Name", "Price", "Category", "Barcode"};

        itemTable = new JTable(tableVals, tableHeadings) {
            public boolean isCellEditable(int row, int column) {
                return column <= 0;
            }
        };



        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

        for (int i = 0; i < itemTable.getColumnCount(); i++) {
            itemTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);

        }
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        itemTable.setDefaultRenderer(String.class, centerRenderer);
        JScrollPane tableScrollPane = new JScrollPane(itemTable);
        tableScrollPane.setPreferredSize(new Dimension(1200,800));
        itemTable.getTableHeader().setFont(new Font(null, Font.PLAIN, 23));
        itemTable.getTableHeader().setReorderingAllowed(false);
        itemTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        add(itemTable.getTableHeader());

        itemTable.setRowHeight(35);
        itemTable.setFont(new Font(null, Font.PLAIN, 20));
        itemTable.getColumnModel().getColumn(0).setMinWidth(120);
        itemTable.getColumnModel().getColumn(1).setMinWidth(500);
        itemTable.getColumnModel().getColumn(2).setMinWidth(100);
        itemTable.getColumnModel().getColumn(3).setMinWidth(150);
        itemTable.getColumnModel().getColumn(4).setMinWidth(150);
        itemTable.setFocusable(true);
        itemTable.setRowSelectionAllowed(true);
        itemTable.setCellSelectionEnabled(true);


        int i = 0;
        for(Item item : itemsSearched) {

            itemTable.setValueAt(item.getItemName(), i, 1);
            itemTable.setValueAt(String.format("$%.2f",item.getItemPrice()), i, 2);
            itemTable.setValueAt(item.getDepartmentName(), i, 3);
            itemTable.setValueAt(item.getItemBarcode(), i, 4);
            i += 1;
        }

        itemTable.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                try{
                    try {
                        Integer.parseInt((String) itemTable.getValueAt(e.getFirstRow(),e.getColumn()));
                        System.out.println("Adding: " + itemsSearched.get(e.getFirstRow()).toString() + ", x " + itemTable.getValueAt(e.getFirstRow(), e.getColumn()) + " to cart.");
                    } catch (NumberFormatException exception) {
                        System.out.println("Non-number entered...");
                    }
                    CartPageCartPanel.itemsAdded.add(itemsSearched.get(e.getFirstRow()));
                    SearchedItemsPanel.quantityToAdd.add(Integer.parseInt((String)itemTable.getValueAt(e.getFirstRow(),e.getColumn())));


                items = 0;
                for(int j = 0; j < CartPageCartPanel.itemsAdded.size(); ++j ) {
                    items += SearchedItemsPanel.quantityToAdd.get(j);
                }
                TotalBarPanel.totalItems = items;



                taxesAccrued = 0.0;
                int i = 0;
                for(Item item : CartPageCartPanel.itemsAdded) {

                    CartPageCartPanel.cartTable.setValueAt(item.getItemName(), i, 0);
                    CartPageCartPanel.cartTable.setValueAt(quantityToAdd.get(i), i, 1);
                    CartPageCartPanel.cartTable.setValueAt(String.format("$%.2f",item.getItemPrice()), i, 2);
                    CartPageCartPanel.cartTable.setValueAt(String.format("%.2f",(item.getItemPrice() * SearchedItemsPanel.quantityToAdd.get(i))), i, 3);
                    CartPageCartPanel.cartTable.setValueAt(("Remove"), i, 4);

                    TotalBarPanel.totalItemsQtyLabel.setText(String.valueOf(TotalBarPanel.totalItems));
                    TotalBarPanel.subtotalQtyLabel.setText(String.format("$%.2f",(TotalBarPanel.totalPriceSum)));

                    if(item.getDepartmentName().equals("Miscellaneous")) {
                        taxesAccrued += (item.getItemPrice() *  quantityToAdd.get(i)) * 0.06;
                    }
                    ++i;
                }
                } catch (Exception ex) {
                    System.out.println("Error: " + ex.getMessage());

                    CartPageCartPanel.itemsAdded.remove(CartPageCartPanel.itemsAdded.size() - 1);

                }
            }
        });

        add(tableScrollPane);

    }

}


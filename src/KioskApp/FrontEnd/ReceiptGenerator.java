package KioskApp.FrontEnd;

import KioskApp.Inventory.Item;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Class that generates receipts with the items added to the cart in the cart page, accessible from the payment page.
 * Receipts are stored in src/Receipts/ with the format of Receipt-hh.mm.ss-MM-dd-yyyy.txt.
 * Contains store, register, date and time, payment type up top with items sorted by department with the barcode number, item name, item price, and item quantity below the department type.
 * Below that, item count, sub-total, tax, and grand total is outputted.
 */
public class ReceiptGenerator {

    /**
     * Method that is responsible for writing to a new file the generated receipt information.
     * Stored in src/Receipts/ with the format of Receipt-hh.mm.ss-MM-dd-yyyy.txt.
     * @throws IOException thrown when writing gets interrupted or there is an issue with writing to the file.
     */
    public void receiptOutput() throws IOException {

        String filePath = "src/Receipts/";
        String fileName = "Receipt" + "-" + getCurrentDateAndTime();
        String fileType = "txt";
        File receiptFile = new File(filePath + fileName + "." + fileType);
        if(!receiptFile.exists()) {
            receiptFile.createNewFile();
        } else {
            System.out.println("Write Error ...");
        }

        FileOutputStream fileStream = new FileOutputStream(receiptFile, true);
        PrintWriter outputFS = new PrintWriter(fileStream);
        outputFS.append("Store: " + "Example Store\n");
        outputFS.append("Register: " + "Kiosk Number\n");
        outputFS.append("Date and Time: ").append(BottomBarPanel.getCurrentDateAndTime()).append("\n");
        outputFS.append("Payment Type: ").append(PaymentTypePanel.paymentType).append("\n");

        outputFS.append("\n");

        outputFS.append("Bakery Items: " + "\n");
        int i = 0;
        boolean contains = false;
        for (Item item: CartPageCartPanel.itemsAdded) {
            if(item.getDepartmentName().equals("Bakery")) {
                outputFS.append(item.getItemBarcode()).append("\t").append(item.getItemName()).append("\t").append(String.valueOf(item.getItemPrice())).append(" x ").append(String.valueOf(SearchedItemsPanel.quantityToAdd.get(i))).append("\n");
                contains = true;
            }
            i++;
        }

        if(!contains) {
            outputFS.append("N/A\n");
        }

        outputFS.append("\n");

        outputFS.append("Pantry Items: " + "\n");
        i = 0;
        contains = false;
        for (Item item: CartPageCartPanel.itemsAdded) {
            if(item.getDepartmentName().equals("Pantry")) {
                outputFS.append(item.getItemBarcode()).append("\t").append(item.getItemName()).append("\t").append(String.valueOf(item.getItemPrice())).append(" x ").append(String.valueOf(SearchedItemsPanel.quantityToAdd.get(i))).append("\n");
                contains = true;
            }
            i++;
        }

        if(!contains) {
            outputFS.append("N/A\n");
        }

        outputFS.append("\n");

        outputFS.append("Frozen Items: " + "\n");
        i = 0;
        contains = false;
        for (Item item: CartPageCartPanel.itemsAdded) {
            if(item.getDepartmentName().equals("Frozen")) {
                outputFS.append(item.getItemBarcode()).append("\t").append(item.getItemName()).append("\t").append(String.valueOf(item.getItemPrice())).append(" x ").append(String.valueOf(SearchedItemsPanel.quantityToAdd.get(i))).append("\n");
                contains = true;
            }
            i++;
        }

        if(!contains) {
            outputFS.append("N/A\n");
        }

        outputFS.append("\n");

        outputFS.append("Produce Items: " + "\n");
        i = 0;
        contains = false;
        for (Item item: CartPageCartPanel.itemsAdded) {
            if(item.getDepartmentName().equals("Produce")) {
                outputFS.append(item.getItemBarcode()).append("\t").append(item.getItemName()).append("\t").append(String.valueOf(item.getItemPrice())).append(" x ").append(String.valueOf(SearchedItemsPanel.quantityToAdd.get(i))).append("\n");
                contains = true;
            }
            i++;
        }
        if(!contains) {
            outputFS.append("N/A\n");
        }

        outputFS.append("\n");

        outputFS.append("Dairy Items: " + "\n");
        i = 0;
        contains = false;
        for (Item item: CartPageCartPanel.itemsAdded) {
            if(item.getDepartmentName().equals("Dairy")) {
                outputFS.append(item.getItemBarcode()).append("\t").append(item.getItemName()).append("\t").append(String.valueOf(item.getItemPrice())).append(" x ").append(String.valueOf(SearchedItemsPanel.quantityToAdd.get(i))).append("\n");
                contains = true;
            }
            i++;
        }

        if(!contains) {
            outputFS.append("N/A\n");
        }
        outputFS.append("\n");

        outputFS.append("Misc Items: " + "\n");
        i = 0;
        contains = false;
        for (Item item: CartPageCartPanel.itemsAdded) {

            if(item.getDepartmentName().equals("Miscellaneous")) {
                outputFS.append(item.getItemBarcode()).append("\t").append(item.getItemName()).append("\t").append(String.valueOf(item.getItemPrice())).append(" x ").append(String.valueOf(SearchedItemsPanel.quantityToAdd.get(i))).append("\n");
                contains = true;
            }
            i++;
        }
        if(!contains) {
            outputFS.append("N/A\n");
        }
        outputFS.append("\n");

        outputFS.append("Items: ").append(String.valueOf(TotalBarPanel.totalItems)).append("\n");

        outputFS.append("\n");

        outputFS.append("Sub-total: $").append(String.format("%.2f", TotalBarPanel.totalPriceSum)).append("\n");
        outputFS.append("Tax: $").append(String.format("%.2f", TotalBarPanel.taxSum)).append("\n");

        outputFS.append("\n");

        outputFS.append("Total : $").append(String.format("%.2f", TotalBarPanel.grandTotal)).append("\n");

        outputFS.close();
    }

    /**
     * Date and time formatter responsible for obtaining the date and time in a specific format.
     * @return date and time as String in the format of hh.mm.ss-MM-dd-yy.
     */
    static String getCurrentDateAndTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh.mm.ss-MM-dd-yyyy");
        LocalDateTime now = LocalDateTime.now();
        return dateTimeFormatter.format(now);
    }
}

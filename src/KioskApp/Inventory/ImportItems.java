package KioskApp.Inventory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is a class that imports items to KioskApp by retrieving them from the ItemList.csv file.
 * It reads the file, retrieves the information on it, and recreates the various types of item objects based on the department and makes the ArrayList<Item> available to the program.
 */
public class ImportItems {

    /**
     * Text from line, Stored as String
     */
    private String lineTxt;

    /**
     * item name from line, Stored as String
     */
    private String itemName = "";

    /**
     * item type from line, Stored as String
     */
    private String itemType = "";

    /**
     * item barcode from line, Stored as String
     */
    private String itemBarcode = "";

    /**
     * item price from line, Stored as String
     */
    private String itemPriceTxt = "";

    /**
     * File input stream from ItemList.csv
     */
    private FileInputStream inputStream = new FileInputStream("src\\ItemList.csv");

    /**
     * Scanner from inputStream reading ItemList.csv
     */
    private Scanner inputStreamScanner = new Scanner(inputStream);



    public ImportItems() throws FileNotFoundException {
    }

    /**
     * Class that imports items that are stored in ItemList.csv by reading the file and recreating the objects based on department
     * @return ArrayList of Item with loaded items from file
     */
    public ArrayList<Item> importItems() {

        ArrayList<Item> itemsInInventory = new ArrayList<>();

        System.out.println("Importing items ...");

        inputStreamScanner.nextLine();
        lineTxt = inputStreamScanner.nextLine();

        for(int i = 1; i < lineCounter(); i++) {
            this.itemBarcode = getItemBarcode();
            this.itemName = getItemName();
            String itemPrice = getItemPrice();
            this.itemType = getItemType();

            switch(itemType) {
                case "produce" -> {
                    ProduceItem produceItem = new ProduceItem(itemName, Double.valueOf(itemPrice),itemBarcode);
                    itemsInInventory.add(produceItem);
                }
                case "dairy" -> {
                    DairyItem dairyItem = new DairyItem(itemName, Double.valueOf(itemPrice), itemBarcode);
                    itemsInInventory.add(dairyItem);
                }
                case "frozen" -> {
                    FrozenItem frozenItem = new FrozenItem(itemName, Double.valueOf(itemPrice), itemBarcode);
                    itemsInInventory.add(frozenItem);
                }
                case "pantry" -> {
                    PantryItem pantryItem = new PantryItem(itemName, Double.valueOf(itemPrice), itemBarcode);
                    itemsInInventory.add(pantryItem);
                }
                case "misc" -> {
                    MiscItem miscItem = new MiscItem(itemName, Double.valueOf(itemPrice), itemBarcode);
                    itemsInInventory.add(miscItem);
                }
                case "bakery" -> {
                    BakeryItem bakeryItem = new BakeryItem(itemName, Double.valueOf(itemPrice), itemBarcode);
                    itemsInInventory.add(bakeryItem);
                }

                default -> System.out.println("Error in reading: " + itemType);
            }

            itemName = "";
            itemType = "";
            itemPriceTxt = "";
            itemBarcode = "";

            if (inputStreamScanner.hasNext()) {
                lineTxt = inputStreamScanner.nextLine();
            } else {
                System.out.println("Inventory Size: " + itemsInInventory.size());
                System.out.println("All items imported.");
            }
        }
        return itemsInInventory;
    }

    /**
     * Gets item barcode on a line
     * @return item barcode as String
     */
    public String getItemBarcode() {
        for(int i = 0; i < lineTxt.length(); i++) {
            if(lineTxt.charAt(i) != ',') {
                itemBarcode += lineTxt.charAt(i);
            } else {
                break;
            }
        }
        return itemBarcode;
    }

    /**
     * Gets item name on a line
     * @return item name as String
     */
    public String getItemName() {
        for (int i = itemBarcode.length() + 1; i < lineTxt.length(); ++i) {
            if (lineTxt.charAt(i) != ',') {
                itemName += lineTxt.charAt(i);
            } else {
                break;
            }
        }
        return itemName;
    }

    /**
     * Gets item price on a line
     * @return item price as String
     */
    public String getItemPrice() {
        for (int i = itemName.length() + 2 + itemBarcode.length(); i < lineTxt.length(); ++i) {
            if (lineTxt.charAt(i) != ',') {
                itemPriceTxt += lineTxt.charAt(i);
            } else {
                break;
            }
        }
        return itemPriceTxt;
    }

    /**
     * Gets item type (department) from a line
     * @return item type (department)
     */
    public String getItemType() {
        for (int i = itemPriceTxt.length() + 3 + itemBarcode.length() + itemName.length(); i < lineTxt.length(); ++i) {
            if (lineTxt.charAt(i) != ',') {
                itemType += lineTxt.charAt(i);
            } else {
                break;
            }
        }
        return itemType;
    }

    /**
     * Gets number of lines on file
     * @return returns number of lines in file as Long
     */
    public Long lineCounter() {
        long lines = 0L;
        try {
            Path path = Paths.get("src/ItemList.csv");
            lines = Files.lines(path).count();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lines;
    }
}

package KioskApp.Inventory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * A class with methods that allows for the creation of various objects inherited from Item and for the items to be stored in ItemList.csv
 * There are methods that allow users to create bakery, dairy, frozen, pantry, and misc item objects and there is a method that stores the items in ItemList.csv.
 * createProduceItem(), createBakeryItem, createDairyItem, createFrozenItem, createPantryItem(), and createMiscItem() are all methods available as well as the storeItems() method.
 */
public class CreateAndStoreItems {

    /**
     * Method that creates a produce item and stores it in ItemList.csv
     * @param itemName item name, as String
     * @param itemPrice item price, as Double
     * @param itemBarcode item barcode number, as String
     * @throws FileNotFoundException thrown if ItemList.csv is not in its original location (the src folder)
     */
    public void createProduceItem(String itemName, Double itemPrice, String itemBarcode) throws FileNotFoundException{

        String itemType = "produce";
        ProduceItem produceItem = new ProduceItem(itemName, itemPrice);
        storeItems(itemName, itemPrice, itemBarcode, itemType);

    }

    /**
     * Method that creates a bakery item and stores it in ItemList.csv
     * @param itemName item name, as String
     * @param itemPrice item price, as Double
     * @param itemBarcode item barcode number, as String
     * @throws FileNotFoundException thrown if ItemList.csv is not in its original location (the src folder)
     */
    public void createBakeryItem(String itemName, Double itemPrice, String itemBarcode) throws FileNotFoundException {

        String itemType = "bakery";
        BakeryItem bakeryItem;
        bakeryItem = new BakeryItem(itemName, itemPrice);
        storeItems(itemName, itemPrice, itemBarcode, itemType);

    }

    /**
     * Method that creates a dairy item and stores it in ItemList.csv
     * @param itemName item name, as String
     * @param itemPrice item price, as Double
     * @param itemBarcode item barcode number, as String
     * @throws FileNotFoundException thrown if ItemList.csv is not in its original location (the src folder)
     */
    public void createDairyItem(String itemName, Double itemPrice, String itemBarcode) throws FileNotFoundException {

        String itemType = "dairy";
        DairyItem dairyItem = new DairyItem(itemName, itemPrice, itemBarcode);
        storeItems(itemName, itemPrice, itemBarcode, itemType);

    }

    /**
     * Method that creates a frozen item and stores it in ItemList.csv
     * @param itemName item name, as String
     * @param itemPrice item price, as Double
     * @param itemBarcode item barcode number, as String
     * @throws FileNotFoundException thrown if ItemList.csv is not in its original location (the src folder)
     */
    public void createFrozenItem(String itemName, Double itemPrice, String itemBarcode) throws FileNotFoundException {

        String itemType = "frozen";
        FrozenItem frozenItem = new FrozenItem(itemName, itemPrice, itemBarcode);
        storeItems(itemName, itemPrice, itemBarcode, itemType);

    }

    /**
     * Method that creates a pantry item and stores it in ItemList.csv
     * @param itemName item name, as String
     * @param itemPrice item price, as Double
     * @param itemBarcode item barcode number, as String
     * @throws FileNotFoundException thrown if ItemList.csv is not in its original location (the src folder)
     */
    public void createPantryItem(String itemName, Double itemPrice, String itemBarcode) throws FileNotFoundException {

        String itemType = "pantry";
        PantryItem pantryItem = new PantryItem(itemName, itemPrice);
        storeItems(itemName, itemPrice, itemBarcode, itemType);

    }

    /**
     * Method that creates a miscellaneous item and stores it in ItemList.csv
     * @param itemName item name, as String
     * @param itemPrice item price, as Double
     * @param itemBarcode item barcode number, as String
     * @throws FileNotFoundException thrown if ItemList.csv is not in its original location (the src folder)
     */
    public void createMiscItem(String itemName, Double itemPrice, String itemBarcode) throws FileNotFoundException {

        String itemType = "misc";
        MiscItem miscItem = new MiscItem(itemName, itemPrice);
        storeItems(itemName, itemPrice, itemBarcode, itemType);

    }

    /**
     * Method that stores an item in ItemList.csv in csv format
     * @param itemName item name, as String
     * @param itemPrice item price, as Double
     * @param itemBarcode item barcode number, as String
     * @param itemType item department, as String
     * @throws FileNotFoundException thrown if ItemList.csv is not in its original location (the src folder)
     */
    public void storeItems(String itemName, Double itemPrice,String itemBarcode, String itemType) throws FileNotFoundException {
        FileOutputStream fileStream = new FileOutputStream("src\\ItemList.csv", true);
        PrintWriter outputFS = new PrintWriter(fileStream);

        outputFS.append(itemBarcode);
        outputFS.append(",");
        outputFS.append(itemName);
        outputFS.append(",");
        outputFS.append("").append(String.valueOf(itemPrice));
        outputFS.append(",");
        outputFS.append(itemType);
        outputFS.append("\n");
        outputFS.close();
    }

}

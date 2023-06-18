package KioskApp.Inventory;

/**
 * A class that represents an item from the Miscellaneous department, inheriting from Item.
 */
public class MiscItem extends Item{

    /**
     * Default constructor that sets the item's name and barcode to "", item price to 0.00, and department name to "Miscellaneous"
     */
    public MiscItem() {
        setItemName("");
        setItemPrice(0.00);
        setDepartmentName("Miscellaneous");
        setBarcodeNumber("");
    }

    /**
     * Overloaded constructor that sets the item's name to itemName, barcode to "", item price to itemPrice, and department name to "Miscellaneous"
     * @param itemName item name as String
     * @param itemPrice item price as Double
     */
    public MiscItem(String itemName, Double itemPrice) {
        setItemName(itemName);
        setItemPrice(itemPrice);
        setDepartmentName("Miscellaneous");
        setBarcodeNumber("");
    }

    /**
     * Overloaded constructor that sets the item's name to itemName, item barcode to barcodeNumber, item price to itemPrice, and department name to "Miscellaneous"
     * @param itemName item name as String
     * @param itemPrice item price as Double
     * @param barcodeNumber item barcode number as String
     */
    public MiscItem(String itemName, Double itemPrice, String barcodeNumber) {
        setItemName(itemName);
        setItemPrice(itemPrice);
        setDepartmentName("Miscellaneous");
        setBarcodeNumber(barcodeNumber);
    }
}

package KioskApp.Inventory;

/**
 * A class that represents an item from the dairy department, inheriting from Item.
 */
public class DairyItem extends Item{

    /**
     * Default constructor that sets the item's name and barcode to "", price to 0.00, and department name to "Dairy"
     */
    public DairyItem() {
        setItemName("");
        setItemPrice(0.00);
        setDepartmentName("Dairy");
        setBarcodeNumber("");
    }

    /**
     * Overloaded constructor that sets the item's name to itemName, barcode to "", item price to itemPrice, and department name to "Dairy"
     * @param itemName item name as String
     * @param itemPrice item price as Double
     */
    public DairyItem(String itemName, Double itemPrice) {
        setItemName(itemName);
        setItemPrice(itemPrice);
        setDepartmentName("Dairy");
        setBarcodeNumber("");
    }

    /**
     * Overloaded constructor that sets the item's name to itemName, item barcode to barcodeNumber, item price to itemPrice, and department name to "Dairy"
     * @param itemName item name as String
     * @param itemPrice item price as Double
     * @param barcodeNumber item barcode number as String
     */
    public DairyItem(String itemName, Double itemPrice, String barcodeNumber) {
        setItemName(itemName);
        setItemPrice(itemPrice);
        setDepartmentName("Dairy");
        setBarcodeNumber(barcodeNumber);
    }
}

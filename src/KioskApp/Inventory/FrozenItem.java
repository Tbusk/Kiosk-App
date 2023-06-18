package KioskApp.Inventory;

/**
 * A class that represents an item from the Frozen department, inheriting from Item.
 */
public class FrozenItem extends Item{

    /**
     * Default constructor that sets the item's name and barcode to "", item price to 0.00, and department name to "Frozen"
     */
    public FrozenItem() {
        setItemName("");
        setItemPrice(0.00);
        setDepartmentName("Frozen");
        setBarcodeNumber("");
    }

    /**
     * Overloaded constructor that sets the item's name to itemName, barcode to "", item price to itemPrice, and department name to "Frozen"
     * @param itemName item name as String
     * @param itemPrice item price as Double
     */
    public FrozenItem(String itemName, Double itemPrice) {
        setItemName(itemName);
        setItemPrice(itemPrice);
        setDepartmentName("Frozen");
        setBarcodeNumber("");
    }

    /**
     * Overloaded constructor that sets the item's name to itemName, item barcode to barcodeNumber, item price to itemPrice, and department name to "Frozen"
     * @param itemName item name as String
     * @param itemPrice item price as Double
     * @param barcodeNumber item barcode number as String
     */
    public FrozenItem(String itemName, Double itemPrice, String barcodeNumber) {
        setItemName(itemName);
        setItemPrice(itemPrice);
        setDepartmentName("Frozen");
        setBarcodeNumber(barcodeNumber);
    }
}

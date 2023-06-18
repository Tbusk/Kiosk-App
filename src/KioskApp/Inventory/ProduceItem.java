package KioskApp.Inventory;

/**
 * A class that represents an item from the Produce department, inheriting from Item.
 */
public class ProduceItem extends Item{

    /**
     * Default constructor that sets the item's name and barcode to "", item price to 0.00, and department name to "Produce"
     */
    public ProduceItem() {
        setItemName("");
        setItemPrice(0.00);
        setDepartmentName("Produce");
        setBarcodeNumber("");
    }

    /**
     * Overloaded constructor that sets the item's name to itemName, barcode to "", item price to itemPrice, and department name to "Produce"
     * @param itemName item name as String
     * @param itemPrice item price as Double
     */
    public ProduceItem(String itemName, Double itemPrice) {
        setItemName(itemName);
        setItemPrice(itemPrice);
        setDepartmentName("Produce");
        setBarcodeNumber("");
    }

    /**
     * Overloaded constructor that sets the item name to itemName, item barcode to barcodeNumber, item price to itemPrice, and department name to "Produce"
     * @param itemName item name as String
     * @param itemPrice item price as Double
     * @param barcodeNumber item barcode number as String
     */
    public ProduceItem(String itemName, Double itemPrice, String barcodeNumber) {
        setItemName(itemName);
        setItemPrice(itemPrice);
        setDepartmentName("Produce");
        setBarcodeNumber(barcodeNumber);
    }

}

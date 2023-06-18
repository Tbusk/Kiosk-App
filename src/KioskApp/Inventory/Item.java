package KioskApp.Inventory;

/**
 * Class of items to be used for items in grocery stores.
 * Contains several variables relating to grocery store items like name, department, price, and barcode.
 * Cotains several overloaded constructors as well as methods to set and get variables.
 */
public class Item {
    /**
     * name of item as String
     */
    private String itemName;

    /**
     * name of department as String
     */
    private String departmentName;

    /**
     * price of item as Double
     */
    private Double itemPrice;

    /**
     * barcode of item as String
     */
    private String barcodeNumber;

    /**
     * Default constructor.  Sets item name, department name, and barcode number to "", and price to 0.00.
     */
    Item() {
        this.itemName = "";
        this.departmentName = "";
        this.itemPrice = 0.00;
        this.barcodeNumber = "";
    }

    /**
     * Overloaded constructor.  Sets item name to itemName, department name and barcode number to "", and price to itemPrice.
     */
    Item(String itemName, Double itemPrice) {
        this.itemName = itemName;
        this.departmentName = "";
        this.itemPrice = itemPrice;
        this.barcodeNumber = "";
    }

    /**
     * Overloaded constructor.  Sets item name to itemName, department name to departmentName, item barcode number to "", and item price to itemPrice.
     */
    Item(String itemName, Double itemPrice, String departmentName) {
        this.itemName = itemName;
        this.departmentName = departmentName;
        this.itemPrice = itemPrice;
        this.barcodeNumber = "";
    }

    /**
     * Overloaded constructor.  Sets item name to itemName, department name to departmentName, item barcode number to barcodeNumber, and item price to itemPrice.
     */
    Item(String itemName, Double itemPrice, String departmentName, String barcodeNumber) {
        this.itemName = itemName;
        this.departmentName = departmentName;
        this.itemPrice = itemPrice;
        this.barcodeNumber = barcodeNumber;
    }

    /**
     * Sets item's name to parameter itemName
     * @param itemName name of item as String
     */
    void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Sets item's price to parameter itemPrice
     * @param itemPrice price of item
     */
    void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * Sets item's department name to parameter departmentName
     * @param departmentName department name of item
     */
    protected void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * Gets item's name
     * @return item name as String
     */
    public String getItemName() {
        return this.itemName;
    }

    /**
     * Sets item's barcode number to parameter barcodeNumber
     * @param barcodeNumber barcode number of item
     */
    protected void setBarcodeNumber(String barcodeNumber) {
        this.barcodeNumber = barcodeNumber;
    }

    /**
     * Gets department name of item
     * @return department name of item, as String
     */
    public String getDepartmentName() {
        return this.departmentName;
    }

    /**
     * Gets item price
     * @return item price, as Double
     */
    public Double getItemPrice() {
        return this.itemPrice;
    }

    /**
     * Gets item's barcode number
     * @return item barcode number, as String
     */
    public String getItemBarcode() {
        return this.barcodeNumber;
    }

    /**
     * Overrides default String return value of Item.
     * @return a String of Item: itemName, Price: itemPrice, Barcode: barcodeNumber
     */
    @Override
    public String toString() {
        return "Item: " + itemName + ", Price: " + itemPrice + ", Barcode: " + barcodeNumber;
    }

}

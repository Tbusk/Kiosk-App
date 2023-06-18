package KioskApp.Inventory;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This is a class that allows a user to easily add items to ItemList.csv, which in turn allows the items to be available in the program.
 * @see CreateAndStoreItems class for more details
 */
public class CreateAndStoreItemsDriver {
    public static void main(String[] args) {

        try {

            Scanner scnr = new Scanner(System.in);
            CreateAndStoreItems createAndStoreItems = new CreateAndStoreItems();
            boolean doneEntering = false;
            String itemName, itemType, itemBarcode, wishToExit, enteredCorrectly;
            Double itemPrice;

            while (!doneEntering) {
                System.out.println("Enter an item name to add: ");
                itemName = scnr.nextLine();
                System.out.println("Item price: ");
                itemPrice = scnr.nextDouble();
                System.out.println("Item type: ");
                itemType = scnr.next();
                System.out.println("Item barcode: ");
                itemBarcode = scnr.next();

                System.out.printf("Item: %s, Price: %s, Type: %s, Barcode: %s \n", itemName, itemPrice, itemType, itemBarcode);
                System.out.println("Is this correct? Enter yes if correct.");
                enteredCorrectly = scnr.next();
                if (enteredCorrectly.equalsIgnoreCase("Yes")) {
                    switch (itemType) {
                        case "produce", "Produce" -> createAndStoreItems.createProduceItem(itemName, itemPrice, itemBarcode);
                        case "bakery", "Bakery" -> createAndStoreItems.createBakeryItem(itemName, itemPrice, itemBarcode);
                        case "dairy", "Dairy" -> createAndStoreItems.createDairyItem(itemName, itemPrice, itemBarcode);
                        case "frozen", "Frozen" -> createAndStoreItems.createFrozenItem(itemName, itemPrice, itemBarcode);
                        case "pantry", "Pantry" -> createAndStoreItems.createPantryItem(itemName, itemPrice, itemBarcode);
                        case "misc", "Misc" -> createAndStoreItems.createMiscItem(itemName, itemPrice, itemBarcode);
                    }
                }
                System.out.println("Are you done entering items? Type yes if done.");
                wishToExit = scnr.next();
                scnr.nextLine();
                if (wishToExit.equalsIgnoreCase("Yes")) {
                    doneEntering = true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }



    }
}

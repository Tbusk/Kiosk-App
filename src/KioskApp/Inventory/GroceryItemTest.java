package KioskApp.Inventory;

import KioskApp.FrontEnd.Main;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroceryItemTest {

    Item item = new Item();
    @BeforeAll()
    static void beforeAll() {
        System.out.println("Testing beginning on grocery store items - creating and reading");
    }

    @DisplayName("Testing Item setItemName(), getItemName()")
    @Test
    void testSetItemName() {
        item.setItemName("Crayons");
        assertEquals("Crayons", item.getItemName(), "Error in setting and getting item name!");

        item.setItemName("Ice Cream");
        assertEquals("Ice Cream", item.getItemName(), "Error in setting and getting item name!");

        item.setItemName("Mints");
        assertEquals("Mints", item.getItemName(), "Error in setting and getting item name!");

        item.setItemName("1oz Chocolate Bar, Hersheys");
        assertEquals("1oz Chocolate Bar, Hersheys", item.getItemName(), "Error in setting and getting item name!");
    }

    @DisplayName("Testing Item setItemPrice(), getItemPrice()")
    @Test
    void testSetItemPrice() {
        item.setItemPrice(0.00);
        assertEquals(0.00, item.getItemPrice(), "Error in setting and getting item price!");

        item.setItemPrice(-0.00);
        assertEquals(-0.00, item.getItemPrice(), "Error in setting and getting item price!");

        item.setItemPrice(11111.00);
        assertEquals(11111.00, item.getItemPrice(), "Error in setting and getting item price!");

        item.setItemPrice(0.01);
        assertEquals(0.01, item.getItemPrice(), "Error in setting and getting item price!");
    }

    @DisplayName("Testing Item setDepartmentName(), getDepartmentName()")
    @Test
    void testSetDepartmentName() {
        item.setDepartmentName("Frozen");
        assertEquals("Frozen", item.getDepartmentName(), "Error in setting and getting item department!");

        item.setDepartmentName("Pantry");
        assertEquals("Pantry", item.getDepartmentName(), "Error in setting and getting item department!");

        item.setDepartmentName("Pharmacy");
        assertEquals("Pharmacy", item.getDepartmentName(), "Error in setting and getting item department!");

        item.setDepartmentName("Bakery");
        assertEquals("Bakery", item.getDepartmentName(), "Error in setting and getting item department!");
    }

    @DisplayName("Testing Item setBarcodeNumber(), getBarcodeNumber()")
    @Test
    void testSetBarcodeNumber() {
        item.setBarcodeNumber("0");
        assertEquals("0", item.getItemBarcode(), "Error in setting and getting item barcode number!");

        item.setBarcodeNumber("x");
        assertEquals("x", item.getItemBarcode(), "Error in setting and getting item barcode number!");

        item.setBarcodeNumber("00000000000000000");
        assertEquals("00000000000000000", item.getItemBarcode(), "Error in setting and getting item barcode number!");

        item.setBarcodeNumber("1093540913245234");
        assertEquals("1093540913245234", item.getItemBarcode(), "Error in setting and getting item barcode number!");

    }

    @AfterAll
    static void afterAll() {
        System.out.println("Tests finished up on Item class ...");
    }
}

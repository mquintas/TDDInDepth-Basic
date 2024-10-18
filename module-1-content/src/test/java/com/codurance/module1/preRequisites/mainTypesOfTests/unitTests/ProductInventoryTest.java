package com.codurance.module1.preRequisites.mainTypesOfTests.unitTests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductInventoryTest {

    //indirectly tested on the second test shouldAddStock.
    @Test
    public void shouldReturnStock() {
        ProductInventory pi = new ProductInventory();
        int expectedQty = 1000;
        String productId = "P1";
        pi.addStock(productId,expectedQty);
        assertEquals(expectedQty, pi.checkStock(productId));

    }

    @Test
    public void shouldAddStock() {
        ProductInventory pi = new ProductInventory();
        int expectedQty = 1000;
        String productId = "P1";

        pi.addStock(productId,expectedQty);

        assertEquals(expectedQty, pi.checkStock(productId));

    }

    @Test
    public void shouldReturnStockZeroWhenProductNotInInventory() {
        ProductInventory pi = new ProductInventory();
        int expectedQty = 0;
        String productId = "P1";

        assertEquals(expectedQty, pi.checkStock(productId));
    }

    @Test
    public void shouldRemoveStockSuccessfully() {
        ProductInventory pi = new ProductInventory();
        int expectedQty = 100;
        String productId = "P1";

        pi.addStock(productId,200);
        pi.removeStock(productId, 100);
        assertEquals(expectedQty, pi.checkStock(productId));
    }

    @Test
    public void shouldNotRemoveStockIfNoStock() {
        ProductInventory pi = new ProductInventory();
        String productId = "P1";

        pi.addStock(productId,10);

        assertThrows(IllegalArgumentException.class, () ->  pi.removeStock(productId, 100));

    }
}

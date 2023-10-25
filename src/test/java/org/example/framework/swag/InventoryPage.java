package org.example.framework.swag;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class InventoryPage {
    private final Page page;
    private final Locator goToCart;
    private final List<InventoryItem> inventoryItems;

    public InventoryPage(Page page) {
        assertThat(page.getByText("Products")).isVisible();

        this.page = page;
        this.goToCart = page.locator("#shopping_cart_container");
        this.inventoryItems = page.locator(".inventory_item").all().stream().map(InventoryItem::create).toList();
    }

    private InventoryItem getItem(String itemName) {
        return inventoryItems.stream()
                .filter(it -> it.name().equals(itemName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("item not found, itemName=%s, availableItems=%s".formatted(itemName, inventoryItems)));
    }

    public InventoryPage addItemToCart(String itemName) {
        getItem(itemName).addToCart();

        return this;
    }

    public List<InventoryItem> getItems() {
        return inventoryItems;
    }

    public CartPage goToCart() {
        this.goToCart.click();

        return new CartPage(page);
    }
}

package org.example.framework.saucedemo.inventory;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.framework.saucedemo.cart.CartPage;
import org.example.framework.PageObject;
import org.example.framework.saucedemo.inventory.InventoryItem.InventoryItemDescription;

import java.util.List;
import java.util.stream.Stream;

public class InventoryPage extends PageObject {
    private final Locator sortBySelect;
    private final Locator shoppingCartLink;

    public InventoryPage(Page page) {
        super(page);
        this.sortBySelect = page.locator(".product_sort_container");
        this.shoppingCartLink = page.locator("a.shopping_cart_link");
    }

    public InventoryPage sort(SortBy sortBy) {
        sortBySelect.selectOption(sortBy.text);

        return this;
    }

    public List<InventoryItemDescription> getContent() {
        return getInventoryItems()
                .map(it -> it.description)
                .toList();
    }

    private Stream<InventoryItem> getInventoryItems() {
        return page.locator(".inventory_item").all().stream()
                .map(InventoryItem::new);
    }

    public InventoryPage addItemToCard(String itemTitle) {
        getInventoryItems()
                .filter(it -> it.description.title().equals(itemTitle))
                .findFirst().orElseThrow(() -> new RuntimeException("missing item, title=%s".formatted(itemTitle)))
                .addToCart();

        return this;
    }

    public CartPage openCart() {
        shoppingCartLink.click();

        return new CartPage(page);
    }

    public enum SortBy {
        NAME_AZ("Name (A to Z)"),
        NAME_ZA("Name (Z to A)"),
        PRICE_LOW_HIGH("Price (low to high)"),
        PRICE_HIGH_LOW("Price (high to low)");

        public final String text;

        SortBy(String text) {
            this.text = text;
        }
    }
}

package org.example.framework.saucedemo.cart;

import com.microsoft.playwright.Locator;
import org.example.framework.saucedemo.entities.Price;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public record CartItemDescription(
        int quantity,
        String title,
        String description,
        Price price
) {
    public static CartItemDescription from(Locator root) {
        assertThat(root).hasClass("cart_item");

        return new CartItemDescription(
                Integer.parseInt(root.locator(".cart_quantity").innerText()),
                root.locator(".inventory_item_name").innerText(),
                root.locator(".inventory_item_desc").innerText(),
                Price.create(root.locator(".inventory_item_price").innerText())
        );
    }
}

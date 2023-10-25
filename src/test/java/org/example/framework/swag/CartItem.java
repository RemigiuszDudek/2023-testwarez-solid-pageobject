package org.example.framework.swag;

import com.microsoft.playwright.Locator;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static java.util.regex.Pattern.compile;

public record CartItem(
        String name,
        String description,
        Price price,
        int quantity
) {
    public static CartItem create(Locator root) {
        assertThat(root).hasClass(compile("cart_item"));

        return new CartItem(
                root.locator(".inventory_item_name").innerText(),
                root.locator(".inventory_item_desc").innerText(),
                Price.create(root.locator(".inventory_item_price").innerText()),
                Integer.parseInt(root.locator(".cart_quantity").innerText())
        );
    }

    public void removeFromCart() {

    }
}

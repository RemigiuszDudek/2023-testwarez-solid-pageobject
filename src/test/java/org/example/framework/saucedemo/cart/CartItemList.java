package org.example.framework.saucedemo.cart;

import com.microsoft.playwright.Locator;

import java.util.ArrayList;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CartItemList {
    private final List<CartItem> items;

    public CartItemList(Locator root) {
        assertThat(root).hasClass("cart_list");

        this.items = root.locator(".cart_item").all().stream()
                .map(CartItem::new)
                .toList();
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(items);
    }
}

package org.example.framework.swag;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.List;

public class CartPage {
    private final List<CartItem> items;
    private final Locator checkoutButton;

    public CartPage(Page page) {
        this.items = page.locator(".cart_item").all().stream().map(CartItem::create).toList();
        this.checkoutButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Checkout"));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public CheckoutPage checkout() {
        checkoutButton.click();

        return new CheckoutPage(checkoutButton.page());
    }
}

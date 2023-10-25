package org.example.framework.saucedemo.checkout;

import com.microsoft.playwright.Page;
import org.example.framework.saucedemo.cart.CartItemDescription;
import org.example.framework.saucedemo.cart.CartItemList;

import java.util.List;

public record CheckoutOverview(
        List<CartItemDescription> items,
        String paymentInformation,
        String shippingInformation,
        TotalPrice totalPrice
) {
    public static CheckoutOverview from(Page page) {
        return new CheckoutOverview(
                new CartItemList(page.locator(".cart_item")).getItems().stream().map(c -> c.description).toList(),
                page.getByText("Payment Information").locator("+ div").innerText(),
                page.getByText("Shipping Information").locator("+ div").innerText(),
                TotalPrice.from(page)
        );
    }
}

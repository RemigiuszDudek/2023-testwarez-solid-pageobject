package org.example.framework.saucedemo.checkout;

import com.microsoft.playwright.Page;

public record PaczkomatCheckoutDetails(
        String paczkomatId
) implements CheckoutDetails {

    @Override
    public void apply(Page page) {

    }
}

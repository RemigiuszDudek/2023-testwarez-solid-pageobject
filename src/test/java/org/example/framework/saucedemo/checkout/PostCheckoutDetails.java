package org.example.framework.saucedemo.checkout;

import com.microsoft.playwright.Page;

public record PostCheckoutDetails(
        PostInformation postInformation
) implements CheckoutDetails {
    @Override
    public void apply(Page page) {
        page.locator("#first-name").fill(postInformation.firstName());
        page.locator("#last-name").fill(postInformation.lastName());
        page.locator("#postal-code").fill(postInformation.zipCode());
    }
}

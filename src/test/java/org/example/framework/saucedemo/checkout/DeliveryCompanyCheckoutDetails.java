package org.example.framework.saucedemo.checkout;

import com.microsoft.playwright.Page;

public record DeliveryCompanyCheckoutDetails(
        PostInformation postInformation,
        boolean express
) implements CheckoutDetails {
    @Override
    public void apply(Page page) {

    }
}

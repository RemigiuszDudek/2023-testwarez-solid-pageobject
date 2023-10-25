package org.example.framework.swag;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutOverviewPage {
    private final Locator finishButton;

    public CheckoutOverviewPage(Page page) {
        this.finishButton = page.locator("");
    }
}


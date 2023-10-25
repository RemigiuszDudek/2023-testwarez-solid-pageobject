package org.example.framework.swag;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CheckoutPage {
    private final Locator firstNameInput;
    private final Locator lastNameInput;
    private final Locator zipCodeInput;
    private final Locator continueButton;

    public CheckoutPage(Page page) {
        this.firstNameInput = page.locator("#first-name");
        this.lastNameInput = page.locator("#last-name");
        this.zipCodeInput = page.locator("#postal-code");
        this.continueButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue"));
    }

    CheckoutPage fillCheckoutDetails(String firstName, String lastName, String zipCode) {
        this.firstNameInput.fill(firstName);
        this.lastNameInput.fill(lastName);
        this.zipCodeInput.fill(zipCode);

        return this;
    }

    public CheckoutOverviewPage clickContinue() {
        continueButton.click();

        return new CheckoutOverviewPage(firstNameInput.page());
    }
}

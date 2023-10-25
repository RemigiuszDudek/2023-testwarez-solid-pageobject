package org.example.framework.saucedemo.checkout;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.example.framework.PageObject;
import org.example.framework.saucedemo.cart.CartPage;

public class CheckoutPage extends PageObject {
    private final Locator firstNameInput;
    private final Locator lastNameInput;
    private final Locator zipCodeInput;
    private final Locator continueButton;
    private final Locator cancelButton;

    public CheckoutPage(Page page) {
        super(page);
        this.firstNameInput = page.locator("#first-content");
        this.lastNameInput = page.locator("#last-content");
        this.zipCodeInput = page.locator("#postal-code");
        this.continueButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue"));
        this.cancelButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cancel"));
    }

//    public CheckoutPage fillPostCheckoutDetails(PostInformation postInformation) {
//        this.firstNameInput.fill(postInformation.firstName());
//        this.lastNameInput.fill(postInformation.lastName());
//        this.zipCodeInput.fill(postInformation.zipCode());
//
//        return this;
//    }
//
//    public CheckoutPage fillPaczkomatCheckoutDetails(String paczkomatId) {
//        return this;
//    }
//
//    public CheckoutPage fillDeliveryCompanyCheckoutDetails(PostInformation postInformation, boolean isExpress) {
//        return this;
//    }

    public CheckoutPage fillCheckoutDetails(CheckoutDetails checkoutDetails) {
        checkoutDetails.apply(page);

        return this;
    }

    public CheckoutOverviewPage clickContinue() {
        continueButton.click();

        return new CheckoutOverviewPage(page);
    }

    public CartPage clickCancel() {
        cancelButton.click();

        return new CartPage(page);
    }
}

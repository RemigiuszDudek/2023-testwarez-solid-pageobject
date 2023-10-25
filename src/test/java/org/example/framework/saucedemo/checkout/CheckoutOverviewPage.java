package org.example.framework.saucedemo.checkout;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.example.framework.PageObject;
import org.example.framework.saucedemo.cart.CartItemDescription;

public class CheckoutOverviewPage extends PageObject {
    private final Locator finishButton;

    public CheckoutOverviewPage(Page page) {
        super(page);

        this.finishButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Finish"));
    }

    public CheckoutOverview getOverview() {
        return new CheckoutOverview(
                page.locator(".cart_item").all().stream().map(CartItemDescription::from).toList(),
                page.getByText("Payment Information").locator("+ div").innerText(),
                page.getByText("Shipping Information").locator("+ div").innerText(),
                TotalPrice.from(page)
        );
    }

    public CheckoutCompletePage clickFinish() {
        finishButton.click();

        return new CheckoutCompletePage(page);
    }
}

package org.example.framework.saucedemo.checkout;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.example.framework.PageObject;
import org.example.framework.saucedemo.inventory.InventoryPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckoutCompletePage extends PageObject {
    private final Locator backHomeButton;

    public CheckoutCompletePage(Page page) {
        super(page);

        this.backHomeButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Back Home"));
        assertThat(page.getByText("Thank you for your order!")).isVisible();
        assertThat(page.getByText("Your order has been dispatched, and will arrive just as fast as the pony can get there!")).isVisible();
    }

    public InventoryPage clickBackHome() {
        backHomeButton.click();

        return new InventoryPage(page);
    }
}

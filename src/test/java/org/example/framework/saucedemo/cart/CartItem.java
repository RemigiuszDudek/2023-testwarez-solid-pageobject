package org.example.framework.saucedemo.cart;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.GetByRoleOptions;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CartItem {
    public final CartItemDescription description;
    private final Locator removeButton;
    private final Locator titleLink;

    public CartItem(Locator root) {
        assertThat(root).hasClass("cart_item");

        this.description = CartItemDescription.from(root);
        this.removeButton = root.getByRole(AriaRole.BUTTON, new GetByRoleOptions().setName("Remove"));
        this.titleLink = root.locator("a");
    }

    public void clickRemove() {
        this.removeButton.click();
    }

    public void clickOnTitle() {
        this.titleLink.click();
    }

}



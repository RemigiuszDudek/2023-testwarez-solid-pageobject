package org.example.framework.saucedemo.inventory;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import org.example.framework.saucedemo.entities.Price;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.platform.commons.util.Preconditions.condition;

public class InventoryItem {
    private final Locator title;
    public final InventoryItemDescription description;
    private final Locator addToCartButton;
    private final Locator removeButton;

    public InventoryItem(Locator root) {
        assertThat(root).hasClass("inventory_item");

        this.title = root.locator(".inventory_item_name");
        this.description = new InventoryItemDescription(
                root.locator(".inventory_item_name").innerText(),
                root.locator(".inventory_item_desc").innerText(),
                Price.create(root.locator(".inventory_item_price").innerText())
        );
        this.addToCartButton = root.getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Add to cart"));
        this.removeButton = root.getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Remove"));
    }

    public void clickOnTitle() {
        title.click();
    }

    public void addToCart() {
        if (removeButton.isVisible()) {
            return;
        }
        assertThat(addToCartButton).isVisible();
        addToCartButton.click();
    }

    public record InventoryItemDescription(
            String title,
            String description,
            Price price
    ) {
    }
}

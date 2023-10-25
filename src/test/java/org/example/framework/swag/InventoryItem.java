package org.example.framework.swag;

import com.microsoft.playwright.Locator;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static java.util.regex.Pattern.compile;

public record InventoryItem(
        String name,
        String description,
        Price price,
        Locator addOrRemoveButton
) {
    private final static String ADD_TO_CART_BUTTON_LABEL = "Add to cart";
    private final static String REMOVE_BUTTON_LABEL = "Remove";

    public static InventoryItem create(Locator root) {
        assertThat(root).hasClass(compile("inventory_item"));

        return new InventoryItem(
                root.locator(".inventory_item_name ").innerText(),
                root.locator(".inventory_item_desc").innerText(),
                Price.create(root.locator(".inventory_item_price").innerText()),
                root.locator(".pricebar").locator("button")
        );
    }

    public void addToCart() {
        String buttonInnerText = addOrRemoveButton.innerText();

        if (buttonInnerText.equals(ADD_TO_CART_BUTTON_LABEL)) {
            addOrRemoveButton.click();
        }
    }

    public void removeFromCart() {
        String buttonInnerText = addOrRemoveButton.innerText();

        if (buttonInnerText.equals(REMOVE_BUTTON_LABEL)) {
            addOrRemoveButton.click();
        }
    }
}

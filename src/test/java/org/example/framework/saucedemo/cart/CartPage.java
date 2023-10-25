package org.example.framework.saucedemo.cart;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GetByRoleOptions;
import org.example.framework.PageObject;
import org.example.framework.saucedemo.checkout.CheckoutPage;
import org.example.framework.saucedemo.inventory.InventoryPage;

import java.util.List;

import static com.microsoft.playwright.options.AriaRole.BUTTON;

public class CartPage extends PageObject {
    private final CartItemList itemList;
    private final Locator checkoutButton;
    private final Locator continueShoppingButton;

    public CartPage(Page page) {
        super(page);
        this.checkoutButton = page.getByRole(BUTTON, new GetByRoleOptions().setName("Checkout"));
        this.continueShoppingButton = page.getByRole(BUTTON, new GetByRoleOptions().setName("Continue Shopping"));
        this.itemList = new CartItemList(page.locator(".cart_list"));
    }

    public List<CartItemDescription> getCartItemsDescriptions() {
        return itemList.getItems().stream().map(it -> it.description).toList();
    }

    public List<CartItem> getCartItems() {
        return itemList.getItems();
    }

    public CartPage removeItem(String itemTitle) {
        itemList.getItems().stream()
                .filter(it -> it.description.title().equals(itemTitle))
                .findFirst().orElseThrow(() -> new RuntimeException("missing item"))
                .clickRemove();

        return this;
    }

    public CheckoutPage clickCheckout() {
        checkoutButton.click();

        return new CheckoutPage(page);
    }

    public InventoryPage clickContinueShopping() {
        continueShoppingButton.click();

        return new InventoryPage(page);
    }
}

package org.example.tests;

import org.example.framework.PlaywrightTest;
import org.example.framework.TestUser;
import org.example.framework.swag.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SwagLabsTest extends PlaywrightTest {
    private static final TestUser USER = TestUser.standardUser();

    @Test
    public void openSwagPage() {
        InventoryPage inventoryPage = LoginPage.open(this.page).login(USER);

        assertThat(inventoryPage).isNotNull();
    }

    @Test
    public void loginWithInvalidCreds() {
        InvalidLoginPage invalidLoginPage = LoginPage.open(this.page).loginWithInvalidCredentials();

        assertThat(invalidLoginPage).isNotNull();
    }

    @Test
    public void vanillaCaseScenario() {
        String item1Name = "Sauce Labs Backpack";
        String item2Name = "Sauce Labs Bike Light";

        InventoryPage inventoryPage = LoginPage.open(this.page)
                .login(USER);

        CartPage cartPage = inventoryPage
                .addItemToCart(item1Name)
                .addItemToCart(item2Name)
                .goToCart();

        assertThat(cartPage.getItems().stream().map(CartItem::name).toList()).isEqualTo(List.of(
                item1Name, item2Name
        ));
    }
}

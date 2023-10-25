package org.example.tests;

import org.example.framework.PlaywrightTest;
import org.example.framework.TestUser;
import org.example.framework.swag.InvalidLoginPage;
import org.example.framework.swag.InventoryPage;
import org.example.framework.swag.LoginPage;
import org.junit.jupiter.api.Test;

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
}

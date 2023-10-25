package org.example.framework.saucedemo;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.framework.PageObject;
import org.example.framework.saucedemo.entities.TestUser;
import org.example.framework.saucedemo.inventory.InventoryPage;

public class LoginPage extends PageObject {
    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator loginButton;

    public LoginPage(Page page) {
        super(page);
        page.navigate("https://www.saucedemo.com/");
        this.usernameInput = page.locator("#user-name");
        this.passwordInput = page.locator("#password");
        this.loginButton = page.locator("#login-button");
    }

    public InventoryPage login(TestUser user) {
        this.usernameInput.fill(user.username());
        this.passwordInput.fill(user.password());
        this.loginButton.click();

        return new InventoryPage(page);
    }

    public LoginPage loginWithInvalidCredentials() {
        return this;
    }
}

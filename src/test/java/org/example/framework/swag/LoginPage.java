package org.example.framework.swag;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.framework.TestUser;

public class LoginPage {
    private final Locator username;
    private final Locator password;
    private final Locator loginButton;

    public LoginPage(Page page) {
        page.navigate("https://www.saucedemo.com/");

        this.username = page.locator("#user-name");
        this.password = page.locator("#password");
        this.loginButton = page.locator("#login-button");
    }

    public InventoryPage login(TestUser user) {
        this.username.fill(user.username());
        this.password.fill(user.password());
        this.loginButton.click();

        return new InventoryPage(username.page());
    }
}

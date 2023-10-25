package org.example.framework.swag;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.framework.TestUser;

public class LoginPage {
    private final Locator username;
    private final Locator password;
    private final Locator loginButton;

    protected LoginPage(Page page) {
        this.username = page.locator("#user-name");
        this.password = page.locator("#password");
        this.loginButton = page.locator("#login-button");
    }

    public static LoginPage open(Page page) {
        page.navigate("https://www.saucedemo.com/");

        return new LoginPage(page);
    }

    public InventoryPage login(TestUser user) {
        this.username.fill(user.username());
        this.password.fill(user.password());
        this.loginButton.click();

        return new InventoryPage(username.page());
    }

    public InvalidLoginPage loginWithInvalidCredentials() {
        this.username.fill("invalid");
        this.password.fill("invalid");
        this.loginButton.click();

        return new InvalidLoginPage(username.page());
    }
}

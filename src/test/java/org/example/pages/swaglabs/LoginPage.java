package org.example.pages.swaglabs;

import org.example.models.User;
import org.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    WebElement loginInput;
    WebElement passwordInput;
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);

        loginInput = driver.findElement(By.id("user-name"));
        passwordInput = driver.findElement(By.id("password"));
        loginButton = driver.findElement(By.id("login-button"));
    }

    public InventoryPage LogIn(User user) {
        loginInput.sendKeys(user.login);
        passwordInput.sendKeys(user.password);
        loginButton.click();

        return new InventoryPage(driver);
    }

    @Override  public boolean OnThePage() {
        return true;
    }
}

package org.example.pages.sauceDemo;

import org.example.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(how = How.ID, using = "user-name")
    WebElement loginInput;
    @FindBy(how = How.ID, using = "password")
    WebElement passwordInput;
    @FindBy(how = How.ID, using = "login-button")
    WebElement submitButton;

    public LoginPage whenReady() {
        wait.until(ExpectedConditions.visibilityOfAllElements(loginInput, passwordInput, submitButton));
        return this;
    }

    public void login(String name, String password) {
        loginInput.sendKeys(name);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

}

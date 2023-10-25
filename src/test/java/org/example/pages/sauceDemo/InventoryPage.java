package org.example.pages.sauceDemo;

import org.example.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InventoryPage extends BasePage {

    @FindBy(how = How.ID, using = "react-burger-menu-btn")
    WebElement menu;

    public InventoryPage whenReady() {
        wait.until(ExpectedConditions.visibilityOfAllElements(menu));
        return this;
    }

}

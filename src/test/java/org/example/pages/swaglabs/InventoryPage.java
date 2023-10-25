package org.example.pages.swaglabs;

import org.example.models.User;
import org.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage extends BasePage {
    WebElement inventoryContainer;
    public InventoryPage(WebDriver driver) {
        super(driver);

        inventoryContainer = driver.findElement(By.id("inventory_container"));

    }

    @Override  public boolean OnThePage() {

        return inventoryContainer.isDisplayed();
    }
}

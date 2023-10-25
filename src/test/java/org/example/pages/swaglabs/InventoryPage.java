package org.example.pages.swaglabs;

import org.example.models.User;
import org.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage extends BasePage {
    By inventoryContainer = By.id("inventory_container");
    public InventoryPage(WebDriver driver) {
        super(driver);

    }

    @Override  public boolean OnThePage() {
        return elementVisible(inventoryContainer);
    }
}

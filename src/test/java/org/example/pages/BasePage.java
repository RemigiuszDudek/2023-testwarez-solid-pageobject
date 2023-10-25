package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;


public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public abstract boolean OnThePage();

    protected boolean elementVisible(By locator){
        try{
            driver.findElement(locator);
            return true;
        }
        catch (NoSuchElementException ex){
            return false;
        }
    }
}

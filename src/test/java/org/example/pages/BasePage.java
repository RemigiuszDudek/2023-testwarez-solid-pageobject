package org.example.pages;

import java.time.Duration;

import org.example.framework.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    private boolean isInitialized = false;

    public BasePage() {
        if (!this.isInitialized) {
            driver = TestBase.webDriver;
            PageFactory.initElements(driver, this);
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            this.isInitialized = true;
        }
    }

}

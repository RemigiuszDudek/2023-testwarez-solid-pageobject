package org.example.framework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.time.Duration.of;
import static java.time.temporal.ChronoUnit.SECONDS;

public class TestBase {
    protected WebDriver webDriver;

    @BeforeEach
    public void setupContext() {
        this.webDriver = webDriverFactory(false);
        webDriver.get("https://www.saucedemo.com/");
    }

    private static WebDriver webDriverFactory(boolean isHeadless) {
        ChromeOptions opts = new ChromeOptions();
        if (isHeadless) opts.addArguments("--headless=new");
        WebDriver webDriver = new ChromeDriver(opts);
        WebDriver.Options manage = webDriver.manage();
        manage.timeouts().implicitlyWait(of(10, SECONDS));

        return webDriver;
    }

    @AfterEach
    public void teardownContext() {
        this.webDriver.quit();
    }
}

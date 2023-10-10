package org.example.framework;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    static {
        Configuration.browser = "chrome";
        Configuration.downloadsFolder = "target/e2e/download";
        Configuration.timeout = 1000;
        Configuration.headless = true;
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "normal";
    }

    @BeforeEach
    public void setupContext() {
        open("https://www.saucedemo.com/");
    }

    @AfterEach
    public void teardownContext() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            WebDriverRunner.closeWebDriver();
        }
    }
}

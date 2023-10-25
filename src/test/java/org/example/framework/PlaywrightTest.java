package org.example.framework;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.nio.file.Path;

public class PlaywrightTest {
    private static Browser BROWSER;
    protected BrowserContext context;
    protected Page page;

    @BeforeAll
    public static void setupPlaywright() {
        PlaywrightTest.BROWSER = Playwright.create().chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
    }

    @BeforeEach
    public void setupContext() {
        this.context = PlaywrightTest.BROWSER.newContext(new Browser.NewContextOptions()
                .setRecordVideoDir(Path.of("target", "playwright", "video"))
        );
        this.context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true)
        );
        page = this.context.newPage();
//        page.navigate("https://www.saucedemo.com/");
    }

    @AfterEach
    public void teardownContext() {
        this.context.tracing().stop(new Tracing.StopOptions().setPath(Path.of("target", "playwright", "trace.zip")));
        this.context.close();
    }

    @AfterAll
    public static void tearDownPlaywright() {
        PlaywrightTest.BROWSER.close();
    }
}

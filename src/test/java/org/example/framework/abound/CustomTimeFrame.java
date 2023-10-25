package org.example.framework.abound;

import com.microsoft.playwright.Page;

public record CustomTimeFrame(TimeRange range) implements Timeframe {


    @Override
    public void apply(Page page) {
        page.locator("custom-button").click();

        page.locator("date-rage").click();
    }
}

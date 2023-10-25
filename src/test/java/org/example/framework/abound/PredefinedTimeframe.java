package org.example.framework.abound;

import com.microsoft.playwright.Page;

public enum PredefinedTimeframe implements Timeframe {
    LAST_24H, LAST_WEEK, LAST_MONTH;

    @Override
    public void apply(Page page) {
        page.locator("dropdown").selectOption(this.name());
    }
}

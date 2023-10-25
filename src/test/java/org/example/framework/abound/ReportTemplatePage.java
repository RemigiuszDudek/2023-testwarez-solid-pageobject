package org.example.framework.abound;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ReportTemplatePage {
    Page page;
    Locator customButton;
    Locator dateRange;

    ReportTemplatePage selectTimeFrame(Timeframe timeFrame) {
        timeFrame.apply(page);

        return this;
    }
}

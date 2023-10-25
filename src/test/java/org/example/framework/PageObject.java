package org.example.framework;

import com.microsoft.playwright.Page;

public class PageObject {
    protected final Page page;

    public PageObject(Page page) {
        this.page = page;
    }
}

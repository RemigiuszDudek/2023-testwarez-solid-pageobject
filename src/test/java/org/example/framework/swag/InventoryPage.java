package org.example.framework.swag;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class InventoryPage {
    public InventoryPage(Page page) {
        assertThat(page.getByText("Products")).isVisible();
    }
}

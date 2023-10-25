package org.example.framework.muitable.table.grid;

import com.microsoft.playwright.Locator;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static java.util.regex.Pattern.compile;

public record GridColumnHeader(String content) {
    public static GridColumnHeader create(Locator root) {
        assertThat(root).hasClass(compile("MuiDataGrid-columnHeader"));

        return new GridColumnHeader(root.textContent());
    }
}

package org.example.framework.muitable.table;

import com.microsoft.playwright.Locator;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static java.util.regex.Pattern.compile;

public class TextTableCell implements TableCell<String> {
    private final Locator root;

    public TextTableCell(Locator root) {
        assertThat(root).hasClass(compile("MuiTableCell-root|MuiDataGrid-cell"));
        this.root = root;
    }

    @Override
    public String content() {
        return root.textContent();
    }
}

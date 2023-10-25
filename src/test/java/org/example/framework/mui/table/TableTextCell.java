package org.example.framework.mui.table;

import com.microsoft.playwright.Locator;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static java.util.regex.Pattern.compile;

public class TableTextCell implements TableCell<String> {
    private final Locator cellLocator;

    public TableTextCell(Locator cellLocator) {
        assertThat(cellLocator).hasClass(compile("MuiTableCell-root"));

        this.cellLocator = cellLocator;
    }

    @Override
    public String getContent() {
        return cellLocator.innerText();
    }
}

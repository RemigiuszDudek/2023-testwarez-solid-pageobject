package org.example.framework.mui.table;

import com.microsoft.playwright.Locator;
import org.example.framework.mui.businessmodel.Desert;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static java.util.regex.Pattern.compile;

public abstract class TableRow<CONTENT> implements Row<CONTENT> {
    protected final List<? extends TableCell<String>> cells;

    public TableRow(Locator rowRoot) {
        assertThat(rowRoot).hasClass(compile("MuiTableRow-root"));

        this.cells = rowRoot.locator(".MuiTableCell-root").all().stream().map(TableTextCell::new).toList();
    }

    @Override
    public abstract CONTENT getContent();
}

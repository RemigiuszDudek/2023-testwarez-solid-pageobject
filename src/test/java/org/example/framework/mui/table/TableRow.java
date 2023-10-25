package org.example.framework.mui.table;

import com.microsoft.playwright.Locator;
import org.example.framework.mui.businessmodel.Desert;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static java.util.regex.Pattern.compile;

public record TableRow(
        List<? extends TableCell<String>> cells
) {
    public TableRow(Locator rowRoot) {
        this(rowRoot.locator(".MuiTableCell-root").all().stream().map(TableTextCell::new).toList());
        assertThat(rowRoot).hasClass(compile("MuiTableRow-root"));
    }
}

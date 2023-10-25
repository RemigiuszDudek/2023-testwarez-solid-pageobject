package org.example.framework.muitable.table.basic;

import com.microsoft.playwright.Locator;
import org.example.framework.muitable.Desert;
import org.example.framework.muitable.table.Table;
import org.example.framework.muitable.table.TextTableCell;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public record BasicTable(
        List<String> headers,
        List<Desert> content
) implements Table<Desert> {
    public static BasicTable create(Locator tableCreationStartingPoint) {
        assertThat(tableCreationStartingPoint).hasId("BasicTable");

        Locator tableRoot = tableCreationStartingPoint
                .locator("xpath=..")
                .locator("table.MuiTable-root");
        Locator thead = tableRoot.locator("thead");
        Locator tbody = tableRoot.locator("tbody");

        return new BasicTable(
                thead.locator("th.MuiTableCell-root").all().stream()
                        .map(TextTableCell::new)
                        .map(TextTableCell::content)
                        .toList(),
                tbody.locator("tr.MuiTableRow-root").all().stream()
                        .map((BasicTableRow::create))
                        .map(BasicTableRow::content)
                        .toList()
        );
    }


}

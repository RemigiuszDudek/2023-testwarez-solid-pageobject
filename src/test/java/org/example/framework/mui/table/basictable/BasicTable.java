package org.example.framework.mui.table.basictable;

import com.microsoft.playwright.Locator;
import org.example.framework.mui.businessmodel.Desert;
import org.example.framework.mui.table.Table;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BasicTable implements Table<Desert> {
    private final List<String> headers;
    private final List<BasicTableRow> rows;

    public BasicTable(Locator tableStartingPoint) {
        assertThat(tableStartingPoint).hasId("BasicTable");

        Locator tableRoot = tableStartingPoint.locator("xpath=..");
        Locator thead = tableRoot.locator("thead");
        Locator tbody = tableRoot.locator("tbody");

        this.headers = thead.locator("th").all().stream().map(Locator::innerText).toList();
        this.rows = tbody.locator("tr").all().stream().map(BasicTableRow::new).toList();
    }

    @Override
    public List<String> getHeaders() {
        return headers;
    }

    @Override
    public List<Desert> getContent() {
        return rows.stream().map(BasicTableRow::getContent).toList();
    }
}

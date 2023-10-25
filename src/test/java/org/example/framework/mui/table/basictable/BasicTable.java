package org.example.framework.mui.table.basictable;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.framework.mui.businessmodel.Desert;
import org.example.framework.mui.table.Table;

import java.util.List;

public class BasicTable implements Table<Desert> {
    private final List<String> headers;
    private final List<BasicTableRow> rows;

    public BasicTable(Page page) {
        Locator tableRoot = page.locator("#BasicTable").locator("xpath=..");
        Locator thead = tableRoot.locator("thead");
        Locator tbody = tableRoot.locator("tbody");

        this.headers = thead.locator("th").all().stream().map(Locator::innerText).toList();
        this.rows = tbody.locator("tr").all().stream().map(BasicTableRow::new).toList();
    }

    @Override
    public List<Desert> getContent() {
        return rows.stream().map(BasicTableRow::getContent).toList();
    }
}

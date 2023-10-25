package org.example.framework.muitable;

import com.microsoft.playwright.Page;
import org.example.framework.muitable.table.basic.BasicTable;
import org.example.framework.muitable.table.enhanced.EnhancedTable;
import org.example.framework.muitable.table.grid.DataTable;

public record MuiTableDocPage(
        BasicTable table,
        DataTable dataTable,
        EnhancedTable enhancedTable
) {
    public static MuiTableDocPage create(Page page) {
        page.navigate("https://mui.com/material-ui/react-table/");

        return new MuiTableDocPage(
                BasicTable.create(page.locator("#BasicTable")),
                new DataTable(page.locator("#DataTable")),
                new EnhancedTable(page.locator("#EnhancedTable"))
        );
    }
}

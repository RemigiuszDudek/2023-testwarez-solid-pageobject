package org.example.framework.mui;

import com.microsoft.playwright.Page;
import org.example.framework.mui.table.basictable.BasicTable;
import org.example.framework.mui.businessmodel.Desert;

import java.util.List;

public class MuiDocPage {
    private final BasicTable basicTable;

    public MuiDocPage(Page page) {
        page.navigate("https://mui.com/material-ui/react-table/");

        this.basicTable = new BasicTable(page);
    }

    public List<Desert> getBasicTableContent() {
        return basicTable.getContent();
    }
}

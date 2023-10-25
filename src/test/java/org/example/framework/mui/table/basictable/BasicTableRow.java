package org.example.framework.mui.table.basictable;

import com.microsoft.playwright.Locator;
import org.example.framework.mui.businessmodel.Desert;
import org.example.framework.mui.table.TableRow;

public class BasicTableRow extends TableRow<Desert> {
    public BasicTableRow(Locator rowRoot) {
        super(rowRoot);
    }

    @Override
    public Desert getContent() {
        return new Desert(
                cells.get(0).getContent(),
                Float.parseFloat(cells.get(1).getContent()),
                Float.parseFloat(cells.get(2).getContent()),
                Float.parseFloat(cells.get(3).getContent()),
                Float.parseFloat(cells.get(4).getContent())
        );
    }
}

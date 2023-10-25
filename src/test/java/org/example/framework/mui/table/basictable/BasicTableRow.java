package org.example.framework.mui.table.basictable;

import com.microsoft.playwright.Locator;
import org.assertj.core.internal.DeepDifference;
import org.example.framework.mui.businessmodel.Desert;
import org.example.framework.mui.table.Row;
import org.example.framework.mui.table.TableCell;
import org.example.framework.mui.table.TableRow;

import java.util.List;

public class BasicTableRow implements Row<Desert> {
    private final TableRow row;

    public BasicTableRow(Locator rowRoot) {
        this.row = new TableRow(rowRoot);
    }

    @Override
    public Desert getContent() {
        List<? extends TableCell<String>> cells = row.cells();
        return new Desert(
                cells.get(0).getContent(),
                Float.parseFloat(cells.get(1).getContent()),
                Float.parseFloat(cells.get(2).getContent()),
                Float.parseFloat(cells.get(3).getContent()),
                Float.parseFloat(cells.get(4).getContent())
        );
    }
}

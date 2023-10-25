package org.example.framework.mui.table.basictable;

import com.microsoft.playwright.Locator;
import org.example.framework.mui.businessmodel.Desert;
import org.example.framework.mui.table.Row;
import org.example.framework.mui.table.TableCell;
import org.example.framework.mui.table.TableTextCell;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static java.util.regex.Pattern.compile;

public class BasicTableRow implements Row<Desert> {
    private final List<? extends TableCell<String>> cells;

    public BasicTableRow(Locator rowRoot) {
        assertThat(rowRoot).hasClass(compile("MuiTableRow-root"));

        this.cells = rowRoot.locator(".MuiTableCell-root").all().stream().map(TableTextCell::new).toList();
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

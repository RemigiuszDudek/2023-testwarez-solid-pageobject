package org.example.framework.muitable.table.enhanced;

import com.microsoft.playwright.Locator;
import org.example.framework.muitable.Desert;
import org.example.framework.muitable.table.SelectableRow;
import org.example.framework.muitable.table.SelectableTableCell;
import org.example.framework.muitable.table.TextTableCell;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static java.util.regex.Pattern.compile;

public class EnhancedTableRow implements SelectableRow<Desert> {
    private final SelectableTableCell selectableCell;
    private final List<TextTableCell> dataCells;

    public EnhancedTableRow(Locator root) {
        assertThat(root).hasClass(compile("MuiTableRow-root"));

        List<Locator> cellsLocators = root.locator(".MuiTableCell-root").all();

        this.selectableCell = new SelectableTableCell(cellsLocators.get(0));
        this.dataCells = cellsLocators.subList(1, cellsLocators.size()).stream()
                .map(TextTableCell::new)
                .toList();
    }

    @Override
    public Desert content() {
        return new Desert(
                dataCells.get(0).content(),
                Integer.parseInt(dataCells.get(1).content()),
                Float.parseFloat(dataCells.get(2).content()),
                Float.parseFloat(dataCells.get(3).content()),
                Float.parseFloat(dataCells.get(4).content())
        );
    }

    @Override
    public void select() {
        this.selectableCell.select();
    }

    @Override
    public void deselect() {
        this.selectableCell.deselect();
    }

    @Override
    public boolean isSelected() {
        return this.selectableCell.isSelected();
    }
}

package org.example.framework.muitable.table.grid;

import com.microsoft.playwright.Locator;
import org.example.framework.muitable.Person;
import org.example.framework.muitable.table.SelectableRow;
import org.example.framework.muitable.table.SelectableTableCell;
import org.example.framework.muitable.table.TextTableCell;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static java.util.regex.Pattern.compile;

public class DataTableRow implements SelectableRow<Person> {
    private final SelectableTableCell selectableCell;
    private final List<TextTableCell> dataCells;

    public DataTableRow(Locator root) {
        assertThat(root).hasClass(compile("MuiDataGrid-row"));

        List<Locator> cells = root.locator("div.MuiDataGrid-cell").all();

        this.selectableCell = new SelectableTableCell(cells.get(0));
        this.dataCells = cells.subList(1, cells.size()).stream().map(TextTableCell::new).toList();
    }

    @Override
    public void select() {
        selectableCell.select();
    }

    @Override
    public void deselect() {
        selectableCell.deselect();
    }

    @Override
    public boolean isSelected() {
        return selectableCell.isSelected();
    }

    @Override
    public Person content() {
        String ageCellContent = dataCells.get(3).content().trim();
        return new Person(
                Integer.parseInt(dataCells.get(0).content()),
                dataCells.get(1).content(),
                dataCells.get(2).content(),
                ageCellContent.isEmpty() ? null : Integer.parseInt(ageCellContent),
                dataCells.get(4).content()
        );
    }
}

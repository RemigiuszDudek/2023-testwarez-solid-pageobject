package org.example.framework.muitable.table.grid;

import com.microsoft.playwright.Locator;
import org.example.framework.muitable.Person;
import org.example.framework.muitable.table.SelectableTable;
import org.example.framework.muitable.table.Table;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DataTable implements Table<Person>, SelectableTable<Person> {
    private final Locator selectAllHeader;
    private final List<? extends GridColumnHeader> headers;
    private final List<DataTableRow> rows;

    public DataTable(Locator tableCreationStartingPoint) {
        assertThat(tableCreationStartingPoint).hasId("DataTable");
        Locator tableRoot = tableCreationStartingPoint
                .locator("xpath=..")
                .locator("div.MuiDataGrid-main");

        List<Locator> headers = tableRoot.locator("div.MuiDataGrid-columnHeader").all();

        this.selectAllHeader = headers.get(0).locator("input");
        this.headers = headers.subList(1, headers.size()).stream().map(GridColumnHeader::create).toList();
        this.rows = tableRoot.locator("div.MuiDataGrid-row").all().stream().map(DataTableRow::new).toList();
    }

    @Override
    public List<Person> content() {
        return rows.stream()
                .map(DataTableRow::content)
                .toList();
    }

    @Override
    public List<String> headers() {
        return headers.stream().map(GridColumnHeader::content).toList();
    }

    public DataTable deselectAll() {
        if (selectAllHeader.isChecked()) selectAllHeader.click();

        return this;
    }

    public DataTable selectAll() {
        if (!selectAllHeader.isChecked()) selectAllHeader.click();

        return this;
    }

    @Override
    public boolean isAllSelected() {
        return selectAllHeader.isChecked();
    }

    public DataTable select(int rowIdx) {
        rows.get(rowIdx).select();

        return this;
    }

    @Override
    public SelectableTable<Person> deselect(int rowIdx) {
        rows.get(rowIdx).deselect();

        return this;
    }

    public List<Person> selectedContent() {
        return rows.stream()
                .filter(DataTableRow::isSelected)
                .map(DataTableRow::content)
                .toList();
    }
}

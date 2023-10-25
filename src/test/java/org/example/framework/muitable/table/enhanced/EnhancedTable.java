package org.example.framework.muitable.table.enhanced;

import com.microsoft.playwright.Locator;
import org.assertj.core.api.Assertions;
import org.example.framework.muitable.Desert;
import org.example.framework.muitable.table.*;

import java.util.Arrays;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class EnhancedTable implements SortableTable<EnhancedTable.Header, Desert>, SelectableTable<Desert> {
    public enum Header {
        DESERT_NAME_HEADING("Dessert (100g serving)"),
        CALORIES_HEADING("Calories"),
        FAT_HEADING("Fat (g)"),
        CARBS_HEADING("Carbs (g)"),
        PROTEIN_HEADING("Protein (g)");

        final String text;

        Header(String text) {
            this.text = text;
        }

        public static Header createFromText(String text) {
            return Arrays.stream(Header.values())
                    .filter(h -> h.text.equals(text))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("unknown header, text=%s".formatted(text)));
        }
    }


    private final Locator startingPoint;
    private final SelectableTableCell selectAllHeader;
    private final List<? extends SortableHeader> headers;
    private final List<? extends SelectableRow<Desert>> rows;

    public EnhancedTable(Locator tableCreationStartingPoint) {
        assertThat(tableCreationStartingPoint).hasId("EnhancedTable");

        Locator tableRoot = tableCreationStartingPoint
                .locator("xpath=..")
                .locator("table.MuiTable-root");
        Locator thead = tableRoot.locator("thead");
        Locator tbody = tableRoot.locator("tbody");

        List<Locator> headers = thead.locator("th.MuiTableCell-root").all();
        this.startingPoint = tableCreationStartingPoint;
        this.selectAllHeader = new SelectableTableCell(headers.get(0));
        this.headers = headers.subList(1, headers.size()).stream().map(BaseSortableHeader::new).toList();
        this.rows = tbody.locator("tr.MuiTableRow-root").all().stream().map(EnhancedTableRow::new).toList();
    }

    @Override
    public List<Desert> content() {
        return rows.stream().map(Row::content).toList();
    }

    @Override
    public List<String> headers() {
        return headers.stream().map(TableCell::content).toList();
    }

    @Override
    public SelectableTable<Desert> selectAll() {
        selectAllHeader.select();

        return this;
    }

    @Override
    public boolean isAllSelected() {
        return selectAllHeader.isSelected();
    }

    @Override
    public SelectableTable<Desert> select(int rowIdx) {
        rows.get(rowIdx).select();

        return this;
    }

    @Override
    public SelectableTable<Desert> deselect(int rowIdx) {
        rows.get(rowIdx).deselect();

        return this;
    }

    @Override
    public List<Desert> selectedContent() {
        return rows.stream().filter(SelectableRow::isSelected).map(Row::content).toList();
    }

    @Override
    public SortableTable<Header, Desert> sortBy(Header headerName, SortDirection direction) {
        Assertions.assertThat(direction).isNotEqualTo(SortDirection.NONE);

        List<? extends SortableHeader> headersWithExpectedName = headers.stream()
                .filter(h -> h.content().equals(headerName.text))
                .toList();
        Assertions.assertThat(headersWithExpectedName.size())
                .withFailMessage("expected only one header, name=%s, size=%d", headerName, headersWithExpectedName.size())
                .isEqualTo(1);

        headersWithExpectedName.get(0).sort(direction);

        return this;
    }
}

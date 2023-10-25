package org.example.framework.muitable.table;

import com.microsoft.playwright.Locator;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static java.util.regex.Pattern.compile;

public class SelectableTableCell implements TableCell<Boolean> {
    private final Locator checkbox;

    public SelectableTableCell(Locator root) {
        assertThat(root).hasClass(compile("MuiDataGrid-cellCheckbox|MuiTableCell-root"));

        this.checkbox = root.locator("input");
    }

    public void select() {
        if (!checkbox.isChecked()) checkbox.click();
    }

    public boolean isSelected() {
        return checkbox.isChecked();
    }

    public Boolean content() {
        return isSelected();
    }

    public void deselect() {
        if (checkbox.isChecked()) checkbox.click();
    }
}

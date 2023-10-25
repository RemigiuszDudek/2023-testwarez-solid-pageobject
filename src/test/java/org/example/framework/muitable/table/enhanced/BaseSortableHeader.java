package org.example.framework.muitable.table.enhanced;

import com.microsoft.playwright.Locator;
import org.example.framework.muitable.table.SortDirection;
import org.example.framework.muitable.table.SortableHeader;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static java.util.regex.Pattern.compile;

public class BaseSortableHeader implements SortableHeader {
    private final Locator root;
    private final Locator labelLocator;
    private final Locator sortDirection;

    public BaseSortableHeader(Locator root) {
        Locator labelLocator = root.locator("span.MuiTableSortLabel-root");
        assertThat(root).hasClass(compile("MuiTableCell-root"));
        assertThat(labelLocator).isVisible();
        Locator sortDirection = root.locator("span.MuiBox-root");

        this.root = root;
        this.labelLocator = labelLocator;
        this.sortDirection = sortDirection;
    }

    @Override
    public void sort(SortDirection direction) {
        SortDirection currentSort = SortDirection.from(root.getAttribute("aria-sort"));
        while (currentSort != direction) {
            root.click();
            currentSort = SortDirection.from(root.getAttribute("aria-sort"));
        }
    }

    @Override
    public String content() {
        String sanitizedContent = labelLocator.innerText().replaceAll(" ", " ");
        return sortDirection.isVisible()
                ? sanitizedContent.replace("\n%s".formatted(sortDirection.innerText()), "")
                : sanitizedContent;
    }
}

package org.example.framework.muitable.table.basic;

import com.microsoft.playwright.Locator;
import org.assertj.core.api.Assertions;
import org.example.framework.muitable.Desert;
import org.example.framework.muitable.table.Row;
import org.example.framework.muitable.table.TextTableCell;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static java.util.regex.Pattern.compile;

public record BasicTableRow(
        Desert content
) implements Row<Desert> {
    public static BasicTableRow create(Locator root) {
        assertThat(root).hasClass(compile("MuiTableRow-root"));

        List<TextTableCell> cells = root
                .locator(".MuiTableCell-root").all().stream()
                .map(TextTableCell::new)
                .toList();

        Assertions.assertThat(cells.size()).isEqualTo(5);

        return new BasicTableRow(
                new Desert(
                        cells.get(0).content(),
                        Integer.parseInt(cells.get(1).content()),
                        Float.parseFloat(cells.get(2).content()),
                        Float.parseFloat(cells.get(3).content()),
                        Float.parseFloat(cells.get(4).content())
                )
        );
    }
}

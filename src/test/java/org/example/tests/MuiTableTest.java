package org.example.tests;

import org.example.framework.PlaywrightTest;
import org.example.framework.mui.businessmodel.Desert;
import org.example.framework.mui.MuiDocPage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MuiTableTest extends PlaywrightTest {
    @Test
    public void basicTableShouldContainProperDeserts() {
        List<Desert> expectedDeserts = List.of(
                new Desert("Frozen yoghurt", 159, 6, 24, 4),
                new Desert("Ice cream sandwich", 237, 9, 37, 4.3f),
                new Desert("Eclair", 262, 16, 24, 6),
                new Desert("Cupcake", 305, 3.7f, 67, 4.3f),
                new Desert("Gingerbread", 356, 16, 49, 3.9f)
        );

        MuiDocPage muiDocPage = new MuiDocPage(this.page);

        assertThat(muiDocPage.getBasicTableContent()).isEqualTo(expectedDeserts);
    }
}

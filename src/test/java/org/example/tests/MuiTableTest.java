package org.example.tests;

import org.example.framework.PlaywrightTestBase;
import org.example.framework.muitable.Desert;
import org.example.framework.muitable.MuiTableDocPage;
import org.example.framework.muitable.Person;
import org.example.framework.muitable.table.SortDirection;
import org.example.framework.muitable.table.enhanced.EnhancedTable;
import org.example.framework.muitable.table.grid.DataTable;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.framework.muitable.table.enhanced.EnhancedTable.Header.FAT_HEADING;

public class MuiTableTest extends PlaywrightTestBase {
    private static final List<Desert> DESERTS = List.of(
            new Desert("Frozen yoghurt", 159, 6, 24, 4),
            new Desert("Ice cream sandwich", 237, 9, 37, 4.3f),
            new Desert("Eclair", 262, 16, 24, 6),
            new Desert("Cupcake", 305, 3.7f, 67, 4.3f),
            new Desert("Gingerbread", 356, 16, 49, 3.9f)
    );
    private static final String DESERT_NAME_HEADING = "Dessert (100g serving)";
    private static final String CALORIES_HEADING = "Calories";
    private static final String FAT_HEADING_TXT = "Fat (g)";
    private static final String CARBS_HEADING = "Carbs (g)";
    private static final String PROTEIN_HEADING = "Protein (g)";

    @Test
    void basicTableTest() {
        assertThat(MuiTableDocPage.create(page).table().content()).isEqualTo(DESERTS);
    }

    @Test
    void dataTableTest() {
        DataTable dataTable = MuiTableDocPage.create(page).dataTable();
        List<Person> expectedContent = List.of(
                new Person(1, "Jon", "Snow", 35, "Jon Snow"),
                new Person(2, "Cersei", "Lannister", 42, "Cersei Lannister"),
                new Person(3, "Jaime", "Lannister", 45, "Jaime Lannister"),
                new Person(4, "Arya", "Stark", 16, "Arya Stark"),
                new Person(5, "Daenerys", "Targaryen", null, "Daenerys Targaryen")
        );

        assertThat(dataTable.content()).isEqualTo(expectedContent);
        assertThat(dataTable.selectedContent()).isEqualTo(List.of());

        DataTable dataTableAllRowsSelected = dataTable.selectAll();
        assertThat(dataTableAllRowsSelected.selectedContent()).isEqualTo(expectedContent);

        DataTable tableWithTwoRowsSelected = dataTableAllRowsSelected.deselectAll()
                .select(1).select(3);
        assertThat(tableWithTwoRowsSelected.selectedContent()).isEqualTo(List.of(
                expectedContent.get(1), expectedContent.get(3))
        );
    }

    @Test
    void enhancedTableTest() {
        EnhancedTable table = MuiTableDocPage.create(page).enhancedTable();
        assertThat(table.headers()).isEqualTo(List.of(
                DESERT_NAME_HEADING, CALORIES_HEADING, FAT_HEADING_TXT, CARBS_HEADING, PROTEIN_HEADING));

        List<Desert> tableContent = table.sortBy(FAT_HEADING, SortDirection.ASC).content();
        List<Desert> deserts = new ArrayList<>(tableContent);
        deserts.sort(Comparator.comparing(Desert::fat));
        assertThat(tableContent).isEqualTo(deserts);

        List<Desert> selectedContent = table.select(0).select(2).select(4).selectedContent();

        assertThat(selectedContent).isEqualTo(List.of(
                deserts.get(0), deserts.get(2), deserts.get(4)
        ));
    }

    @Test
    void checkSelectAllEnhancedTable() {
        EnhancedTable table = MuiTableDocPage.create(page).enhancedTable();

        assertThat(table.selectAll().deselect(0).isAllSelected()).isFalse();
    }
}

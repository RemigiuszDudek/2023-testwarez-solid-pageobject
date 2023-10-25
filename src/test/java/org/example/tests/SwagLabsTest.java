package org.example.tests;

import java.util.ArrayList;
import java.util.List;

import org.example.framework.TestBase;
import org.example.objects.Desert;
import org.example.pages.ReactTablePage;
import org.example.pages.sauceDemo.InventoryPage;
import org.example.pages.sauceDemo.LoginPage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SwagLabsTest extends TestBase {

    @Test
    public void openSwagPage() {
        List<Desert> expectedTable = new ArrayList<>();
        expectedTable.add(new Desert("Frozen yoghurt", "159", "6", "24", "4"));
        expectedTable.add(new Desert("Ice cream sandwich", "237", "9", "37", "4.3"));
        expectedTable.add(new Desert("Eclair", "262", "16", "24", "6"));
        expectedTable.add(new Desert("Cupcake", "305", "3.7", "67", "4.3"));
        expectedTable.add(new Desert("Gingerbread", "356", "16", "49", "3.9"));
        assertThat(new ReactTablePage().getDesertTable().equals(expectedTable));
    }
    @Test
    public void loginToSauceDemo() {
        new LoginPage().whenReady().login("standard_user", "secret_sauce");
        new InventoryPage().whenReady();
    }
}

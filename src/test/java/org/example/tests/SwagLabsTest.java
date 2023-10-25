package org.example.tests;

import org.example.framework.TestBase;
import org.example.models.Dessert;
import org.example.models.User;
import org.example.pages.swaglabs.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SwagLabsTest extends TestBase {
    @Test
    public void openSwagPage() {
        assertThat(true).isTrue();

    }

//    @Test
//    public void verifyProducts() {
//        DessertListPage dessertListPage = new DessertListPage(webDriver);
//
//        List<Dessert> expectedDeserts = new ArrayList<Dessert>();
//
//        expectedDeserts.add(new Dessert("Frozen yoghurt", 159, 6, 24, 4));
//        expectedDeserts.add(new Dessert("Ice cream sandwich", 237, 9, 37, 4.3f));
//        expectedDeserts.add(new Dessert("Eclair", 262, 16, 24, 6));
//        expectedDeserts.add(new Dessert("Cupcake", 305, 3.7f, 67, 4.3f));
//        expectedDeserts.add(new Dessert("Gingerbread", 356, 16, 49, 3.9f));
//
//        List<Dessert> actualDeserts = dessertListPage.getDesserts();
//
//        assertThat(actualDeserts).isEqualTo(expectedDeserts);
//    }

    @Test
    public void loginToSwagLabs(){
        User user = new User("standard_user", "secret_sauce");

        LoginPage loginPage = new LoginPage(webDriver);

        assertThat(loginPage
                .LogIn(user)
                .OnThePage())
                .isTrue(); //"user should be on the Inventory Page"
    }

    @Test
    public void loginToSwagLabsNegative(){
        User user = new User("standard_user", "aaa");

        LoginPage loginPage = new LoginPage(webDriver);

        assertThat(loginPage
                .LogIn(user)
                .OnThePage())
                .isFalse(); //"user should not be on the Inventory Page"
    }
}


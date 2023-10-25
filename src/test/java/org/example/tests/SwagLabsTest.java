package org.example.tests;

import org.example.framework.PlaywrightTestBase;
import org.example.framework.saucedemo.LoginPage;
import org.example.framework.saucedemo.cart.CartItemDescription;
import org.example.framework.saucedemo.cart.CartPage;
import org.example.framework.saucedemo.checkout.*;
import org.example.framework.saucedemo.entities.Currency;
import org.example.framework.saucedemo.entities.Price;
import org.example.framework.saucedemo.inventory.InventoryItem.InventoryItemDescription;
import org.example.framework.saucedemo.inventory.InventoryPage;
import org.example.framework.saucedemo.entities.TestUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static org.assertj.core.api.Assertions.assertThat;
import static org.example.framework.saucedemo.inventory.InventoryPage.SortBy.*;

class SwagLabsTest extends PlaywrightTestBase {
    private InventoryPage inventoryPage;

    @BeforeEach
    public void openInventoryPage() {
        this.inventoryPage = new LoginPage(page).login(TestUser.TEST_USER);
    }

    private static Stream<Arguments> sortingTestParams() {
        return Stream.of(
                Arguments.of(NAME_AZ, comparing(InventoryItemDescription::title)),
                Arguments.of(NAME_ZA, comparing(InventoryItemDescription::title).reversed()),
                Arguments.of(PRICE_HIGH_LOW, comparing((InventoryItemDescription it) -> it.price().amount()).reversed()),
                Arguments.of(PRICE_LOW_HIGH, comparing((InventoryItemDescription it) -> it.price().amount()))
        );
    }

    @ParameterizedTest
    @MethodSource("sortingTestParams")
    public void sortingInventoryWorksAsExpected(InventoryPage.SortBy sortBy, Comparator<InventoryItemDescription> expectedComparator) {
        List<InventoryItemDescription> content = inventoryPage.sort(sortBy).getContent();

        List<InventoryItemDescription> properlySorted = new ArrayList<>(content);
        properlySorted.sort(expectedComparator);

        assertThat(content).isEqualTo(properlySorted);
    }

    @Test
    public void buyingTwoItemsVanillaScenario() {
        String itemTitle_1 = "Sauce Labs Backpack";
        String itemTitle_2 = "Sauce Labs Bike Light";
        CartPage cartPage = addTwoItemsToCartAndOpenCart(itemTitle_1, itemTitle_2);

        List<CartItemDescription> itemsDescriptions = cartPage.getCartItemsDescriptions();
        assertThat(getCartTitles(itemsDescriptions)).isEqualTo(List.of(itemTitle_1, itemTitle_2));

        CheckoutOverviewPage checkoutOverviewPage = fillInCheckout(cartPage);
        assertThat(checkoutOverviewPage.getOverview()).isEqualTo(new CheckoutOverview(
                itemsDescriptions, "SauceCard #31337", "Free Pony Express Delivery!",
                new TotalPrice(
                        new Price(Currency.USD, new BigDecimal("39.98")),
                        new Price(Currency.USD, new BigDecimal("3.20")),
                        new Price(Currency.USD, new BigDecimal("43.18"))
                )
        ));

        InventoryPage backToInventoryPage = checkoutOverviewPage.clickFinish().clickBackHome();
        assertThat(backToInventoryPage).isNotNull();
    }

    private static CheckoutOverviewPage fillInCheckout(CartPage cartPage) {
        return cartPage
                .clickCheckout()
                .fillCheckoutDetails(new PostCheckoutDetails(new PostInformation("John", "Dow", "01-234")))
                .clickContinue();
    }

    private CartPage addTwoItemsToCartAndOpenCart(String itemTitle_1, String itemTitle_2) {
        return inventoryPage
                .addItemToCard(itemTitle_1)
                .addItemToCard(itemTitle_2)
                .openCart();
    }

    private static List<String> getCartTitles(List<CartItemDescription> cartItems) {
        return cartItems.stream().map(CartItemDescription::title).toList();
    }
}

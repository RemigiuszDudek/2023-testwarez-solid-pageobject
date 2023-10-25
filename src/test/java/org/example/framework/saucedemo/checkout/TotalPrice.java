package org.example.framework.saucedemo.checkout;

import com.microsoft.playwright.Page;
import org.example.framework.saucedemo.entities.Currency;
import org.example.framework.saucedemo.entities.Price;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public record TotalPrice(
        Price itemTotal,
        Price tax,
        Price total
) {
    private static final Pattern ITEM_TOTAL_PATTERN = Pattern.compile("Item total: (.)(.+)");
    private static final Pattern TAX_PATTERN = Pattern.compile("Tax: (.)(.+)");
    private static final Pattern TOTAL_PATTERN = Pattern.compile("Total: (.)(.+)");

    public static TotalPrice from(Page page) {
        String itemTotal = page.locator(".summary_subtotal_label").innerText();
        String tax = page.locator(".summary_tax_label").innerText();
        String total = page.locator(".summary_total_label").innerText();

        Matcher itemTotalMatcher = ITEM_TOTAL_PATTERN.matcher(itemTotal);
        Matcher taxMatcher = TAX_PATTERN.matcher(tax);
        Matcher totalMatcher = TOTAL_PATTERN.matcher(total);

        assertThat(itemTotalMatcher.matches()).isTrue();
        assertThat(taxMatcher.matches()).isTrue();
        assertThat(totalMatcher.matches()).isTrue();

        return new TotalPrice(
                new Price(Currency.from(itemTotalMatcher.group(1)), new BigDecimal(itemTotalMatcher.group(2))),
                new Price(Currency.from(taxMatcher.group(1)), new BigDecimal(taxMatcher.group(2))),
                new Price(Currency.from(totalMatcher.group(1)), new BigDecimal(totalMatcher.group(2)))
        );
    }
}

package org.example.framework.saucedemo.entities;

import java.math.BigDecimal;

import static org.junit.platform.commons.util.Preconditions.condition;

public record Price(Currency currency, BigDecimal amount) {
    public static Price create(String priceAsString) {
        condition(priceAsString.startsWith("$"), "only $ are supported");

        return new Price(Currency.USD, new BigDecimal(priceAsString.replace("$", "")));
    }
}

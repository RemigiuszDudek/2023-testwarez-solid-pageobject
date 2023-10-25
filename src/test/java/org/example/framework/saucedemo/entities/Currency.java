package org.example.framework.saucedemo.entities;

import static java.util.Arrays.stream;

public enum Currency {
    USD("$");

    private final String text;

    Currency(String text) {
        this.text = text;
    }

    public static Currency from(String currencyAsString) {
        return stream(Currency.values())
                .filter(c -> c.text.equals(currencyAsString))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("unrecognized currency, text=%s".formatted(currencyAsString)));
    }
}

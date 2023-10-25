package org.example.framework.swag;

import java.math.BigDecimal;

public record Price(
        BigDecimal value,
        String currency
) {
    public static Price create(String text) {
        return new Price(new BigDecimal(text.substring(1)), text.substring(0, 1));
    }
}

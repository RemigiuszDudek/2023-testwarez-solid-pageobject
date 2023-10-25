package org.example.framework.swag;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class PriceTest {
    @Test
    public void shouldCreatePriceFromText() {
        assertThat(Price.create("$9.99")).isEqualTo(new Price(new BigDecimal("9.99"), "$"));
    }

}
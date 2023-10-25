package org.example.grasp.informationexpert;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public record Measurement(BigDecimal value, Unit unit) {
    public Measurement add(Measurement other) {
        assertThat(unit).isEqualTo(other.unit);

        return new Measurement(value.add(other.value), unit);
    }
}

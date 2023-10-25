package org.example.grasp.informationexpert;

import static org.assertj.core.api.Assertions.assertThat;

public class MeasurementService {
    public static Measurement add(Measurement m1, Measurement m2) {
        assertThat(m1.unit()).isEqualTo(m2.unit());

        return new Measurement(m1.value().add(m2.value()), m1.unit());
    }
}

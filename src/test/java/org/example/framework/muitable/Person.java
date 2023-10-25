package org.example.framework.muitable;

import static org.assertj.core.api.Assertions.assertThat;

public record Person(
        int id,
        String firstName,
        String lastName,
        Integer age,
        String fullName
) {
    public Person {
        assertThat(fullName).isEqualTo("%s %s".formatted(firstName, lastName));
    }
}

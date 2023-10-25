package org.example.tests;

import org.example.framework.PlaywrightTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SwagLabsTest extends PlaywrightTest {
    @Test
    public void openSwagPage() {
        assertThat(true).isTrue();
    }
}

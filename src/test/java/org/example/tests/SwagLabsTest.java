package org.example.tests;

import org.example.framework.PlaywrightTestBase;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SwagLabsTest extends PlaywrightTestBase {
    @Test
    public void openSwagPage() {
        assertThat(true).isTrue();
    }
}

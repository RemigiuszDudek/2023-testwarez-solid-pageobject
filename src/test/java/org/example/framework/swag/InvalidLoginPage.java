package org.example.framework.swag;

import com.microsoft.playwright.Page;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class InvalidLoginPage extends LoginPage {
    public InvalidLoginPage(Page page) {
        super(page);

        assertThat(page.locator(".error-message-container")).hasText(Pattern.compile(".*Username and password do not match any user in this service"));
    }
}

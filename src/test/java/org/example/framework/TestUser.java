package org.example.framework;

public record TestUser(
        String username,
        String password
) {
    public static TestUser standardUser() {
        return new TestUser(
                "standard_user",
                "secret_sauce"
        );
    }
}

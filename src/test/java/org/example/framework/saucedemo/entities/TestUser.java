package org.example.framework.saucedemo.entities;

public record TestUser(String username, String password) {
    public static TestUser TEST_USER = new TestUser("standard_user", "secret_sauce");
}
